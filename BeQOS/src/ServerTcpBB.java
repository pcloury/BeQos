package openjsip.proxy;

//importations
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.JList;
import java.util.*;


public class ServerTcpBB extends Thread{
	//port source du serveur
	public int portSource;
	//nbre de connections effectuées par des applis overIP a un instant donné
	public int nbrConnection;
	// clients tcp permettant de communiquer avec les deux CE
	private ClientTcpBB clientToLocalCE;
	private ClientTcpBB clientToDistantCE;
	
	
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
				
				//envoi de la réservation / libération
				
				
				//envoi vers CE local puis vers CE distant

				clientToLocalCE.envoiMessage(message);
				message.swap();
				clientToDistantCE.envoiMessage(message);

				
				
			}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur ServeurTcpBB");
		
		}

}
	public void setClientToDistantCE(ClientTcpBB init_client){
		this.clientToDistantCE = init_client;
	}
	
	public void setClientToLocalCE(ClientTcpBB init_client) {
		this.clientToLocalCE = init_client;
}
