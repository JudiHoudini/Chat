/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;
import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import window.FenetreClient;

/**
 *
 * @author judi
 */
public class SendPortClient implements ActionListener {
    FenetreClient client;

    public FenetreClient getClient() {
        return client;
    }

    public void setClient(FenetreClient client) {
        this.client = client;
    }

    public SendPortClient(FenetreClient client) {
        this.client = client;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            this.getClient().setClient(new Client());
            this.getClient().getClient().setHost(this.getClient().getHost().getText());
            this.getClient().getClient().setPort(Integer.parseInt(this.getClient().getPort().getText()));
            this.getClient().getClient().start();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
}
