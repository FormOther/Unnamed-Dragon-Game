package com.dragongame.game.events.Sea;

import java.util.Random;

import com.dragongame.game.Main;

public class SeaBattle {
	
	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 3;
	private static final int EVENT_ROLLER_MIN = 1;
	
	Random random = new Random();

	public void seaPirateBattle() {
		
		//Set the title for the Battle
		Main.getBattleScreenController().getBattle().setBattleTitle
		("Fighting Pirates!");
		
		//Set initial flavor text for the Battle
		Main.getBattleScreenController().getBattle().setbattleContent
		("You are currently fighting the pirates!");

		
	}
	/**
	 * This bottom section would be to adjust the flavor text of the game. 
	 * I'm not going to implement it now because it's not part of the Minimum Viable Project but I'll revisit it eventually.
	 * 
	 * 
	//--------------------------------------------------------
	
		public int getEventRoll() {
			return this.eventRoll;
		}
		
		public void setEventRoll(int roll) {
			this.eventRoll = roll;
		}
		
		public int rollEventRoll() {
			this.eventRoll = random.nextInt(EVENT_ROLLER_MAX) + EVENT_ROLLER_MIN;
			return this.eventRoll;
		}
		
	//--------------------------------------------------------
		
		public void seaBattleInjured() {
			rollEventRoll();
			switch (getEventRoll()) {
			
			case 1:
				
				break;
			
			case 2:
				
				break;
			}
		}
	
	public void seaBattleFlavorText() {
		
	}
	*/
	
	
}
