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
	
	private int portDest;
	
	
	public Message(String init_ipSource, String init_ipDest, int init_portDest, String init_action) {
		this.ipSource = init_ipSource;
		this.ipDest = init_ipDest;
		this.portDest = init_portDest;
		this.action = init_action;
	}
	
	public String getIpSource() {
		return this.ipSource;
	}
	
	public String getIpDest() {
		return this.ipDest;
	}
	
	public int getPortDest() {
		return this.portDest;
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
	
	public void setPortDest (int pDest) {
		this.portDest = pDest;
	}
	
	public void setAction( String ac) {
		this.action = ac;
	}
	
	

}
