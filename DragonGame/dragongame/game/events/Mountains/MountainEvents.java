package com.dragongame.game.events.Mountains;

import java.util.Random;

import com.dragongame.game.Main;

public class MountainEvents {

	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 2;
	private static final int EVENT_ROLLER_MIN = 1;
	private Random random = new Random();
	MountainVictory mountainWin = new MountainVictory();
	
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
	
	public void mountainEventRoulette() {
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			mountainEvent1();
			break;
		
		case 2:
			mountainEvent2();
			break;
		}
	}
	
	private void mountainEvent1() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A heavily guarded mineshaft");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("In the crags of the mountain you notice a mineshaft entrance packed with laborers. "
		+ "Several well armed guards standby as the laborers load several crates full of precious metals and gemstones. ");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(7);
		
		//Set up the Button Text and Visibility
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		Main.getMapEventScreenController().setButtonText
		("Raid the Mine", "Leave", null, null, null, null);

//-------------------------------------------------------------------------	
		
				//Attack the Mine
				Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
				Main.eventMenuVisibility(false);
				mountainWin.raidMineWin();
				Main.getBattleScreenController().getBattle().setBattleStat("Might");
				Main.battleScreenVisibility(true);
				});
						
				//Leave the Event
				Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getMapEventScreenController().closeEvent();
				});
				
				if (Main.getDragonScreenController().getDragon().getDragonMood() == 5) {
					Main.getMapEventScreenController().eventButton2.setVisible(false);
				}		
//-------------------------------------------------------------------------			
			}		
		
		
	
	private void mountainEvent2() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A caravan on a mountain path");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("A several ox-drawn wagons trundle around the mountain trail, loaded high with crates and parcels of precious metals. "
		+ "Alongside them several hard-eyed men and women wielding steel weaponry and wearing heavy armor keep alert "
		+ "for the faintest sign of trouble. They have not yet noticed your approach.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(8);
		
		//Set up the Button Text 
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, true, false, false, false);
		//Set up the Button Visibility
		Main.getMapEventScreenController().setButtonText
		("Raid the Caravan", "Demand Tribute", "Leave", null, null, null);
		
//-------------------------------------------------------------------------	
		
			//Attack the Caravan
			Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
			Main.eventMenuVisibility(false);
			mountainWin.raidCaravanWin();
			Main.getBattleScreenController().getBattle().setBattleStat("Might");
			Main.battleScreenVisibility(true);
			});
		
			//Extort the Caravan
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
			Main.eventMenuVisibility(false);
			mountainWin.extortCaravanWin();
			Main.getBattleScreenController().getBattle().setBattleStat("Might");
			Main.battleScreenVisibility(true);
			});
				
			//Leave the Event
			Main.getMapEventScreenController().eventButton3.setOnAction(e -> {
			Main.getMapEventScreenController().closeEvent();
			});
			
			if (Main.getDragonScreenController().getDragon().getDragonMood() == 5) {
				Main.getMapEventScreenController().eventButton3.setVisible(false);
			}
				
//-------------------------------------------------------------------------		
	}
	
	
}
