
public class MainBB {
	public static void main (String[] args) {
		ClientTcpBB clientToLocalCe = new ClientTcpBB("192.168.37.254",5000);
		ClientTcpBB clienttoDistantCe = new ClientTcpBB("192.138.38.254",5000);
	}

}
