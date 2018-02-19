package TCPprotocol;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//first we need to create a connection to the server
//the connection is made with the Socket class
//the socket acts as an end-to-end connection
public class TCPClient {
	public static void main(String[] args) throws Exception {
		//throw Exception for the port number

		// the socket takes 2 parameters the localHost(because the server and the client
		// are on the same machine then the port number
		Socket s = new Socket("localhost", 9999);
		// we need to create a DataOutputStream,because we can't send raw data from
		// client to server directly
		// we have to convert it to streams
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		// we use the socket object to send the data
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// we use the bufferReader to take input from the user
		// the use of while loop is,because the message is being send continuously
		while (true) {
			// converting the user input to a string
			String str = br.readLine();
			// then write the user input into the stream object,which is received at the
			// server side
			dout.writeUTF(str);
			if(str.equalsIgnoreCase("exit"))
				break;
		}
		s.close();
	}
}
