package com.dragongame.game;

import java.io.IOException;

import com.dragongame.game.model.Bank;
import com.dragongame.game.model.Dragon;
import com.dragongame.game.view.DragonScreenController;
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
	 *Hey dude, good job today! You successfully implemented the bank along with methods to change the value! 
	 *Hit a snag though in that now that you've linked the values to the DragonScreenController, you can only 
	 *adjust them through the DragonScreenController. Meaning that if you have an event that takes 1 Stamina and adds
	 *5 gold, it would need to be run through the DragonScreenController. Vexing, especially considering that 
	 *the events that run need to adjust the values of the Dragon accordingly. Since this is likely something that requires
	 *more research, the next step will be to upload the current version of the game onto GitHub and start asking questions
	 *about how to access the data in the DragonScreenController through events.
	 *
	 *The questions would likely be something along the lines of:
	 *
	 *Here is my code [code]:
	 *I need to create events that will change the stats in the Dragon Instance but I'm having trouble accessing the 
	 *instance of Dragon that is created by the DragonScreenController. 
	 *See if you can hail Innoxia or Alvin Magh first. After that go to stackexchange. 
	 *
	 *In the meantime, to keep the work on the game up, start drafting out events that occurr when the various 
	 *areas are clicked. Go for one event that gives gold and takes 1 energy for each area.
	 *
	 *You've got this man. A minor snag is not enough to stop this progress. Keep working on everything else you can about the game
	 *so that once it's cleared you have a smooth path ahead of you! The events will take a while to write so while 
	 *that issue is being troubleshot, keep plugging away at different events that our dastardly dragon an get up to.
	 *Make a list of all the events in the Defiler Wings game and improve them from there.
	 * 
	 *  So now what is needed to make the game move forward:
	 *  
	 *  ~~~~~~For the DragonGUI~~~~
	 *   Dragon Description Page
	 *   Lair Description (Page?)
	 *   Spells 
	 *   Treasure Room (Dragon Bank Class for currency)
	 *   Captive Rooms Page
	 *   
	 *   ~~~~~For the World~~~~~
	 *    Overall map (Graphically)[DONE]
	 *    Map buttons.[DONE]
	 *    Map Events. [Working on it]
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
	private AnchorPane rootLayout;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Dragon Game");
		
		initRootLayout();
		showDragonOverview();
		showGameMap();
	
		
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
			DragonScreenController controller = loader.getController();
			controller.setMain(this);
			
			
		} catch (IOException e) {
            e.printStackTrace();
        }
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
