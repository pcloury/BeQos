//importations
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.JList;
import java.util.*;


public class ServeurTcpCE extends Thread{
	public int portSource;
	
	public ServeurTcpCE(int init_portSource) {
		this.portSource = init_portSource;
		start();
	}
	
	public void run() {
		try {
			System.out.println("Lancement Serveur CE");
			ServerSocket server = new ServerSocket(portSource);
			Socket client = server.accept();
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			
			while(true) {
				Message message = (Message) in.readObject();
				String homeDirectory = System.getProperty("user.home");
				String commande = "iptables -" + message.getAction() +  " POSTROUTING -t mangle -d " + message.getIpDest()
				+ " -s " + message.getIpSource() + " -j MARK --set-mark 20; " 
				+ "iptables -" + message.getAction() + " PREROUTING -t mangle -d " + message.getIpDest()
				+ " -s " + message.getIpSource() + " -j MARK --set-mark 20; ";
				System.out.println(commande);
				commande = "echo";
				try {
					Process process = Runtime.getRuntime().exec(String.format(commande, homeDirectory));
					int exitCode = process.waitFor();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur ServeurTcpCE");
		
		}

}
}
