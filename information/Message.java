/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package information;

import java.io.Serializable;

/**
 *
 * @author judi
 */
public class Message implements Serializable{
    InfoClient info;
    String Message;

    public InfoClient getInfo() {
        return info;
    }

    public void setInfo(InfoClient info) {
        this.info = info;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Message(InfoClient info, String Message) {
        this.setInfo(info);
        this.setMessage(Message);
    }

    public Message() {
    }
    
}
