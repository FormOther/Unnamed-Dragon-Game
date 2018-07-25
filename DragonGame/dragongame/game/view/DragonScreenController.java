package com.dragongame.game.view;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.dragongame.game.Main;
import com.dragongame.game.model.Bank;
import com.dragongame.game.model.Dragon;
import com.dragongame.game.util.StatValueConversion;


public class DragonScreenController {
	@FXML
	private Label dragonNameLabel;
	
	@FXML
	private Label dragonHungerLabel;
	
	@FXML
	private Label dragonHorninessLabel;
	
	@FXML
	private Label dragonMoodLabel;
	
	@FXML
	public Label dragonHealthLabel;
	
	@FXML
	private Label dragonMightCounter;
	
	@FXML 
	private Label dragonInfamyCounter;
	
	@FXML
	private Label dragonIntellectCounter;
	
	@FXML
	private Label dragonGoldCounter;
	
	
	
	
	
	StatValueConversion value = new StatValueConversion();
	private static Bank bank;
	private static Dragon dragon;
	
	// Reference to the main application.
	private Main main;
	
	
	
	
	/**
	 * The Constructor.
	 * The constructor is called before the initialize() method.
	 */
	public DragonScreenController() {
		
	}
	
	public static Dragon getDragon() {
		return dragon;
	}
	
	public static Bank getBank() {
		return bank;
	}
	
	/**
	 * Initializes the controller class. This method is automatically called 
	 * after the fxml file has been loaded. 
	 */
	@FXML
	private void initialize() {
		bank = new Bank();
		dragon = new Dragon();
		dragonNameLabel.setText(dragon.getDragonName());
		dragonHungerLabel.setText(value.dragonHungerWords[dragon.getDragonHunger()]);
		dragonHorninessLabel.setText(value.dragonHorninessWords[dragon.getDragonHorniness()]);
		dragonMoodLabel.setText(value.dragonMoodWords[dragon.getDragonMood()]);
		dragonHealthLabel.setText(value.dragonHealthWords[dragon.getDragonHealth()]);
		
		dragonMightCounter.setText("" + dragon.getDragonMight());
		dragonInfamyCounter.setText("" + dragon.getDragonInfamy());
		dragonIntellectCounter.setText("" + dragon.getDragonIntellect());
		
		dragonGoldCounter.setText(bank.getDragonGold() + " gold");
		
	}

	/**
	 * Updates the dragon stats
	 * @return dragonHunger
	 * @return dragonHorniness
	 * @return dragonMod
	 * @return dragonHealth
	 */
	public void dragonGUIRefresh() {
		
		dragonHungerLabel.setText(value.dragonHungerWords[dragon.getDragonHunger()]);
		dragonHorninessLabel.setText(value.dragonHorninessWords[dragon.getDragonHorniness()]);
		dragonMoodLabel.setText(value.dragonMoodWords[dragon.getDragonMood()]);
		dragonHealthLabel.setText(value.dragonHealthWords[dragon.getDragonHealth()]);
		
		dragonMightCounter.setText("" + dragon.getDragonMight());
		dragonInfamyCounter.setText("" + dragon.getDragonInfamy());
		dragonIntellectCounter.setText("" + dragon.getDragonIntellect());
		
		dragonGoldCounter.setText(bank.getDragonGold() + " gold");
		
	}
	
	public void openLairScreen() {
		Main.getGameLairController().enterLair();
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
