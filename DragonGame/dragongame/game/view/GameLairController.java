package com.dragongame.game.view;

import com.dragongame.game.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GameLairController {

@FXML
private Label dateLabelLair;

@FXML
private Button restButton;

@FXML
private Button treasureButton;

@FXML
private Button leaveLairButton;

//Link back to Main
private Main main;

/**
 * Default Constructor
 */
public GameLairController() {
}

@FXML
private void initialize() {
	dateLabelLair.setText("Year " + Main.getGameMapController().getDateTracker().getCurrentYear());
}

public void updateDate() {
	dateLabelLair.setText("Year " + Main.getGameMapController().getDateTracker().getCurrentYear());
}

public void enterLair() {
	Main.gameMapVisibility(false);
	Main.lairMenuVisibility(true);
}

public void leaveLair() {
	Main.gameMapVisibility(true);
	Main.lairMenuVisibility(false);
}


public void restMechanic() {
	GameMapController.getDateTracker().incrementCurrentYear(1);
	DragonScreenController.getDragon().setDragonMight(Main.getDragonScreenController().getDragon().getDagonMightRestoreValue());
	DragonScreenController.getDragon().setDragonIntellect(Main.getDragonScreenController().getDragon().getDagonIntellectRestoreValue());
	Main.getDragonScreenController().getDragon().setDragonHealth(3);
	Main.getDragonScreenController().getDragon().setDragonHunger(4);
	Main.getDragonScreenController().getDragon().setDragonMood(0);

}
	
/**
 * Is called by the main application to give a reference back to itself.
 * 
 * @param Main
 */
public void setMain(Main main) {
	this.main = main;
}
	
}
