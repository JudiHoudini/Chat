/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package window;
import client.Client;
import javax.swing.*;
import java.awt.GridLayout;
import listener.SendPortClient;

/**
 *
 * @author judi
 */
public class FenetreClient extends JFrame{
    JTextField port;
    JTextField host;
    JTextField chat;
    JPanel inscription;
    JPanel Message;
    JButton valider;
    Client client;

    public JPanel getInscription() {
        return inscription;
    }

    public void setInscription(JPanel inscription) {
        this.inscription = inscription;
    }

    public JPanel getMessage() {
        return Message;
    }

    public void setMessage(JPanel Message) {
        this.Message = Message;
    }

    public JTextField getPort() {
        return port;
    }

    public void setPort(JTextField port) {
        this.port = port;
    }

    public JTextField getChat() {
        return chat;
    }

    public void setChat(JTextField chat) {
        this.chat = chat;
    }

    public JButton getValider() {
        return valider;
    }

    public void setValider(JButton valider) {
        this.valider = valider;
    }

    public JTextField getHost() {
        return host;
    }

    public void setHost(JTextField host) {
        this.host = host;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
    

    public FenetreClient() {
        this.setInscription(this.mkInscription());
        this.add(this.getInscription());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,200);
    }
    public JPanel mkInscription(){
        JPanel valiny = new JPanel();
        JTextField port = new JTextField("9999");
        JLabel InfoPort = new JLabel("Veuillez entrer le port du server");
        JLabel InfoHost = new JLabel("Veuillez entrer l'IP du server");
        valiny.setLayout(new GridLayout(3,1));
        this.setPort(port);
        this.setHost(new JTextField("192.168.20.88"));
        this.getPort().setSize(200, 100);
        this.setValider(new JButton("Valider"));
        this.getValider().setSize(100,50);
        this.getValider().addActionListener(new SendPortClient(this));
        valiny.add(InfoHost);
        valiny.add(this.getHost());
        valiny.add(InfoPort);
        valiny.add(this.getPort());
        valiny.add(this.getValider());
        return valiny;
    }
    
    
}
