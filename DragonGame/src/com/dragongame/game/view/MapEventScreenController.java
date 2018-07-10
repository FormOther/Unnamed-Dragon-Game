package com.dragongame.game.view;

import com.dragongame.game.Main;
import com.dragongame.game.model.MapEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MapEventScreenController {

	@FXML 
	private Label eventTitle;
	@FXML 
	private Label eventContents;
	@FXML 
	private Button eventButton1;
	@FXML 
	private Button eventButton2;
	@FXML 
	private Button eventButton3;
	@FXML 
	private Button eventButton4;
	@FXML 
	private Button eventButton5;
	@FXML 
	private Button eventButton6;
	@FXML 
	private AnchorPane eventAnchor;
	
	private Main main;
	
	
	//private static MapEvent mapEvent;
	
	public MapEventScreenController() {
	}
	
	private void initialize() {
		MapEvent mapEvent = new MapEvent();
		eventTitle.setText(mapEvent.getEventTitle());
		eventContents.setText(mapEvent.getEventContent());
		eventButton1.setText(mapEvent.getOption1());
		eventButton2.setText(mapEvent.getOption2());
		eventButton3.setText(mapEvent.getOption3());
		eventButton4.setText(mapEvent.getOption4());
		eventButton5.setText(mapEvent.getOption5());
		eventButton6.setText(mapEvent.getOption6());
	}
	
	@FXML
	public void closeEvent() {
		main.eventMenuVisibility(false);
	}
	
	
	
	public void setMain (Main main) {
		this.main = main;
	}
}
