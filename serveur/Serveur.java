package serveur;

import client.Client;
import information.InfoClient;
import information.Message;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import window.FenetreServeur;

public class Serveur extends Thread{
    Vector<Client> lsClient = new Vector<>();
    ServerSocket serveur;
    int port;
    FenetreServeur fenetre;

    public ServerSocket getServeur() {
        return serveur;
    }

    public void setServeur(ServerSocket serveur) {
        this.serveur = serveur;
    }

    public Vector<Client> getLsClient() {
        return lsClient;
    }

    public void setLsClient(Vector<Client> lsClient) {
        this.lsClient = lsClient;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public FenetreServeur getFenetre() {
        return fenetre;
    }

    public void setFenetre(FenetreServeur fenetre) {
        this.fenetre = fenetre;
    }
    
    
    public static Socket createServer(int port) throws Exception{
        ServerSocket server=new ServerSocket(port);
        Socket socket=server.accept();
        return socket;
    }
    

    public Serveur(int port,FenetreServeur f) throws IOException {
        this.setPort(port);
        this.setFenetre(f);
    }
    

    @Override
    public void run() {
        try {
            this.setServeur(new ServerSocket(this.getPort()));
            Socket socket = this.getServeur().accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message msg = (Message) ois.readObject();
            InfoClient inf = msg.getInfo();
            this.addClient(msg);
            this.getFenetre().mkLsClient();
            //System.out.println(inf);
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                this.getServeur().close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        this.run();
    }
    public void addClient(Message m){
        Client c = new Client(m);
        InfoClient inf = m.getInfo();
        for (int i = 0; i < getLsClient().size(); i++) {
            if(getLsClient().get(i).getMessage().getInfo().getUserName().equals(inf.getUserName())){
                return;
            }
        }
        this.getLsClient().add(c);
    }
    public Vector<Vector> getLsInfoClients() throws Exception{
        Vector<Vector> valiny = new Vector<>();
        for (int i = 0; i < this.getLsClient().size(); i++) {
            valiny.add(this.getLsClient().get(i).getMessage().getInfo().getListeElementAttributs());
        }
        return valiny;
    }
}
    
    
    

