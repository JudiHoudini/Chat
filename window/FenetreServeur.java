/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package window;

import javax.swing.*;
import java.awt.GridLayout;
import listener.SendPortServer;
import serveur.Serveur;

/**
 *
 * @author judi
 */
public class FenetreServeur extends JFrame{
    JTextField port;
    JPanel inscription;
    JPanel lsClient;
    JButton valider;
    Serveur serveur;

    public JTextField getPort() {
        return port;
    }

    public void setPort(JTextField port) {
        this.port = port;
    }

    public JPanel getInscription() {
        return inscription;
    }

    public void setInscription(JPanel inscription) {
        this.inscription = inscription;
    }

    public JPanel getLsClient() {
        return lsClient;
    }

    public void setLsClient(JPanel lsClient) {
        this.lsClient = lsClient;
    }

    public JButton getValider() {
        return valider;
    }

    public void setValider(JButton valider) {
        this.valider = valider;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }
    
    public void mkInscription(){
        JPanel valiny = new JPanel();
        JTextField port = new JTextField("9999");
        JLabel InfoPort = new JLabel("Veuillez choisir le port du server");
        this.setPort(port);
        this.setValider(new JButton("Valider"));
        valiny.setLayout(null);
        valiny.setSize(300,300);
        valiny.add(port);
        valiny.add(InfoPort);
        valiny.add(this.getValider());
        InfoPort.setBounds(40, 0, 250, 50);
        this.getValider().setBounds(100, 110, 100, 30);
        this.getValider().addActionListener(new SendPortServer(this));
        this.getPort().setBounds(100, 50, 100, 50);
        this.setInscription(valiny);
    }

    public FenetreServeur() {
        this.mkInscription();
        this.add(this.getInscription());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300,200);
    }
    public void mkLClient(){
        JTable listeClient = new JTable
    }
    
}
