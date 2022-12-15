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

public class Serveur extends Thread{
    Vector<Client> lsClient = new Vector<>();
    ServerSocket serveur;
    int port;

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
    
    
    public static Socket createServer(int port) throws Exception{
        ServerSocket server=new ServerSocket(port);
        Socket socket=server.accept();
        return socket;
    }
    

    public Serveur(int port) throws IOException {
        this.setPort(port);
    }
    

    @Override
    public void run() {
        try {
            this.setServeur(new ServerSocket(this.getPort()));
            Socket socket = this.getServeur().accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message msg = (Message) ois.readObject();
            InfoClient inf = msg.getInfo();
            System.out.println(inf);
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
            if(getLsClient().get(i).getMessage().getInfo().equals(inf))return;
        }
        this.getLsClient().add(c);
    }
}
    
    
    

