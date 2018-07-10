package com.dragongame.game;

import java.io.IOException;

import com.dragongame.game.model.Bank;
import com.dragongame.game.model.Dragon;
import com.dragongame.game.view.DebugMenuController;
import com.dragongame.game.view.DragonScreenController;
import com.dragongame.game.view.MapEventScreenController;
import com.dragongame.game.view.TutorialMapController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	/*
	 *You made the event screen! Good job buddy. Now to fill it with events! It's time to start looking into how to import text 
	 *so that you can have 
	 * a separate file with all the event text to port into the events screen. Keep up the good work! You've almost got the MVP
	 * down. Once it's done, then you can look into adding the extra features like the Cypher System and the other screens
	 * like the dragon description screen! 
	 * 
	 * One thing at a time and you've got yourself a damn solid game! 
	 * 
	 *  So now what is needed to make the game move forward:
	 * 
	 *   ~~~~~Minimum Viable Product~~~~~
	 *    Overall map[DONE]
	 *    Map buttons[DONE]
	 *    Map Events. [IN PROGRESS]
	 *    Rest Mechanic to reset stats [NEXT ON DOCKET]
	 *    
	 *    
	 *    ~~~~~Extended Content~~~~~
	 *    Date tracking for years asleep
	 *    Implementing the Cypher System into contested events
	 *    
	 *    
	 *    
	 *At the end of the day, the basic game should allow you to, click on a region and have a random event pop up. Complete the 
	 *random event and have the values in your GUI reflect the outcome. That's it! 
	 *    
	 *  Keep up the good work man! You got this! 
	 *  
	 *  -Guy
	*/
	
	private Stage primaryStage;
	private Stage debugWindow;
	private AnchorPane rootLayout;
	private static DragonScreenController dragonScreenController;
	
	
	private AnchorPane mapEvents;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Dragon Game");
		
		initRootLayout();
		showDragonOverview();
		showGameMap();
		//showDebugMenu(); 
		showEventMenu();
		eventMenuVisibility(false);
		
	}
	
	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			//Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameBaseGUI.fxml"));
			rootLayout = (AnchorPane) loader.load();
			
			//Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Show the Dragon GUI in the root layout
	 */
	public void showDragonOverview() {
		try {
			// Load Dragon Overview
			FXMLLoader loader  = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/DragonScreenGUI.fxml"));
			AnchorPane dragonOverview = (AnchorPane) loader.load();
			
			// Set dragon overview into the left of the root layout.
			rootLayout.getChildren().add(dragonOverview);
			rootLayout.setBottomAnchor(dragonOverview,  (double) 0);
			rootLayout.setTopAnchor(dragonOverview, (double) 0);
			rootLayout.setLeftAnchor(dragonOverview, (double) 0);
			
			// Give the controller access to the Main
			dragonScreenController = loader.getController();
			dragonScreenController.setMain(this);
			
			
		} catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static DragonScreenController getDragonScreenController() {
		return dragonScreenController;
	}
	
	
	/**
	 * Shows the Main Game Map in the root Layout
	 */
	public void showGameMap() {
		try {
			//Load Dragon Map
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameTutorialMap.fxml"));
			AnchorPane tutorialMap = (AnchorPane) loader.load();
			
			// Set tutorial map into the right side of the root layout
			rootLayout.getChildren().add(tutorialMap);	
			rootLayout.setBottomAnchor(tutorialMap, (double) 0);
			rootLayout.setTopAnchor(tutorialMap, (double) 0);
			rootLayout.setRightAnchor(tutorialMap, (double) 0);
			
			// Need to give controller access to the Main
			TutorialMapController controller = loader.getController();
			controller.setMain(this);
			
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Shows the Debug Menu in the main window.
	 */
	public void showDebugMenu() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/DebugMenuGUI.fxml"));
			AnchorPane debugMenu = (AnchorPane) loader.load();
			
			//Set debug menu into the top of the root layout
			rootLayout.getChildren().add(debugMenu);
			rootLayout.setBottomAnchor(debugMenu, (double) 0);
			rootLayout.setTopAnchor(debugMenu, (double) 0);
			rootLayout.setRightAnchor(debugMenu, (double) 0);
			
			DebugMenuController debugController = loader.getController();
			debugController.setMain(this);
			
			} catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	/**
	 * Shows the event screen in the main menu
	 */
	public void showEventMenu() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MapEventScreen.fxml"));
			mapEvents = (AnchorPane) loader.load();
			
			//Set debug menu into the top of the root layout
			rootLayout.getChildren().add(mapEvents);
			rootLayout.setBottomAnchor(mapEvents, (double) 0);
			rootLayout.setTopAnchor(mapEvents, (double) 0);
			rootLayout.setRightAnchor(mapEvents, (double) 0);
			
			MapEventScreenController mapEventController = loader.getController();
			mapEventController.setMain(this);
			
			} catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public void eventMenuVisibility(boolean value) {
		mapEvents.setVisible(value);
		
	}

	
	
	/**
	 * Returns the main stage
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
