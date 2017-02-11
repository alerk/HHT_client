package com.qxn.connection;

import java.io.*;
import java.net.*;

public class HHTDisplayConnection implements Runnable{
	
		
	private String ip;
	private int port;
	private boolean isAddressSet = false;
	private final int MILISEC_200 = 200;
	private final int SEC_20 = 20*1000;
	private final int DISPLAY_BUFFER_SIZE = 1025;
		
	public void run() {		
		char[] cbuf = new char[DISPLAY_BUFFER_SIZE];
		while(true)	{
			if(isAddressSet) {								
				Socket clientSocket;
				try {
					clientSocket = new Socket(ip, port);
					//DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
					BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					while(true) {
						try {
							int byteRead = inFromServer.read(cbuf);
							if (byteRead > 0) {
								// TODO: send to HHTInputController to display
								// on the label
								// Maybe using callback function
							} else {
								System.out.println("[DisplayThread] Received nothing from server");
							}
						} catch (IOException ioe) {
							ioe.printStackTrace();
						} finally {
							clientSocket.close();
						}					
						Thread.sleep(MILISEC_200);	
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			else {
				//wait for 20 seconds;
				try {
					Thread.sleep(SEC_20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
	}
	
	public void setAddress(String ip, int port) {
		// TODO Auto-generated method stub
		this.ip = ip;
		this.port = port;
		isAddressSet = true;
	}
}
