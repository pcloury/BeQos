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
	private int portDest;
	
	public Message(String init_ipSource, String init_ipDest, int init_portDest) {
		this.ipSource = init_ipSource;
		this.ipDest = init_ipDest;
		this.portDest = init_portDest;
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
	
	public void setIpSource(String ipS) {
		this.ipSource = ipS;
	}
	
	public void setIpDest(String ipD) {
		this.ipDest = ipD;
	}
	
	public void setPortDest (int pDest) {
		this.portDest = pDest;
	}
	
	

}
