package com.yun.FClient;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

	private Socket s;
	
	public static void main(String[] args) {
		FileClient fc = new FileClient("localhost", 1988, "D:/test/1.pdf");
	}
	
	public FileClient(String host, int port, String file) {
		try {
			s = new Socket(host, port);
			sendFile(file);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendFile(String file) throws IOException{
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[4098];
		
		while(fis.read(buffer) > 0) {
			dos.write(buffer);
		}
		
		
		dos.writeUTF("11111111111");
		dos.writeLong(123);
		dos.writeInt(0x5678);
		
		fis.close();
		dos.close();
	}

}