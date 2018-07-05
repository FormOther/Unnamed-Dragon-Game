package com.dragongame.game.model;

import com.dragongame.game.util.ValueConversion;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for the Player's Dragon
 * 
 * @author Guy
 */
public class Dragon {

	
	private String dragonName;
	private int dragonHunger;
	private int dragonHorniness;
	private int dragonMood;
	private int dragonHealth;
	
	private int dragonStamina;
	private int dragonInfamy;
	private int dragonMagic;
	
	
	/**
	 * Default constructor.
	 */
	public Dragon() {
		this(null);
	}

	/**
	 * Constructor with some initial data.
	 * @param object
	 */
	public Dragon(String dragonName) {
		this.dragonName = dragonName;
		
		// Initial dummy data for testing.
		this.dragonHunger = 0;
		this.dragonHorniness = 3;
		this.dragonMood = 0;
		this.dragonHealth = 2;
		
		this.dragonStamina = 0;
		this.dragonInfamy = 0;
		this.dragonMagic = 0;
		
	}
	
//------------------------------------------------------------
	
	public String getDragonName() {
		return this.dragonName;
	}
	
	public void setDragonName(String dragonName) {
		dragonName = this.dragonName;
	}
	
//------------------------------------------------------------
	
	public int getDragonHunger() {
		return dragonHunger;
	}
		
	public void setDragonHunger(int dragonHunger) {
		dragonHunger = this.dragonHunger;
	}
	
	public void addDragonHunger() {
		dragonHunger ++;
		dragonHungerMaxCap(3);
	}
	
	public void minusDragonHunger() {
		dragonHunger --;
		dragonHungerMinCap(0);
	}
	
	public void dragonHungerMaxCap(int highCap) {
		if (dragonHunger >= highCap) {
			dragonHunger = highCap;
		}
	}
	
	public void dragonHungerMinCap (int minCap) {
		if (dragonHunger <= minCap) {
			dragonHunger = minCap;
		} 
	}
	
//------------------------------------------------------------
	
	public int getDragonHorniness() {
		return this.dragonHorniness;
	}
	
	public void setDragonHorniness(int dragonHorniness) {
		dragonHorniness = this.dragonHorniness;
	}

	public void addDragonHorniness() {
		dragonHorniness ++;
		dragonHorninessMaxCap(3);
	}
	
	public void minusDragonHorniness() {
		dragonHorniness --;
		dragonHorninessMinCap(0);
	}
	
	public void dragonHorninessMaxCap(int highCap) {
		if (dragonHorniness >= highCap) {
			dragonHorniness = highCap;
		}
	}
	
	public void dragonHorninessMinCap (int minCap) {
		if (dragonHorniness <= minCap) {
			dragonHorniness = minCap;
		} 
	}
	
//------------------------------------------------------------
	
	public int getDragonMood() {
		return this.dragonMood;
	}
	
	public void setDragonMood(int dragonMood) {
		dragonMood = this.dragonMood;
	}

	public void addDragonMood() {
		dragonMood ++;
		dragonMoodMaxCap(5);
	}
	
	public void minusDragonMood() {
		dragonMood --;
		dragonMoodMinCap(0);
	}
	
	public void dragonMoodMaxCap(int highCap) {
		if (dragonMood >= highCap) {
			dragonMood = highCap;
		}
	}
	
	public void dragonMoodMinCap (int minCap) {
		if (dragonMood <= minCap) {
			dragonMood = minCap;
		} 
	}
	
//------------------------------------------------------------
	
	public int getDragonHealth() {
		return this.dragonHealth;
	}
	
	public void setDragonHealth(int dragonHealth) {
		dragonHealth = this.dragonHealth;
	}

	public void addDragonHealth() {
		dragonHealth ++;
		dragonHealthMaxCap(2);
	}
	
	public void minusDragonHealth() {
		dragonHealth --;
		dragonHealthMinCap(0);
	}
	
	public void dragonHealthMaxCap(int highCap) {
		if (dragonHealth >= highCap) {
			dragonHealth = highCap;
		}
	}
	
	public void dragonHealthMinCap (int minCap) {
		if (dragonHealth <= minCap) {
			dragonHealth = minCap;
		} 
	}
	
//------------------------------------------------------------
	
	public int getDragonStamina() {
		return this.dragonStamina;
	}
	
	public void setDragonStamina(int dragonStamina) {
		dragonStamina = this.dragonStamina;
	}
	
	public void addDragonStamina() {
		dragonStamina += 1;
	}
	
	public void minusDragonStamina() {
		dragonStamina -= 1;
		dragonStaminaMinCap(0);
	}
	
	public void dragonStaminaMaxCap(int highCap) {
		if (dragonStamina >= highCap) {
			dragonStamina = highCap;
		}
	}
	
	public void dragonStaminaMinCap (int minCap) {
		if (dragonStamina <= minCap) {
			dragonStamina = minCap;
		} 
	}
	
//------------------------------------------------------------
	
	public int getDragonInfamy() {
		return this.dragonInfamy;
	}
	
	public void setDragonInfamy(int dragonInfamy) {
		dragonInfamy = this.dragonInfamy;
	}
	
	public void addDragonInfamy() {
		dragonInfamy += 1;
		dragonInfamyMaxCap(20);
	}
	
	public void minusDragonInfamy() {
		dragonInfamy -= 1;
		dragonInfamyMinCap(0);
	}
	
	public void dragonInfamyMaxCap(int highCap) {
		if (dragonInfamy >= highCap) {
			dragonInfamy = highCap;
		}
	}
	
	public void dragonInfamyMinCap (int minCap) {
		if (dragonInfamy <= minCap) {
			dragonInfamy = minCap;
		} 
	}
	
//------------------------------------------------------------
	
	public int getDragonMagic() {
		return this.dragonMagic;
	}
	
	public void setDragonMagic(int dragonMagic) {
		dragonMagic = this.dragonMagic;
	}
	
	public void addDragonMagic() {
		dragonMagic += 1;
	}
	
	public void minusDragonMagic() {
		dragonMagic -= 1;
		dragonMagicMinCap(0);
	}
	
	public void dragonMagicMaxCap(int highCap) {
		if (dragonMagic >= highCap) {
			dragonMagic = highCap;
		}
	}
	
	public void dragonMagicMinCap (int minCap) {
		if (dragonMagic <= minCap) {
			dragonMagic = minCap;
		} 
	}
	
//------------------------------------------------------------

	

	
	
	
}
