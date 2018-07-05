package com.dragongame.game.view;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.dragongame.game.Main;
import com.dragongame.game.model.Bank;
import com.dragongame.game.model.Dragon;
import com.dragongame.game.util.ValueConversion;

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
	private Label dragonHealthLabel;
	
	@FXML
	private Label dragonStaminaCounter;
	
	@FXML 
	private Label dragonInfamyCounter;
	
	@FXML
	private Label dragonMagicCounter;
	
	@FXML
	private Label dragonGoldCounter;
	
	ValueConversion value = new ValueConversion();
	private Dragon dragon;
	private Bank bank;
	
	
	// Reference to the main application.
	private Main main;
	
	
	
	
	/**
	 * The Constructor.
	 * The constructor is called before the initialize() method.
	 */
	public DragonScreenController() {
	}
	
	/**
	 * Initializes the controller class. This method is automatically called 
	 * after the fxml file has been loaded. 
	 */
	@FXML
	private void initialize() {
		dragon = new Dragon();
		bank = new Bank();
	
		dragonHungerLabel.setText(value.dragonHungerWords[dragon.getDragonHunger()]);
		dragonHorninessLabel.setText(value.dragonHorninessWords[dragon.getDragonHorniness()]);
		dragonMoodLabel.setText(value.dragonMoodWords[dragon.getDragonMood()]);
		dragonHealthLabel.setText(value.dragonHealthWords[dragon.getDragonHealth()]);
		
		dragonStaminaCounter.setText("" + dragon.getDragonStamina());
		dragonInfamyCounter.setText("" + dragon.getDragonInfamy());
		dragonMagicCounter.setText("" + dragon.getDragonMagic());
		
		dragonGoldCounter.setText(bank.getDragonGold() + " gold");
		
	}

	/**
	 * Updates the dragon stats
	 * @return dragonHunger
	 * @return dragonHorniness
	 * @return dragonMod
	 * @return dragonHealth
	 */
	private void dragonGUIRefresh() {
		dragonHungerLabel.setText(value.dragonHungerWords[dragon.getDragonHunger()]);
		dragonHorninessLabel.setText(value.dragonHorninessWords[dragon.getDragonHorniness()]);
		dragonMoodLabel.setText(value.dragonMoodWords[dragon.getDragonMood()]);
		dragonHealthLabel.setText(value.dragonHealthWords[dragon.getDragonHealth()]);
		dragonStaminaCounter.setText("" + dragon.getDragonStamina());
		dragonInfamyCounter.setText("" + dragon.getDragonInfamy());
		dragonMagicCounter.setText("" + dragon.getDragonMagic());
		dragonGoldCounter.setText(bank.getDragonGold() + " gold");
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
