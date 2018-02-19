package UDPprotocol;
//Step1:Create a socket
//Step2:Send data to the server
//Step3:Get response

//Send some information from the client to the server,and get the servers response

//UDP is a connection-less protocol
//In UDP you don`t have a connection,so every packet should know where it is going
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		//to work with UDP we require a special socket -> DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		//no need to mention any IP address,because socket doesn't know which server you want to connect to
		//it is your packet that knows
		//NB! DatagramSocket may throw an Exception 

		//to send the data first we need to take the data from the user
		int i = 8;
		//creating a byte array to store the data
		byte[] b = String.valueOf(i).getBytes();
		//to make the IP address,we use the Inet class
		InetAddress ia = InetAddress.getLocalHost();
		//In order to send data to server,we need to use DatagramPacket
		//When creating a DatagramPacket for sending information,you need to mention 4 parameters
		//									  data,data length,IP address,port number
		//First problem that needs addressing,is that it receives data in a byte format line 25
		//for the port number,just any available port
		DatagramPacket dp = new DatagramPacket(b, b.length, ia, 9999);
		//sending data
		//sending the packet through the socket
		ds.send(dp);
		
		//after the server has processed the data,we have to accept the data,so we need a new DatagramPacket
		// Accepting the data
		//this b1 is the data coming from the server,but it is empty right now so just add some size
		byte[] b1 = new byte[1024];
		//when receiving you don't have to mention the port number
		DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
		//receiving the data in dp1
		ds.receive(dp1);
		//printing the data
		//dp1.getData(0 is fetching data from the user
		String str = new String(dp1.getData(), 0, dp1.getLength());
		System.out.println("result is " + str);
		//ALWAYS CLOSE THE SOCKET!!!
		if (ds != null) {
			ds.close();
		}

	}

}
