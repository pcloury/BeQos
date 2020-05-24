
public class main {
	public static void main (String[] args) {
		ServeurTcpCE serv = new ServeurTcpCE(5000);
		Message message = new Message("192.168.1.1","192.168.1.2", 3000, "D");
		ClientTcpBB client = new ClientTcpBB(5000);
		client.envoiMessage(message);
	}

}
