package com.dragongame.game;

import java.io.IOException;

import com.dragongame.game.model.Bank;
import com.dragongame.game.model.Dragon;
import com.dragongame.game.view.BattleScreenController;
import com.dragongame.game.view.DebugMenuController;
import com.dragongame.game.view.DragonScreenController;
import com.dragongame.game.view.GameMapController;
import com.dragongame.game.view.MapEventScreenController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	/*So I've added the battles to the events! Now when the player chooses to attack in any event they will open the battle menu! Back pats all around.
	 * 
	 * What remains in the battle GUI is:
	 * ~Fluff text and title for the battles (Make new classes)
	 * ~Damage chance to the dragon on failure (Check if Victory == true [On the update one not the initialize] and trigger event if false)
	 * ~Victory Screen (add gold) [Automatically switched to victory screen from battle screen when victory == true]
	 * ~Loss (GAME OVER) screen.
	 * 
	 * The next task on the list should be the damage thing. It's about time we start introducing some risk into this game. So implement the chance of damage to the dragon 
	 * upon not successfully attacking. For long term implementation [Dragon Perks/Modifications/Body Additions] make a stat called Dragon defense or something in the 
	 * Dragon class. Default defense rank is 0. When dragon defense is raised (by defensive perks like scales, size, etc.) it decreases the chance that you will be injured. 
	 * So like a reverse cypher system that runs automatically after trying to kill something, but only triggers on failure. If the the attack is successful, there will
	 * be no roll for damage.
	 * 
	 * As for what else needs to be done...not much for the end MVP. 
	 * Though some things I may want to add once that is finished include: 
	 * 
	 * Opening Cutscene/story intro.
	 * Planning of the Lair and Loot Screens
	 * Randomizing towns to torment
	 * Randomizing of loot
	 * 
	 * Good thing you set such a long deadline on the game! It's coming along slowly but surely, each system tying well into the one previous. Keep up the good work.
	 * 
	 *  So now what is needed to make the game move forward:
	 * 
	 *   ~~~~~Minimum Viable Product~~~~~
	 *    Overall map[DONE]
	 *    Map buttons[DONE]
	 *    Map Events. [DONE]
	 *    Rest Mechanic to reset stats [DONE]
	 *    Date tracking for years asleep [DONE]
	 *    Implementing the Cypher System into contested events [NEAR COMPLETION]
	 *    
	 *At the end of the day, the basic game should allow you to, click on a region and have a random event pop up. Complete the 
	 *random event and have the values in your GUI reflect the outcome. That's it! 
	 *    
	 *  Cypher System is almost done. Keep it up!  
	 *  
	 *  -Guy
	*/
	
	private Stage primaryStage;
	private Stage debugWindow;
	private AnchorPane rootLayout;
	private static DragonScreenController dragonScreenController;
	private static GameMapController gameMapController;
	private static MapEventScreenController mapEventController;
	private static BattleScreenController battleScreenController;
	
	
	private static AnchorPane mapEvents;
	private static AnchorPane battleScreen;
	
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
		showBattleScreen();
		battleScreenVisibility(false);
		
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
			loader.setLocation(Main.class.getResource("view/GameMapGUI.fxml"));
			AnchorPane tutorialMap = (AnchorPane) loader.load();
			
			// Set tutorial map into the right side of the root layout
			rootLayout.getChildren().add(tutorialMap);	
			rootLayout.setBottomAnchor(tutorialMap, (double) 0);
			rootLayout.setTopAnchor(tutorialMap, (double) 0);
			rootLayout.setRightAnchor(tutorialMap, (double) 0);
			
			// Need to give controller access to the Main
			gameMapController = loader.getController();
			gameMapController.setMain(this);
			
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static GameMapController getGameMapController() {
		return gameMapController;
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
			
			//Set Event menu into the root layout
			rootLayout.getChildren().add(mapEvents);
			rootLayout.setBottomAnchor(mapEvents, (double) 0);
			rootLayout.setTopAnchor(mapEvents, (double) 0);
			rootLayout.setRightAnchor(mapEvents, (double) 0);
			
			mapEventController = loader.getController();
			mapEventController.setMain(this);
			
			} catch (IOException e) {
	            e.printStackTrace();
	        }
		
		}
	

	public static MapEventScreenController getMapEventScreenController() {
	return mapEventController;
	}

	public static void eventMenuVisibility(boolean value) {
		mapEvents.setVisible(value);
	}

	public void showBattleScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/BattleScreenGUI.fxml"));
			battleScreen = (AnchorPane) loader.load();
			
			rootLayout.getChildren().add(battleScreen);
			rootLayout.setBottomAnchor(battleScreen, (double) 0);
			rootLayout.setTopAnchor(battleScreen, (double) 0);
			rootLayout.setRightAnchor(battleScreen, (double) 0);
			
			battleScreenController = loader.getController();
			battleScreenController.setMain(this);
			
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static BattleScreenController getBattleScreenController() {
		return battleScreenController;
	}
	
	public static void battleScreenVisibility(boolean value) {
		getBattleScreenController().getBattle().setAppliedStatValue(0);
		getBattleScreenController().updateBattleScreen();
		getBattleScreenController().getBattle().setVictoryBoolean(false);
		battleScreen.setVisible(value);
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
