package com.dragongame.game.model;

import com.dragongame.game.Main;

public class DateTracker {

	private int currentYear;
	private static final int CURRENT_YEAR_MIN = 1;
	private static final int CURRENT_YEAR_MAX = 9999999;
	
	public DateTracker() {
		this.currentYear = 1;
	}
		
//------------------------------------------------------------
	
	public int getCurrentYear() {
		return currentYear;
	}
	
	public void setCurrentYear(int currentYear) {
		this.currentYear = Math.min(Math.max(currentYear, CURRENT_YEAR_MIN), CURRENT_YEAR_MAX);
		Main.getGameMapController().updateDate();
		Main.getGameLairController().updateDate();
	}
	
	public void incrementCurrentYear(int increment) {
		setCurrentYear(getCurrentYear()+ increment);
	}
	
//------------------------------------------------------------	
		
	}

