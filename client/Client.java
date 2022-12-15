package client;

import information.InfoClient;
import information.Message;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Client extends Thread implements Serializable{
    InfoClient Info;
    Message message;
    String Host;
    int Port;

    public InfoClient getInfo() {
        return Info;
    }

    public void setInfo(InfoClient info) {
        this.Info = info;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }


    public Client() throws Exception {
        this.setInfo(new InfoClient());
    }

    public Client(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            this.setInfo(new InfoClient());
            this.setMessage(new Message(getInfo(), "coucou"));
            Socket socket = new Socket(this.getHost(), this.getPort());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(getMessage());
            oos.flush();
            oos.close();
            socket.close();
        } catch (Exception ex) {
        }

    }

}
