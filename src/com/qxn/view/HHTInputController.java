package com.qxn.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
//import javafx.scene.control.TextArea;
import com.qxn.MainApp;
import com.qxn.connection.HHTConnection;
import java.util.Hashtable;
import com.qxn.interfaces.Callback;

public class HHTInputController implements Callback{
	@FXML
	private TextField txtIpAddr;
	@FXML
	private TextField txtInputPort;
	@FXML
	private TextField txtDisplayPort;
	
	@FXML
	private Label lblDisplay;
	
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
	}
	
	/**
	 * Function to set mainApp reference
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		mainApp.hello();
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
	}
	
	@FXML
	private void onBtnClrClicked() {
		System.out.println("Clr!");
		buttonClicked(keyMapTable.get("Clr"));
	}
	
	@FXML
	private void onBtnBackspaceClicked() {
		System.out.println("Backspace!");
		buttonClicked(keyMapTable.get("Backspace"));		
	}
	
	@FXML
	private void onBtnUpClicked() {
		System.out.println("Up!");
		buttonClicked(keyMapTable.get("Up"));
	}
	
	@FXML
	private void onBtnDownClicked() {
		System.out.println("Down!");
		buttonClicked(keyMapTable.get("Down"));
	}
	
	@FXML
	private void onBtnLeftClicked() {
		System.out.println("Left!");
		buttonClicked(keyMapTable.get("Left"));
	}
	
	@FXML
	private void onBtnRightClicked() {
		System.out.println("Right!");
		buttonClicked(keyMapTable.get("Right"));
	}
	
	@FXML
	private void onBtnAClicked() {
		System.out.println("A!");
		buttonClicked(keyMapTable.get("A"));
	}
	
	@FXML
	private void onBtnBClicked() {
		System.out.println("B!");
		buttonClicked(keyMapTable.get("B"));
	}
	
	@FXML
	private void onBtnCClicked() {
		System.out.println("C!");
		buttonClicked(keyMapTable.get("C"));
	}
	
	@FXML
	private void onBtnDClicked() {
		System.out.println("D!");
		buttonClicked(keyMapTable.get("D"));
	}
	
	@FXML
	private void onBtnEClicked() {
		System.out.println("E!");
		buttonClicked(keyMapTable.get("E"));
	}
	
	@FXML
	private void onBtnFClicked() {
		System.out.println("F!");
		buttonClicked(keyMapTable.get("F"));
	}
	
	@FXML
	private void onBtnZeroClicked() {
		System.out.println("Zero!");
		buttonClicked(keyMapTable.get("0"));
	}
	
	@FXML
	private void onBtnOneClicked() {
		System.out.println("One!");
		buttonClicked(keyMapTable.get("1"));
	}
	
	@FXML
	private void onBtnTwoClicked() {
		System.out.println("Two!");
		buttonClicked(keyMapTable.get("2"));
	}
	
	@FXML
	private void onBtnThreeClicked() {
		System.out.println("Three!");
		buttonClicked(keyMapTable.get("3"));
	}
	
	@FXML
	private void onBtnFourClicked() {
		System.out.println("Four!");
		buttonClicked(keyMapTable.get("4"));
	}
	
	@FXML
	private void onBtnFiveClicked() {
		System.out.println("Five!");
		buttonClicked(keyMapTable.get("5"));
	}
	
	@FXML
	private void onBtnSixClicked() {
		System.out.println("Six!");
		buttonClicked(keyMapTable.get("6"));
	}
	
	@FXML
	private void onBtnSevenClicked() {
		System.out.println("Seven!");
		buttonClicked(keyMapTable.get("7"));
	}
	
	@FXML
	private void onBtnEightClicked() {
		System.out.println("Eight!");
		buttonClicked(keyMapTable.get("8"));
	}
	
	@FXML
	private void onBtnNineClicked() {
		System.out.println("Nine!");
		buttonClicked(keyMapTable.get("9"));
	}	
	
	private void buttonClicked(char keyCode){
		//TODO: send to HHTConnection > HHTInputConnection
		hhtConn.sendKey(keyCode);
	}

	@Override
	public void execute(char[] arr) {
		// TODO Auto-generated method stub
		lblDisplay.setText(String.valueOf(arr));
	}
	

}
