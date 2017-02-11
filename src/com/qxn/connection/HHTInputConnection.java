package com.qxn.connection;

import java.io.*;
import java.net.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HHTInputConnection implements Runnable{
	
	private String ip;
	private int port;
	private boolean isAddressSet = false;
	private final int MILISEC_200 = 200;
	private final int SEC_20 = 20*1000;
//	private final int INPUT_BUFFER_SIZE = 12;
	
	private BlockingQueue<Character> sendQueue = new ArrayBlockingQueue<>(10);
		
	public void run() {			
		while(true)	{
			if(isAddressSet) {
				try	{
					Socket clientSocket = new Socket(ip, port);
					DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
					//Write first dummy byte to server
					outToServer.writeByte('0');
					// BufferedReader inFromServer = new BufferedReader(new
					// InputStreamReader(clientSocket.getInputStream()));
					try {
						// TODO lock the sendBuffer, retrieve all and send to
						// server
						char v = sendQueue.take().charValue();
						outToServer.writeByte((int) v);
						// TODO: print send ok;
						System.out.println("Sent " + v + " to server");
						Thread.sleep(MILISEC_200);	
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					} finally {
						clientSocket.close();
					}					
				} catch (Exception e) {
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

	public void waitForConnection() {
		// TODO Auto-generated method stub
		
	}

	public void setAddress(String ip, int port) {
		// TODO Auto-generated method stub
		this.ip = ip;
		this.port = port;
		isAddressSet = true;
	}

	public void sendKey(char keyCode) {
		// TODO Push keyCode to sendBuffer
		try {
			sendQueue.put((Character)keyCode);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
