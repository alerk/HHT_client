package com.qxn.view;

import java.util.Hashtable;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextArea;

import com.qxn.MainApp;
import com.qxn.connection.HHTConnection;

import com.qxn.interfaces.Callback;

public class HHTInputController implements Callback{
	@FXML
	private TextField txtIpAddr;
	@FXML
	private TextField txtInputPort;
	@FXML
	private TextField txtDisplayPort;
	
	@FXML
	private Label lblStatus;
	
	@FXML
	private TextArea txtDisplay;
	private String displayStr;
	
	
	
	//Reference to MainApp
	private MainApp mainApp;
	
	//Reference to HHTConnection;
	private HHTConnection hhtConn = new HHTConnection();
	
	//Hashtable for key input
	private Hashtable<String, Character> keyMapTable = new Hashtable<String, Character>(50);
	private void initKeyMapTable() {
		for(int i=0; i<=9;i++) {
			keyMapTable.put(String.valueOf(i), (char)('0'+i));
		}
		
		for(int i='A'; i<='F'; i++) {
			keyMapTable.put(String.valueOf((char)i), (char)(i));
		}		
		
		keyMapTable.put("Ent", '\r');
		keyMapTable.put("Clr", '\030');
		keyMapTable.put("Backspace", '\010');
		keyMapTable.put("Up", 'V');
		keyMapTable.put("Down", 'Y');
		keyMapTable.put("Left", 'Z');
		keyMapTable.put("Right", 'W');		
	}
	
	/**
	 * Constructor
	 */
	public HHTInputController() {
		initKeyMapTable();
	}
	
	@FXML
	private void initialize() {
		//Init something here
//		lblDisplay.textProperty().bind(hhtConn.getDisplayGenerator());	
		txtDisplay.textProperty().bind(hhtConn.getDisplayGenerator());
	}
	
	/**
	 * Function to set mainApp reference
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
		mainApp.hello();
		this.mainApp.getPrimaryStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				onKeyPressed(event);
			}			
		});
	}	
	
	@FXML
	private void onKeyPressed(KeyEvent event) {
		if(event.getText().matches("[0-9]")) {					
			buttonClicked(keyMapTable.get(event.getText()));
			lblStatus.setText("Button " + event.getText() + " clicked");
		}			
		else if (event.getText().matches("[a-f]")){
			buttonClicked(keyMapTable.get(event.getText().toUpperCase()));
			lblStatus.setText("Button " + event.getText().toUpperCase() + " clicked");
		}
		System.out.println("Button " + event.getText() + " clicked");
		event.consume();
	}
	
	@FXML
	private void onBtnConnectClicked() {
		if(txtIpAddr.getText().isEmpty() || txtInputPort.getText().isEmpty() || txtDisplayPort.getText().isEmpty())
		{
			System.out.println("Please input the ip and ports");
		}
		else
		{
			System.out.println("Connect to " + txtIpAddr.getText() + ":" + txtInputPort.getText() + ":" + txtDisplayPort.getText());
			hhtConn.connectToHHTGateway(txtIpAddr.getText(), Integer.parseInt(txtInputPort.getText()), Integer.parseInt(txtDisplayPort.getText()));
			//TODO assign some callback pattern here, maybe Command pattern
			hhtConn.registerDisplayCallback(this);
		}
	}
	
	@FXML
	private void onBtnEntClicked() {
		System.out.println("Ent!");
		buttonClicked(keyMapTable.get("Ent"));
		lblStatus.setText("Button Ent clicked");
	}
	
	@FXML
	private void onBtnClrClicked() {
		System.out.println("Clr!");
		buttonClicked(keyMapTable.get("Clr"));
		lblStatus.setText("Button Clr clicked");
	}
	
	@FXML
	private void onBtnBackspaceClicked() {
		System.out.println("Backspace!");
		buttonClicked(keyMapTable.get("Backspace"));	
		lblStatus.setText("Button Backspace clicked");
	}
	
	@FXML
	private void onBtnUpClicked() {
		System.out.println("Up!");
		buttonClicked(keyMapTable.get("Up"));
		lblStatus.setText("Button Up clicked");
	}
	
	@FXML
	private void onBtnDownClicked() {
		System.out.println("Down!");
		buttonClicked(keyMapTable.get("Down"));
		lblStatus.setText("Button Down clicked");
	}
	
	@FXML
	private void onBtnLeftClicked() {
		System.out.println("Left!");
		buttonClicked(keyMapTable.get("Left"));
		lblStatus.setText("Button Left clicked");
	}
	
	@FXML
	private void onBtnRightClicked() {
		System.out.println("Right!");
		buttonClicked(keyMapTable.get("Right"));
		lblStatus.setText("Button Right clicked");
	}
	
	@FXML
	private void onBtnAClicked() {
		System.out.println("A!");
		buttonClicked(keyMapTable.get("A"));
		lblStatus.setText("Button A clicked");
	}
	
	@FXML
	private void onBtnBClicked() {
		System.out.println("B!");
		buttonClicked(keyMapTable.get("B"));
		lblStatus.setText("Button B clicked");
	}
	
	@FXML
	private void onBtnCClicked() {
		System.out.println("C!");
		buttonClicked(keyMapTable.get("C"));
		lblStatus.setText("Button C clicked");
	}
	
	@FXML
	private void onBtnDClicked() {
		System.out.println("D!");
		buttonClicked(keyMapTable.get("D"));
		lblStatus.setText("Button D clicked");
	}
	
	@FXML
	private void onBtnEClicked() {
		System.out.println("E!");
		buttonClicked(keyMapTable.get("E"));
		lblStatus.setText("Button E clicked");
	}
	
	@FXML
	private void onBtnFClicked() {
		System.out.println("F!");
		buttonClicked(keyMapTable.get("F"));
		lblStatus.setText("Button F clicked");
	}
	
	@FXML
	private void onBtnZeroClicked() {
		System.out.println("Zero!");
		buttonClicked(keyMapTable.get("0"));
		lblStatus.setText("Button 0 clicked");
	}
	
	@FXML
	private void onBtnOneClicked() {
		System.out.println("One!");
		buttonClicked(keyMapTable.get("1"));
		lblStatus.setText("Button 1 clicked");
	}
	
	@FXML
	private void onBtnTwoClicked() {
		System.out.println("Two!");
		buttonClicked(keyMapTable.get("2"));
		lblStatus.setText("Button 2 clicked");
	}
	
	@FXML
	private void onBtnThreeClicked() {
		System.out.println("Three!");
		buttonClicked(keyMapTable.get("3"));
		lblStatus.setText("Button 3 clicked");
	}
	
	@FXML
	private void onBtnFourClicked() {
		System.out.println("Four!");
		buttonClicked(keyMapTable.get("4"));
		lblStatus.setText("Button 4 clicked");
	}
	
	@FXML
	private void onBtnFiveClicked() {
		System.out.println("Five!");
		buttonClicked(keyMapTable.get("5"));
		lblStatus.setText("Button 5 clicked");
	}
	
	@FXML
	private void onBtnSixClicked() {
		System.out.println("Six!");
		buttonClicked(keyMapTable.get("6"));
		lblStatus.setText("Button 6 clicked");
	}
	
	@FXML
	private void onBtnSevenClicked() {
		System.out.println("Seven!");
		buttonClicked(keyMapTable.get("7"));
		lblStatus.setText("Button 7 clicked");
	}
	
	@FXML
	private void onBtnEightClicked() {
		System.out.println("Eight!");
		buttonClicked(keyMapTable.get("8"));
		lblStatus.setText("Button 8 clicked");
	}
	
	@FXML
	private void onBtnNineClicked() {
		System.out.println("Nine!");
		buttonClicked(keyMapTable.get("9"));
		lblStatus.setText("Button 9 clicked");
	}	

	public void buttonClicked(char keyCode){
		//TODO: send to HHTConnection > HHTInputConnection		
		hhtConn.sendKey(keyCode);
	}

	@Override	
	public void execute(char[] arr) {
		// TODO Auto-generated method stub
		//lblDisplay.setText(String.valueOf(arr));
		displayStr = String.valueOf(arr);
		displayStr.replaceAll("\033.*?f", "\n");
		displayStr.replaceAll("\033.*?H", "");		
		System.out.println("Received text: " + displayStr);
		//updateDisplayString(displayStr);
	}
	
	public void stop() {
		hhtConn.stopConnection();
	}
}
