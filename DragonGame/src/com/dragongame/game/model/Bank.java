package com.dragongame.game.model;

import com.dragongame.game.Main;

public class Bank {

	private int dragonGold;
	private static final int DRAGON_GOLD_MIN = 0;
	private static final int DRAGON_GOLD_MAX = 1000000;
	
	public Bank() {
		this.dragonGold = 0;
	}

//------------------------------------------------------------

	public int getDragonGold() {
		return this.dragonGold;
	}
		
	public void setDragonGold(int dragonGold) {
		this.dragonGold = Math.min(Math.max(dragonGold, DRAGON_GOLD_MIN), DRAGON_GOLD_MAX);
		Main.getDragonScreenController().dragonGUIRefresh();
	}
		
	public void incrementDragonGold(int increment) {
		setDragonGold(getDragonGold()+ increment);
	}
	
//------------------------------------------------------------
	
}
