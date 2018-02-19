package TCPprotocol;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//foe every socket made in the client,we should make a socket in the server
public class TCPServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss =new ServerSocket(9999);
		//the socket is used to accept connection when a request is made by the client
		Socket s = ss.accept();
		//a msg in order to understand if the connection is successful
		System.out.println("connected");
		//because we used OutputStream in the Client side,now we need to use InputStream here
		DataInputStream din = new DataInputStream(s.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//use while loop,as long as the the client is sending msgs
		while(true) {
			String str1=din.readUTF();
			//displaying the input on the server
			System.out.println("client: "+str1);
				if(str1.equalsIgnoreCase("exit"))
					break;
		}
		ss.close();

	}

}
