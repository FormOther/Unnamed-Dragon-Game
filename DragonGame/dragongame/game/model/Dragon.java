package com.dragongame.game.model;

import com.dragongame.game.util.StatValueConversion;
import com.dragongame.game.view.DragonScreenController;
import com.dragongame.game.Main;

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
	private static final int DRAGON_HUNGER_MIN = 0;
	private static final int DRAGON_HUNGER_MAX = 4;
	
	private int dragonHorniness;
	private static final int DRAGON_HORNINESS_MIN = 0;
	private static final int DRAGON_HORNINESS_MAX = 3;
	
	private int dragonMood;
	private static final int DRAGON_MOOD_MIN = 0;
	private static final int DRAGON_MOOD_MAX = 5;
	
	private int dragonHealth;
	private static final int DRAGON_HEALTH_MIN = 0;
	private static final int DRAGON_HEALTH_MAX = 3;
	
	private int dragonMight;
	private int dragonMightRestore;
	private static final int DRAGON_MIGHT_MIN = 0;
	private static final int DRAGON_MIGHT_MAX = 20;
	
	private int dragonIntellect;
	private int dragonIntellectRestore;
	private static final int DRAGON_INTELLECT_MIN = 0;
	private static final int DRAGON_INTELLECT_MAX = 20;
	
	private int dragonInfamy;
	private int dragonInfamyRestore;
	private static final int DRAGON_INFAMY_MIN = 0;
	private static final int DRAGON_INFAMY_MAX = 20;
	
	private int dragonDefense;
	private static final int DRAGON_DEFENSE_MIN = 0;
	private static final int DRAGON_DEFENSE_MAX = 10;
	
	

	/**
	 * Constructor with some initial data.
	 * @param object
	 */
	public Dragon() {
		this.dragonName = "The Dragon";
		
		// Initial dummy data for testing.
		this.dragonHunger = 4;
		this.dragonHorniness = 3;
		this.dragonMood = 0;
		this.dragonHealth = 3;
		
		this.dragonMight = 20;
		this.dragonMightRestore = dragonMight;
		
		this.dragonIntellect = 2;
		this.dragonIntellectRestore = dragonIntellect;
		
		this.dragonInfamy = 0;
		this.dragonInfamyRestore = dragonInfamy;
		
		this.dragonDefense = 5;
	}
	
//------------------------------------------------------------
	
	public String getDragonName() {
		return this.dragonName;
	}
	
	public void setDragonName(String dragonName) {
		this.dragonName = dragonName;
	}
	
//------------------------------------------------------------
	
	public int getDragonHunger() {
		return dragonHunger;
	}
		
	public void setDragonHunger(int dragonHunger) {
		this.dragonHunger = Math.min(Math.max(dragonHunger, DRAGON_HUNGER_MIN), DRAGON_HUNGER_MAX);
		Main.getDragonScreenController().dragonGUIRefresh();
	}
	
	public void incrementDragonHunger(int increment) {
		setDragonHunger(getDragonHunger()+ increment);
	}
	
//------------------------------------------------------------
	
	public int getDragonHorniness() {
		return this.dragonHorniness;
	}
	
	public void setDragonHorniness(int dragonHorniness) {
		this.dragonHorniness = Math.min(Math.max(dragonHorniness, DRAGON_HORNINESS_MIN), DRAGON_HORNINESS_MAX);
		Main.getDragonScreenController().dragonGUIRefresh();
	}
		
	public void incrementDragonHorniness(int increment) {
		setDragonHorniness(getDragonHorniness()+ increment);
	}
	
//------------------------------------------------------------
	
	public int getDragonMood() {
		return this.dragonMood;
	}
	
	public void setDragonMood(int dragonMood) {
		this.dragonMood = Math.min(Math.max(dragonMood, DRAGON_MOOD_MIN), DRAGON_MOOD_MAX);
		Main.getDragonScreenController().dragonGUIRefresh();
	}

	public void incrementDragonMood(int increment) {
		setDragonMood(getDragonMood() + increment);
	}
	
//------------------------------------------------------------
	
	public int getDragonHealth() {
		return this.dragonHealth;
	}
	
	public void setDragonHealth(int dragonHealth) {
		this.dragonHealth = Math.min(Math.max(dragonHealth, DRAGON_HEALTH_MIN), DRAGON_HEALTH_MAX);
		Main.getDragonScreenController().dragonGUIRefresh();
	}

	public void incrementDragonHealth(int increment) {
		setDragonHealth(getDragonHealth() + increment);
	}
	
//------------------------------------------------------------
	
	public int getDragonMight() {
		return this.dragonMight;
	}
	
	public void setDragonMight(int dragonMight) {
		 this.dragonMight =  Math.min(Math.max(dragonMight, DRAGON_MIGHT_MIN), DRAGON_MIGHT_MAX);
			Main.getDragonScreenController().dragonGUIRefresh();
	}
	
	public void incrementDragonMight(int increment) {
		setDragonMight(getDragonMight() + increment);
	}
	
	public int getDagonMightRestoreValue() {
		return this.dragonMightRestore;
	}
	
	public void setDragonMightRestoreValue() {
		this.dragonMightRestore = getDragonMight();
	}
	
//------------------------------------------------------------
	
	public int getDragonIntellect() {
		return this.dragonIntellect;
	}
	
	public void setDragonIntellect(int dragonIntellect) {
		 this.dragonIntellect = Math.min(Math.max(dragonIntellect, DRAGON_INTELLECT_MIN), DRAGON_INTELLECT_MAX);
			Main.getDragonScreenController().dragonGUIRefresh();
	}
	
	public void incrementDragonIntellect(int increment) {
		setDragonIntellect(getDragonIntellect() + increment);
	}
	
	public int getDagonIntellectRestoreValue() {
		return this.dragonIntellectRestore;
	}
	
	public void setDragonIntellectRestoreValue() {
		this.dragonIntellectRestore = getDragonIntellect();
	}
//------------------------------------------------------------
	
	public int getDragonInfamy() {
		return this.dragonInfamy;
	}
	
	public void setDragonInfamy(int dragonInfamy) {
		 this.dragonInfamy =  Math.min(Math.max(dragonInfamy, DRAGON_INFAMY_MIN), DRAGON_INFAMY_MAX);
			Main.getDragonScreenController().dragonGUIRefresh();
	}
	
	public void incrementDragonInfamy(int increment) {
		setDragonInfamy(getDragonInfamy() + increment);
	}
	
	public int getDagonInfamyRestoreValue() {
		return this.dragonInfamyRestore;
	}
	
	public void setDragonInfamyRestoreValue() {
		this.dragonInfamyRestore = getDragonInfamy();
	}
	
//------------------------------------------------------------
	
	public int getDragonDefense() {
		return this.dragonDefense;
	}

	public void setDragonDefense(int dragonDefense) {
		this.dragonDefense =  Math.min(Math.max(dragonDefense, DRAGON_DEFENSE_MIN), DRAGON_DEFENSE_MAX);
	}

	public void incrementDragonDefense (int increment) {
		setDragonDefense(getDragonDefense() + increment);
	}
	
//------------------------------------------------------------	
	
	public void killDragon() {
		setDragonMight(0);
		setDragonIntellect(0);
		setDragonInfamy(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
