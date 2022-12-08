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

public class Server{
    Message
    public static Socket createServer(int port) throws Exception{
        ServerSocket server=new ServerSocket(port);
        Socket socket=server.accept();
        return socket;
    }
    public static void main(String[] args) throws IOException {
        Vector<InfoClient> infos = new Vector<>();
        ServerSocket server = null;
        while (true) {            
            try {
                server = new ServerSocket(9999);
                Socket socket = server.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message msg = (Message) ois.readObject();
                InfoClient inf = msg.getInfo();
                System.out.println(inf);
                socket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                server.close();
            }
        }
    }
    
    
}
