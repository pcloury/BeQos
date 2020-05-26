package openjsip.proxy;

//importations
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.JList;
import java.util.*;


public class ServerTcpBB extends Thread{
	public int portSource;
	public int nbrConnection;
	
	private ClientTcpBB clientBB;
	public ServerTcpBB(int init_portSource) {
		this.portSource = init_portSource;
		start();
	}
	
	public void run() {
		try {
			System.out.println("Lancement Serveur BB");
			ServerSocket server = new ServerSocket(portSource);
			Socket client = server.accept();
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			
			while(true) {
				Message message = (Message) in.readObject();
				if (message.getAction().equals("A") && this.nbrConnection <3){
					clientBB.envoiMessage(message);
					nbrConnection ++;
					System.out.println("On a une demande de connexion en plus acceptee");

				} else if(message.getAction().equals("D")){
					nbrConnection --;
					System.out.println("On a une demande de fin de connexion");
				}			
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur ServeurTcpBB");
		
		}

}
	public void setClientTcp(ClientTcpBB init_client){
		this.clientBB = init_client;
	}
}
