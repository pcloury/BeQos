//importations
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.text.*;




public class Message implements Serializable{
	private String ipSource;
	private String ipDest;
	//action a effectuer : ajouter une règle avec A, supprimer avec D
	private String action;
	
	private int portDestLocal;
	
	private int portDestDistant;
	
	public Message(String init_ipSource, String init_ipDest, int init_portDestLocal, int init_portDestDistant, String init_action) {
		this.ipSource = init_ipSource;
		this.ipDest = init_ipDest;
		this.portDestLocal = init_portDestLocal;
		this.portDestDistant = init_portDestDistant;
		this.action = init_action;
	}
	
	public String getIpSource() {
		return this.ipSource;
	}
	
	public String getIpDest() {
		return this.ipDest;
	}
	
	public int getPortDestLocal() {
		return this.portDestLocal;
	}
	
	public int getPortDestDistant() {
		return this.portDestDistant;
	}
	
	public String getAction() {
		return this.action;
	}
	
	public void setIpSource(String ipS) {
		this.ipSource = ipS;
	}
	
	public void setIpDest(String ipD) {
		this.ipDest = ipD;
	}
	
	public void setPortDestLocal (int pDest) {
		this.portDestLocal = pDest;
	}
	
	public void setPortDestDistant( int pDest) {
		this.portDestDistant = pDest;
		
	}
	
	public void setAction( String ac) {
		this.action = ac;
	}
	//permet d'échanger les adresses ip et ports, pour pouvoir
	//reserver de "gauche a droite" ou de "droite a gauche" (CE BB -> CE distant
	// ou l'inverse)
	public void swapIp() {
		String ip = ipSource;
		this.ipSource = this.ipDest;
		this.ipDest = ip;
		int port = portDestLocal;
		portDestLocal = portDestDistant;
		portDestDistant = port;
		
	}
	
	

}
