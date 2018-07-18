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
	public Button eventButton1;
	@FXML 
	public Button eventButton2;
	@FXML 
	public Button eventButton3;
	@FXML 
	public Button eventButton4;
	@FXML 
	public Button eventButton5;
	@FXML 
	public Button eventButton6;
	@FXML 
	private AnchorPane eventAnchor;
	
	private Main main;
	private static MapEvent mapEvent;
	
	//private static MapEvent mapEvent;
	
	public MapEventScreenController() {
	}
	
	public static MapEvent getMapEvent() {
		return mapEvent;
	}
	
	@FXML
	private void initialize() {
		mapEvent = new MapEvent();
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
	
	/**
	 * Updates the Event screen
	 */
	public void updateEventScreen() {
		eventTitle.setText(mapEvent.getEventTitle());
		eventContents.setText(mapEvent.getEventContent());
		eventButton1.setText(mapEvent.getOption1());
		eventButton2.setText(mapEvent.getOption2());
		eventButton3.setText(mapEvent.getOption3());
		eventButton4.setText(mapEvent.getOption4());
		eventButton5.setText(mapEvent.getOption5());
		eventButton6.setText(mapEvent.getOption6());
	}
	
	/**
	 * Changes the visibiliy of buttons.
	 * @param button1
	 * @param button2
	 * @param button3
	 * @param button4
	 * @param button5
	 * @param button6
	 */
	public void setButtonVisibility(boolean button1, boolean button2, boolean button3, boolean button4, boolean button5, boolean button6) {
		eventButton1.setVisible(button1);
		eventButton2.setVisible(button2);
		eventButton3.setVisible(button3);
		eventButton4.setVisible(button4);
		eventButton5.setVisible(button5);
		eventButton6.setVisible(button6);
		updateEventScreen();
	}
	
	/**
	 * Changes the text of the buttons.
	 * @param button1
	 * @param button2
	 * @param button3
	 * @param button4
	 * @param button5
	 * @param button6
	 */
	//Sets the button text
	public void setButtonText(String button1, String button2, String button3, String button4, String button5, String button6) {
		mapEvent.setOption1(button1);
		mapEvent.setOption2(button2);
		mapEvent.setOption3(button3);
		mapEvent.setOption4(button4);
		mapEvent.setOption5(button5);
		mapEvent.setOption6(button6);
		updateEventScreen();
	}
	
	/**
	 * Changes the actions on the buttons to do nothing 
	 */
	public void resetButtonActions() {
		eventButton1.setOnAction(null);
		eventButton2.setOnAction(null);
		eventButton3.setOnAction(null);
		eventButton4.setOnAction(null);
		eventButton5.setOnAction(null);
		eventButton6.setOnAction(null);
	}
	
	public void setMain (Main main) {
		this.main = main;
	}
}
