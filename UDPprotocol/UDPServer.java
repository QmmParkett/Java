package UDPprotocol;
//What you need on the server side is:The DatagramSocket to accept the data
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		//you have to mention the port number,and handle an Exception
		DatagramSocket ds = new DatagramSocket(9999);

		byte[] b1 = new byte[1024];
		//accepting data from the client 
		//again we require the byte array
		DatagramPacket dp = new DatagramPacket(b1, b1.length);
		ds.receive(dp);
		//in dp we have the data coming from client,so we want to fetch the data from it 
		String str = new String(dp.getData(), 0, dp.getLength());
		//alter the information from the client
		int num = Integer.parseInt(str.trim());
		int result = num * num;
		//send information back to client
		//another datagramPacket
		byte[] b2 = String.valueOf(result).getBytes();
		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
		ds.send(dp1);
		if (ds != null) {
			ds.close();
		}
	}

}
