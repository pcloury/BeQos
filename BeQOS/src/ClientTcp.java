//importations
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.JList;
import java.util.*;



public class ClientTcp extends Thread{
	
	//port destination du routeur de bordure CE
	private int portDest;
	//boolean permettant de détecter le besoin d'une nouvelle reservation
	public boolean nouveauMessage = false;
	//message de reservation envoyé vers le routeur CE
	private Message message;
	
	public ClientTcp(int init_portDest) {
		this.portDest = init_portDest;
		
		
	}
	
	public void run() {
		//création du socket
		try {
		Socket client = new Socket("localhost",1500);
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
