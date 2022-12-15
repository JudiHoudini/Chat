/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package affichage;

import information.InfoClient;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import window.FenetreClient;
import window.FenetreServeur;

/**
 *
 * @author judi
 */
public class Main {
    public static void main(String[] args) {
        try {
            FenetreServeur f = new FenetreServeur();
            FenetreClient fC = new FenetreClient();
            InfoClient inf = new InfoClient();
            Vector add = inf.getListeElementAttributs();
            for (int i = 0; i < add.size(); i++) {
                System.out.println(add.get(i));
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
