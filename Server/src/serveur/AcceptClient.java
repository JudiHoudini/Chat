package serveur;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class AcceptClient extends Thread {
	Socket socket;

	public AcceptClient(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run() {
		while (true) {
			try {
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter ow = new OutputStreamWriter(os);
				BufferedWriter wr = new BufferedWriter(ow);
				
				wr.write("test\n");
				wr.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
