package com.dragongame.game.model;

public class Bank {

	private int dragonGold;
	private int dragonGoldMax;
	private int dragonGoldMin;
	
	public Bank() {
		this.dragonGold = dragonGold;
		
		this.dragonGoldMax = 5000;
		this.dragonGoldMin = 0;

	}

//------------------------------------------------------------

	public int getDragonGold() {
		return this.dragonGold;
	}
		
	public void setDragonGold(int dragonGold) {
		dragonGold = this.dragonGold;
	}
		
	public void addDragonGold(int amount) {
		dragonGold += amount;
		dragonGoldMaxCap();
		
	}
		
	public void minusDragonGold(int amount) {
		dragonGold -= amount;
		dragonGoldMinCap();
		
	}

	public void dragonGoldMaxCap() {
		if (dragonGold > dragonGoldMax) {
			dragonGold = dragonGoldMax;
		}
	}
	
	public void dragonGoldMinCap () {
		if (dragonGold <= dragonGoldMin) {
			dragonGold = dragonGoldMin;
		} 
	}
	
//------------------------------------------------------------
		
	public int getDragonGoldMax() {
		return this.dragonGoldMax;
	}
	
	public void setDragonGoldMax(int goldMax) {
		goldMax = this.dragonGoldMax;
	}
	
	
}
