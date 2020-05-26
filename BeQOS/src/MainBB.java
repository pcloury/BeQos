
public class MainBB {
	public static void main (String[] args) {
		
		ClientTcpBB clientToLocalCe = new ClientTcpBB("192.168.37.254",5000);
		ClientTcpBB clientToDistantCe = new ClientTcpBB("192.168.38.254",5000);
		ServerTcpBB serveurFromProxy = new ServerTcpBB(5000);
		serveurFromProxy.setClientToDistantCE(clientToDistantCe);
		serveurFromProxy.setClientToLocalCE(clientToLocalCe);
		serveurFromProxy.start();
		
	}

}
