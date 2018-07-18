package com.dragongame.game.view;

import java.io.IOException;

import com.dragongame.game.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DebugMenuController {

	Stage debugWindow;
	
	@FXML
	private Button dragonHungerButton1;
	@FXML
	private Button dragonHungerButton2;
	@FXML
	private Button dragonHorninessButton1;
	@FXML
	private Button dragonHorninessButton2;
	@FXML
	private Button dragonMoodButton1;
	@FXML
	private Button dragonMoodButton2;
	@FXML
	private Button dragonHealthButton1;
	@FXML
	private Button dragonHealthButton2;
	@FXML
	private Button dragonMightButton1;
	@FXML
	private Button dragonMightButton2;
	@FXML
	private Button dragonIntellectButton1;
	@FXML
	private Button dragonIntellectButton2;
	@FXML
	private Button dragonInfamyButton1;
	@FXML
	private Button dragonInfamyButton2;
	@FXML
	private Button dragonGoldButton1;
	@FXML
	private Button dragonGoldButton2;
	@FXML
	private Button worldYearButton1;
	@FXML
	private Button worldYearButton2;
	
	private Main main;
	
	public DebugMenuController() {
		
	}
	
	@FXML
	private void initalize() {
	
	}
	
	@FXML
	private void addDragonHunger() {
		DragonScreenController.getDragon().incrementDragonHunger(1);
	}
	
	@FXML
	private void minusDragonHunger() {
		DragonScreenController.getDragon().incrementDragonHunger(-1);
	}
	
	@FXML
	private void addDragonHorniness() {
		DragonScreenController.getDragon().incrementDragonHorniness(1);
	}
	
	@FXML
	private void minusDragonHorniness() {
		DragonScreenController.getDragon().incrementDragonHorniness(-1);
	}
	
	@FXML
	private void addDragonMood() {
		DragonScreenController.getDragon().incrementDragonMood(1);
	}
	
	@FXML
	private void minusDragonMood() {
		DragonScreenController.getDragon().incrementDragonMood(-1);
	}
	
	@FXML
	private void addDragonHealth() {
		DragonScreenController.getDragon().incrementDragonHealth(1);
	}
	
	@FXML
	private void minusDragonHealth() {
		DragonScreenController.getDragon().incrementDragonHealth(-1);
	}
	
	@FXML
	private void addDragonMight() {
		DragonScreenController.getDragon().incrementDragonMight(1);
	}
	
	@FXML
	private void minusDragonMight() {
		DragonScreenController.getDragon().incrementDragonMight(-1);
	}
	
	@FXML
	private void addDragonIntellect() {
		DragonScreenController.getDragon().incrementDragonIntellect(1);
	}
	
	@FXML
	private void minusDragonIntellect() {
		DragonScreenController.getDragon().incrementDragonIntellect(-1);
	}
	
	@FXML
	private void addDragonInfamy() {
		DragonScreenController.getDragon().incrementDragonInfamy(1);
	}
	
	@FXML
	private void minusDragonInfamy() {
		DragonScreenController.getDragon().incrementDragonInfamy(-1);
	}
	
	@FXML
	private void addDragonGold() {
		DragonScreenController.getBank().incrementDragonGold(1000);
	}
	
	@FXML
	private void minusDragonGold() {
		DragonScreenController.getBank().incrementDragonGold(-1000);
	}
	
	@FXML
	private void addWorldYear() {
		GameMapController.getDateTracker().incrementCurrentYear(1);
	}
	
	@FXML
	private void minusWorldYear() {
		GameMapController.getDateTracker().incrementCurrentYear(-1);
	}
	
	public void setMain (Main main) {
		this.main = main;
	}
	
}
