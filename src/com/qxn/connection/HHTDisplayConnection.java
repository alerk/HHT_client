package com.qxn.connection;

import java.io.*;
import java.net.*;

import com.qxn.interfaces.Callback;

import javafx.concurrent.Task;

public class HHTDisplayConnection extends Task<Void> implements Runnable{
	
		
	private String ip;
	private int port;
	private boolean isAddressSet = false;
	private String displayStr;
	private boolean isRequestStop = false;
	
	private Callback handler;
	
	private final static int MILISEC_50 = 50;
	private final static int SEC_20 = 20*1000;
	private final static int DISPLAY_BUFFER_SIZE = 1024;
		
	public void run() {		
		char[] cbuf = new char[DISPLAY_BUFFER_SIZE];
		while(true)	{
			if(isAddressSet) {
				try {
					Socket clientSocket = new Socket(ip, port);					
					//DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
					BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					int byteRead = -1;

					do {							
						byteRead = inFromServer.read(cbuf);
						if (byteRead > 0) {
							// TODO: send to HHTInputController to display on the label							// 
							//onReceivedDisplayBuffer(cbuf);
							String oldDisplayStr = "";
							if(displayStr!=null) {
								oldDisplayStr = displayStr;
							}							 
							displayStr = String.valueOf(cbuf);
							displayStr = displayStr.replaceAll("\\[[0-9];1f", System.getProperty("line.separator"));
							displayStr = displayStr.replaceAll("\\[[0-9];[0-9]f[0-9]", "");
							displayStr = displayStr.replaceAll("\\[2;[0-9]f\\s?", "");
							displayStr = displayStr.replaceAll("[0-9]f1\\s", "");
							displayStr = displayStr.replaceAll("f1\\s", "");
							displayStr = displayStr.replaceAll("\\[1;20f", "");
							displayStr = displayStr.replaceAll("\\[1;20H", "");
							displayStr = displayStr.replaceAll("\\[2J", "");
							if(!oldDisplayStr.equalsIgnoreCase(displayStr)) {
								call();
							}							
						} else {
							System.out.println("[DisplayThread] Received nothing from server");
						}
						Thread.sleep(MILISEC_50);
						if(isRequestStop) {							
							break;
						}
					} while(byteRead>0);
					clientSocket.close();
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
			if(isRequestStop) {							
				break;
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void onReceivedDisplayBuffer(char[] cbuf) {
		// TODO Auto-generated method stub
		handler.execute(cbuf);		
	}

	public void setAddress(String ip, int port) {
		// TODO Auto-generated method stub
		this.ip = ip;
		this.port = port;
		isAddressSet = true;
	}

	public void registerCallback(Callback callback) {
		// TODO Auto-generated method stub
		this.handler = callback;
	}
	
	@Override
	protected Void call() throws Exception {
		// TODO Auto-generated method stub
		updateMessage(displayStr);
		System.out.println(displayStr);
		return null;
	}
	
	public void stopConnection() {
		// TODO Auto-generated method stub
		isRequestStop = true;		
	}
	
	
}
