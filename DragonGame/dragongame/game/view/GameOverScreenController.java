package com.dragongame.game.view;

import com.dragongame.game.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameOverScreenController {
	
@FXML
Label gameOverText;

@FXML
Button newGameButton;

private Main main;

public GameOverScreenController() {
	
}

@FXML
private void initialize() {
	gameOverText.setText("You have been slain!");
	newGameButton.setText("New Game");
}

public void startNewGame() {
main.startNewGame();
}

public void setMain(Main main) {
	this.main = main; 
}







}
