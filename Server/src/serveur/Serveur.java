package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	public static void main(String[] args) {
		int port = 2273;
		ServerSocket socketServer = null;
		
		Socket socket = null;
		
		try {
			socketServer = new ServerSocket(port);
			System.out.println("SRV- le serveur est a l'ecoute du port "+socketServer.getLocalPort());
			
			socket = socketServer.accept();
			System.out.println("connecté");
			
			AcceptClient t = new AcceptClient(socket);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
