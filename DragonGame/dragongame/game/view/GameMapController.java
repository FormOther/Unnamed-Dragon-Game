package com.dragongame.game.view;


import com.dragongame.game.Main;
import com.dragongame.game.events.City.CityMainEvents;
import com.dragongame.game.events.Port.CityPortEvents;
import com.dragongame.game.events.Forest.ForestEvents;
import com.dragongame.game.events.Mountains.MountainEvents;
import com.dragongame.game.events.Rural.RuralAreaEvents;
import com.dragongame.game.events.Sea.SeaEvents;
import com.dragongame.game.events.Sky.SkyEvents;
import com.dragongame.game.events.TradeRoute.TradeRouteEvents;
import com.dragongame.game.model.Bank;
import com.dragongame.game.model.DateTracker;
import com.dragongame.game.model.Dragon;
import com.dragongame.resources.images.*;
import com.dragongame.game.view.MapEventScreenController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class GameMapController {

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
	@FXML
	private Label dateLabel;
	
	CityMainEvents cityMainEvent = new CityMainEvents();
	CityPortEvents cityPortEvent = new CityPortEvents();
	RuralAreaEvents ruralAreaEvent = new RuralAreaEvents();
	ForestEvents forestEvent = new ForestEvents();
	TradeRouteEvents tradeRouteEvent = new TradeRouteEvents();
	MountainEvents mountainEvent = new MountainEvents();
	SkyEvents skyEvent = new SkyEvents();
	SeaEvents seaEvent = new SeaEvents();
	
	
	// Link back to Main
	private Main main;
	
	private static DateTracker dateTracker;
	
	/**
	 * Default Constructor
	 */
	public GameMapController() {
	}
	
	public static DateTracker getDateTracker() {
		return dateTracker;
	}
	
	/**
	 * Initialized the controller class. Automatically called up when the fxml has been loaded.
	 */
	@FXML
	private void initialize() {
		dateTracker = new DateTracker();
		dateLabel.setText("Year " + dateTracker.getCurrentYear());
	}
	
	/**
	 * Updates the date in the GUI
	 */
	public void updateDate() {
		dateLabel.setText("Year " + dateTracker.getCurrentYear());
	}
		
	/**
	 * Changes the date in the GUI
	 * @param date
	 */
	public void changeDate(int date) {
		dateTracker.incrementCurrentYear(date);
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
	public void clickSea() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		seaEvent.seaEventRoulette();
		main.eventMenuVisibility(true);
		}
	}
	
	@FXML
	public void mouseOverCity() {
		Image cityHighlight = new Image("com/dragongame/resources/images/Big City Highlight.jpg");
		theMap.setImage(cityHighlight);
		
	}
	
	@FXML
	public void clickCity() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		cityMainEvent.cityMainEventRoulette();
		main.eventMenuVisibility(true);
		}
	}
	
	@FXML
	public void mouseOverPort() {
		Image portHighlight = new Image("com/dragongame/resources/images/Port Highlight.jpg");
		theMap.setImage(portHighlight);
		
	}
	
	@FXML
	public void clickPort() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		cityPortEvent.cityPortEventRoulette();
		main.eventMenuVisibility(true);
		}
	}
	
	@FXML
	public void mouseOverRural() {
		Image ruralHighlight = new Image("com/dragongame/resources/images/Rural Area Highlight.jpg");
		theMap.setImage(ruralHighlight);
		
	}
	
	@FXML
	public void clickRural() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		ruralAreaEvent.ruralAreaEventRoulette();
		main.eventMenuVisibility(true);
		}
	}
	
	@FXML
	public void mouseOverForest() {
		Image forestHighlight = new Image("com/dragongame/resources/images/Forest Highlight.jpg");
		theMap.setImage(forestHighlight);
		
	}
	
	@FXML
	public void clickForest() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		forestEvent.forestEventRoulette();
		main.eventMenuVisibility(true);
		}
	}
	
	@FXML
	public void mouseOverRoad() {
		Image roadHighlight = new Image("com/dragongame/resources/images/Trade Route Highlight.jpg");
		theMap.setImage(roadHighlight);
		
	}
	
	@FXML
	public void clickRoad() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		tradeRouteEvent.tradeRouteEventRoulette();
		main.eventMenuVisibility(true);
		}
	}
	
	@FXML
	public void mouseOverMountain() {
		Image mountainHighlight = new Image("com/dragongame/resources/images/Mountain Highlight.jpg");
		theMap.setImage(mountainHighlight);
		
	}
	
	@FXML
	public void clickMountain() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		mountainEvent.mountainEventRoulette();
		main.eventMenuVisibility(true);
		}
	}
	
	@FXML
	public void mouseOverSky() {
		Image skyHighlight = new Image("com/dragongame/resources/images/Sky Highlight.jpg");
		theMap.setImage(skyHighlight);
		
	}
	
	@FXML
	public void clickSky() {
		if (Main.getDragonScreenController().getDragon().getDragonHunger() == 0) {
			Main.getMapEventScreenController().needRest();
			main.eventMenuVisibility(true);
		} else {
		skyEvent.skyEventRoulette();
		main.eventMenuVisibility(true);
		}
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
