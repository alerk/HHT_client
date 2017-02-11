package com.qxn.connection;



import com.qxn.connection.HHTInputConnection;
import com.qxn.connection.HHTDisplayConnection;

public class HHTConnection {
	private HHTInputConnection inputConn;
	private HHTDisplayConnection displayConn;
	
	private Thread getDisplayThread;
	private Thread inputThread;
	
	public void connectToHHTGateway(String ip, int inputPort, int displayPort)
	{
		connectToHHTGatewayInput(ip, inputPort);
		connectToHHTGatewayDisplay(ip, displayPort);
	}
	
	public void disconnectToHHTGateway()
	{
		
	}
	
	
	private void connectToHHTGatewayDisplay(String ip, int port) {
		displayConn = new HHTDisplayConnection();
		displayConn.setAddress(ip, port);
		getDisplayThread = new Thread(displayConn, "Display Thread");
		getDisplayThread.start();
	}
	
	private void connectToHHTGatewayInput(String ip, int port) {
		inputConn = new HHTInputConnection();
		inputConn.setAddress(ip, port);
		getDisplayThread = new Thread(inputConn, "Input Thread");
		inputThread.start();		
	}

	public void sendKey(char keyCode) {
		// TODO Send key to inputConn
		inputConn.sendKey(keyCode);		
	}

}
