package com.dragongame.game;

import java.io.IOException;

import com.dragongame.game.model.Bank;
import com.dragongame.game.model.Dragon;
import com.dragongame.game.view.BattleScreenController;
import com.dragongame.game.view.DebugMenuController;
import com.dragongame.game.view.DragonScreenController;
import com.dragongame.game.view.GameLairController;
import com.dragongame.game.view.GameMapController;
import com.dragongame.game.view.GameOverScreenController;
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

	/* Rejoice! For the Lair GUI menu that you have been dreading has been implemented! So now you can go into lair, rest, and then leave to terrorize the masses! 
	 * I've not had the chance for art assets but it I had my druthers, I'd like a menu much in the same way of the map menu, where one can select a graphic on the screen
	 * and it will be highlighted. Then once the screen is clicked the next menu will pop up and so on.
	 * 
	 * So next on the docket is adding Treasure. Which is going to be just fan tucking fastic. But seriously reference the menu FX tutorial on how to make an address keeper
	 * app and you should be fine in terms of the GUI. In the end I want it to list the Name, quality, and value of the item. But first make the GUI and add it to the game.
	 * It should open up when you hit the treasure button in the Lair GUI. Next make the treasure model class, notes on which are in your notebook. Once the Treasure model class
	 * is finished, including randomizing the values of treasure, appropriate limiting variables and testing, add it to the events Victory so that one randomly generated treasure
	 * is added from the battle to the Treasury list in the lair screen. Then find out how to make this happen multiple times and boom, Treasure is done. 
	 * 
	 * You'll be fine, you're already nearing the end. You can see it. I can see it. Keep up the good work and we'll be there soon! 
	 * 
	 * Once treasure is done, you might want to start brainstorming the maiden mechanic and the dungeons in general. How to implement them, how to add them to the dungeons
	 * etc. It won't be too hard so long as you plan well and work with what you have! Once maidens are done, brainstorm how to handle heroic events. Should they be a random
	 * encounter? How are they spawned? 
	 * 
	 * Also play around with the idea of adding health for enemies. So like maybe a weak enemy can be hit once but a strong enemy needs 3 hits to go down. If you hit they 
	 * definately miss you but if you miss they run the chance of hitting you. Food for thought, especially for boss encounters. 
	 * 
	 * Once that's finished...All that's needed is a story and a save mechanic. Then you can start reaching out to artists to see who could be interested in working with 
	 * you on this game! You've already got the list in your notepad and whoo man if you can get one of them it'll be awesome! 
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
	private static GameLairController gameLairController;
	
	private static AnchorPane mapEvents;
	private static AnchorPane battleScreen;
	private static AnchorPane tutorialMap;
	private static AnchorPane lairMenu;
	
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
		
		showLairMenu();
		lairMenuVisibility(false);
		
	}

//--------------------------------------------------------	
	
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
	
//--------------------[DRAGON SCREEN GUI]------------------------------------	
	
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
	
//--------------------[GAME MAP GUI]------------------------------------	
	
	/**
	 * Shows the Main Game Map in the root Layout
	 */
	public void showGameMap() {
		try {
			//Load Dragon Map
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameMapGUI.fxml"));
			tutorialMap = (AnchorPane) loader.load();
			
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
	
	public static void gameMapVisibility(boolean value) {
		tutorialMap.setVisible(value);
	}
	

//--------------------[DEBUG MENU GUI]------------------------------------	
	
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
	
//--------------------[EVENT MENU GUI]------------------------------------	
	
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
	
//--------------------[BATTLE SCREEN GUI]------------------------------------		

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
		getBattleScreenController().getBattle().setVictoryBoolean(false);
		battleScreen.setVisible(value);
	}
	
//--------------------[LAIR MENU GUI]------------------------------------		
	
	public void showLairMenu() {
		try {
			//Load the Lair Menu GUI
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameLairGUI.fxml"));
			lairMenu  = (AnchorPane) loader.load();
				
			//Set the screen
			rootLayout.getChildren().add(lairMenu);
			rootLayout.setBottomAnchor(lairMenu, (double) 0);
			rootLayout.setTopAnchor(lairMenu, (double) 0);
			rootLayout.setRightAnchor(lairMenu, (double) 0);
				
			//Give controller access to the Main
			gameLairController = loader.getController();
			gameLairController.setMain(this);
					
		} catch (IOException e) {
	           e.printStackTrace();
	       }
	}
		
	public static GameLairController getGameLairController() {
		return gameLairController;
	}

		
	public static void lairMenuVisibility(boolean value) {
		lairMenu.setVisible(value);
	}
		
	
//--------------------[GAME OVER SCREEN]------------------------------------		
	
	public void showGameOver() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameOverScreen.fxml"));
			AnchorPane gameOverScreen = (AnchorPane) loader.load();
			
			Scene gameOver = new Scene(gameOverScreen);
			primaryStage.setScene(gameOver);
			primaryStage.show();
			
			GameOverScreenController gameOverScreenController = loader.getController();
			gameOverScreenController.setMain(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//--------------------[START NEW GAME FUNCTION]------------------------------------	
		
		/**
		 * Will start a new game.
		 */
		public void startNewGame() {
			initRootLayout();
			showDragonOverview();
			showGameMap();
			//showDebugMenu(); 
			
			showEventMenu();
			eventMenuVisibility(false);
			
			showBattleScreen();
			battleScreenVisibility(false);
			
			showLairMenu();
			lairMenuVisibility(false);
		}
		
	
//--------------------------------------------------------	
	
	public void showTitleScene() {
		
	}
	
//--------------------------------------------------------	
	
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
