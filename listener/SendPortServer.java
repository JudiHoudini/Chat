/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import serveur.Serveur;
import window.FenetreServeur;

/**
 *
 * @author judi
 */
public class SendPortServer implements ActionListener {
    FenetreServeur serveur;

    public FenetreServeur getServeur() {
        return serveur;
    }

    public void setServeur(FenetreServeur serveur) {
        this.serveur = serveur;
    }

    public SendPortServer(FenetreServeur serveur) {
        this.serveur = serveur;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int port = Integer.parseInt(this.getServeur().getPort().getText());
        try {
            this.getServeur().setServeur(new Serveur(port,this.getServeur()));
            this.getServeur().getServeur().start();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
}
