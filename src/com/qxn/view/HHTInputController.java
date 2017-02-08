package com.qxn.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
//import javafx.scene.control.TextArea;
import com.qxn.MainApp;

public class HHTInputController {
	@FXML
	private TextField txtIpAddr;
	@FXML
	private TextField txtPort;
	
	@FXML
	private Label lblDisplay;
	
	//Reference to MainApp
	private MainApp mainApp;
	
	/**
	 * Constructor
	 */
	public HHTInputController() {
		
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
		if(txtIpAddr.getText().isEmpty() || txtPort.getText().isEmpty())
		{
			System.out.println("Please input the ip and port");
		}
		else
		{
			System.out.println("Connect to " + txtIpAddr.getText() + ":" + txtPort.getText());
		}
	}
	
	@FXML
	private void onBtnEntClicked() {
		System.out.println("Ent!");
	}
	
	@FXML
	private void onBtnClrClicked() {
		System.out.println("Clr!");
	}
	
	@FXML
	private void onBtnBackspaceClicked() {
		System.out.println("Backspace!");
	}
	
	@FXML
	private void onBtnUpClicked() {
		System.out.println("Up!");
	}
	
	@FXML
	private void onBtnDownClicked() {
		System.out.println("Ent!");
	}
	
	@FXML
	private void onBtnLeftClicked() {
		System.out.println("Left!");
	}
	
	@FXML
	private void onBtnRightClicked() {
		System.out.println("Right!");
	}
	
	@FXML
	private void onBtnAClicked() {
		System.out.println("A!");
	}
	
	@FXML
	private void onBtnBClicked() {
		System.out.println("B!");
	}
	
	@FXML
	private void onBtnCClicked() {
		System.out.println("C!");
	}
	
	@FXML
	private void onBtnDClicked() {
		System.out.println("D!");
	}
	
	@FXML
	private void onBtnEClicked() {
		System.out.println("E!");
	}
	
	@FXML
	private void onBtnFClicked() {
		System.out.println("F!");
	}
	
	@FXML
	private void onBtnZeroClicked() {
		System.out.println("Zero!");
	}
	
	@FXML
	private void onBtnOneClicked() {
		System.out.println("One!");
	}
	
	@FXML
	private void onBtnTwoClicked() {
		System.out.println("Two!");
	}
	
	@FXML
	private void onBtnThreeClicked() {
		System.out.println("Three!");
	}
	
	@FXML
	private void onBtnFourClicked() {
		System.out.println("Four!");
	}
	
	@FXML
	private void onBtnFiveClicked() {
		System.out.println("Five!");
	}
	
	@FXML
	private void onBtnSixClicked() {
		System.out.println("Six!");
	}
	
	@FXML
	private void onBtnSevenClicked() {
		System.out.println("Seven!");
	}
	
	@FXML
	private void onBtnEightClicked() {
		System.out.println("Eight!");
	}
	
	@FXML
	private void onBtnNineClicked() {
		System.out.println("Nine!");
	}	

}
