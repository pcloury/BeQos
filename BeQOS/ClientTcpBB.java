//importations
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.JList;
import java.util.*;



public class ClientTcpBB extends Thread{
	
	//port destination du routeur de bordure CE
	private int portDest;
	//boolean permettant de détecter le besoin d'une nouvelle reservation
	public boolean nouveauMessage = false;
	//message de reservation envoyé vers le routeur CE
	private Message message;
	
	public ClientTcpBB(int init_portDest) {
		this.portDest = init_portDest;
		start();
	}
	
	
	
	public void run() {
		//création du socket
		try {
			System.out.println("Lancement Client BB \n");
			Socket client = new Socket("localhost",portDest);
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			while(true){
				//si on a une nouvelle reservation à effectuer :
				if (nouveauMessage) {
					//envoie du message
					out.writeObject(message);
					out.flush();
				}
				this.nouveauMessage = false;
				
			
			}	
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void envoiMessage(Message m) {
		this.message = m;
		this.nouveauMessage = true;
		
	}
		

	

}
