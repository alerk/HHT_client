package com.qxn.connection;




import com.qxn.connection.HHTInputConnection;
import com.qxn.connection.HHTDisplayConnection;
import com.qxn.interfaces.Callback;

import javafx.beans.value.ObservableValue;

public class HHTConnection {
	private HHTInputConnection inputConn = new HHTInputConnection();;
	private HHTDisplayConnection displayConn = new HHTDisplayConnection();;
	
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
		displayConn.setAddress(ip, port);
		getDisplayThread = new Thread(displayConn, "Display Thread");
		getDisplayThread.start();
	}
	
	private void connectToHHTGatewayInput(String ip, int port) {		
		inputConn.setAddress(ip, port);
		inputThread = new Thread(inputConn, "Input Thread");
		inputThread.start();		
	}

	public void sendKey(char keyCode) {
		// TODO Send key to inputConn
		inputConn.sendKey(keyCode);		
	}

	public void registerDisplayCallback(Callback callback) {
		// TODO Auto-generated method stub
		displayConn.registerCallback(callback);		
	}

	public ObservableValue<? extends String> getDisplayGenerator() {
		// TODO Auto-generated method stub
		return this.displayConn.messageProperty();
	}
}
