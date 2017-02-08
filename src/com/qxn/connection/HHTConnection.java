package com.qxn.connection;

import java.io.*;
import java.net.*;

import com.qxn.connection.HHTInputConnection;
import com.qxn.connection.HHTOutputConnection;

public class HHTConnection {
	private HHTInputConnection inputConn;
	private HHTOutputConnection outputConn;
	
	
	public void connectToHHTGateway(String ip, int port) {
		outputConn = new HHTOutputConnection();
		outputConn.setAddress(ip, port);
		outputConn.start();
	}
	
	public void listenFromHHTGateway() {
		inputConn = new HHTInputConnection();
		inputConn.waitForConnection();
		inputConn.start();
	}

}
