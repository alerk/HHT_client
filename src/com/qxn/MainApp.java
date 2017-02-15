package com.qxn;

import java.io.IOException;

import com.qxn.view.HHTInputController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<String> displayData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("HHT Client");
		
		initRootLayout();
		
		showHHTInput();
	}
	
	/**
	 * Initialize root layout
	 */
	public void initRootLayout() {
		try {
			//Load root layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//Show the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();	
			
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * Show the HHTInput inside the root layout
	 */
	public void showHHTInput() {
		try {
			//Load HHTInput scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/HHTInput.fxml"));
			AnchorPane hhtInput = (AnchorPane) loader.load();
			
			//Set HHTInput to center of root layout
			rootLayout.setCenter(hhtInput);
			
			//Give the controller access to the main app			
			HHTInputController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {				
				@Override
				public void handle(WindowEvent event) {
					// TODO Auto-generated method stub
					controller.stop();
					Platform.exit();
					System.exit(0);
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Dummy function
	 */
	public void hello() {
		System.out.println("Hello from MainApp!");
	}
	
	public ObservableList<String> getDisplayData() {
		return displayData;
	}
	
	/**
	 * Return the main stage
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
