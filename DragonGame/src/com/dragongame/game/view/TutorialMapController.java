package com.dragongame.game.view;

import java.io.FileInputStream;

import com.dragongame.game.Main;
import com.dragongame.resources.images.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class TutorialMapController {

	@FXML
	private Button seaButton;
	@FXML
	private Button cityButton;
	@FXML
	private Button portButton;
	@FXML
	private Button ruralButton;
	@FXML
	private Button forestButton;
	@FXML
	private Button roadButton;
	@FXML
	private Button mountainButton;
	@FXML
	private Button skyButton;
	@FXML
	private Button badlandButton;
	@FXML
	private ImageView theMap;
	
	
	
	
	// Link back to Main
	private Main main;
	
	/**
	 * Default Constructor
	 */
	public TutorialMapController() {
	}
	
	/**
	 * Initialized the controller class. Automatically called up when the fxml has been loaded.
	 */
	@FXML
	private void initialize() {

	}
	
	/**
	 * Links back to the default map image
	 */
	@FXML
	public void defaultMap() {
		Image mapBase = new Image("com/dragongame/resources/images/Map Base.jpg");
		theMap.setImage(mapBase);
	}
	
	@FXML
	public void mouseOverSea() {
		Image seaHighlight = new Image ("com/dragongame/resources/images/Sea Highlight.jpg");
		theMap.setImage(seaHighlight);	
	}
	
	@FXML
	public void mouseOverCity() {
		Image cityHighlight = new Image("com/dragongame/resources/images/Big City Highlight.jpg");
		theMap.setImage(cityHighlight);
		
	}
	
	@FXML
	public void mouseOverPort() {
		Image portHighlight = new Image("com/dragongame/resources/images/Port Highlight.jpg");
		theMap.setImage(portHighlight);
		
	}
	
	@FXML
	public void mouseOverRural() {
		Image ruralHighlight = new Image("com/dragongame/resources/images/Rural Area Highlight.jpg");
		theMap.setImage(ruralHighlight);
		
	}
	
	@FXML
	public void mouseOverForest() {
		Image forestHighlight = new Image("com/dragongame/resources/images/Forest Highlight.jpg");
		theMap.setImage(forestHighlight);
		
	}
	
	@FXML
	public void mouseOverRoad() {
		Image roadHighlight = new Image("com/dragongame/resources/images/Trade Route Highlight.jpg");
		theMap.setImage(roadHighlight);
		
	}
	
	@FXML
	public void mouseOverMountain() {
		Image mountainHighlight = new Image("com/dragongame/resources/images/Mountain Highlight.jpg");
		theMap.setImage(mountainHighlight);
		
	}
	
	@FXML
	public void mouseOverSky() {
		Image skyHighlight = new Image("com/dragongame/resources/images/Sky Highlight.jpg");
		theMap.setImage(skyHighlight);
		
	}
	
	@FXML
	public void mouseOverBadland() {
		Image badlandHighlight = new Image("com/dragongame/resources/images/Forbidden Lands Highlight.jpg");
		theMap.setImage(badlandHighlight);
		
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
