/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package information;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.Integer;
import java.net.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author judi
 */
public class InfoClient implements Serializable{
    String UserName;
    String OS;
    String OSVersion;
    String CPU;
    int Cores;
    String AddressIp;
    String AddressMac;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getOSVersion() {
        return OSVersion;
    }

    public void setOSVersion(String OSVersion) {
        this.OSVersion = OSVersion;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getCores() {
        return Cores;
    }

    public void setCores(int Cores) {
        this.Cores = Cores;
    }

    public String getAddressIp() {
        return AddressIp;
    }

    public void setAddressIp(String AddressIp) {
        this.AddressIp = AddressIp;
    }

    public String getAddressMac() {
        return AddressMac;
    }

    public void setAddressMac(String AddressMac) {
        this.AddressMac = AddressMac;
    }

    public InfoClient()throws Exception {
        String userName = System.getProperty("user.name");
       
        String OS = System.getProperty("os.name");
        String OSVersion = System.getProperty("os.version");
        int cores = Runtime.getRuntime().availableProcessors();
        this.setAddressIp(this.obtenirAddressIp());
        this.setAddressMac(this.obtenirAdressMac());
        this.setCores(cores);
        this.setOS(OS);
        this.setOSVersion(OSVersion);
        this.setUserName(userName);
    }

    @Override
    public String toString() {
        return "InfoClient{" + "UserName=" + UserName + ", OS=" + OS + ", OSVersion=" + OSVersion + ", CPU=" + CPU + ", Cores=" + Cores + ", AddressIp=" + AddressIp + ", AddressMac=" + AddressMac + '}';
    }
    
    
    public String obtenirAdressMac() throws Exception{
         String addressMac = null;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface ni = networkInterfaces.nextElement();
            byte[] hardwareAddress = ni.getHardwareAddress();
            if (hardwareAddress != null) {
                String[] hexadecimalFormat = new String[hardwareAddress.length];
                for (int i = 0; i < hardwareAddress.length; i++) {
                    hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
                }
                addressMac =String.join(":", hexadecimalFormat);
            }
        }
        return addressMac;
    }
    public String obtenirAddressIp() throws Exception{
        InetAddress ip= InetAddress.getLocalHost();
        return ip.getHostAddress();
    }
    
    public Vector<String> getListeNomAttributs(){
        Vector<String> valiny = new Vector<>();
        for (int i = 0; i < this.getClass().getDeclaredFields().length; i++) {
            valiny.add(this.getClass().getDeclaredFields()[i].getName());
        }
        return valiny;
    }
    public Vector<String> getListeElementAttributs() throws Exception{
        Vector<String> valiny = new Vector<>();
        for (int i = 0; i < this.getClass().getDeclaredFields().length; i++) {
            Method m = this.getClass().getMethod("get"+this.getClass().getDeclaredFields()[i].getName());
            if(this.getClass().getDeclaredFields()[i].getType().equals(int.class)){
                int add = (int) m.invoke(this);
                valiny.add(String.valueOf(add));
            }else{
                String add =  (String) m.invoke(this);
                valiny.add(add);
            }
        }
        return valiny;
    }
}
