package com.dragongame.game.events.Sea;

import java.util.Random;

import com.dragongame.game.Main;


public class SeaEvents {

	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 2;
	private static final int EVENT_ROLLER_MIN = 1;
	private Random random = new Random();
	private SeaEventsVictory seaWin = new SeaEventsVictory();
	private SeaBattle seaBattle = new SeaBattle();
	
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
	
	public void seaEventRoulette() {
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			seaEvent1();
			break;
		
		case 2:
			seaEvent2();
			break;
		}
	}
	
	
	/**
	 * Sea Event 1: Pirate Ship Encounter
	 */
	private void seaEvent1() {
//-------------------------------------------------------------------------
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A Ship with Black Sails");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("A large ship with black sails and a skull and crossbones comes near. "
		+ "Aboard the vessel men toil, completely unaware of your presence.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(7);
		
		//Set up the Button Text and Visibility
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		Main.getMapEventScreenController().setButtonText
		("Attack Ship", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------		
		
		//Engages in battle with the pirates. Brings up the battle menu
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
			Main.eventMenuVisibility(false);
			seaWin.seaWin1();
			Main.getBattleScreenController().getBattle().setBattleStat("Might");
			seaBattle.seaPirateBattle();
			Main.battleScreenVisibility(true);
		});
		
		//Leaves the event screen
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
			Main.getMapEventScreenController().closeEvent();
		});
		
		if (Main.getDragonScreenController().getDragon().getDragonMood() == 5) {
			Main.getMapEventScreenController().eventButton2.setVisible(false);
		}
//-------------------------------------------------------------------------		
		
		};
		
		
	/**
	 * Sea Event 2: Pleasure Yacht Encounter
	 */
	private void seaEvent2() {
		
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A Ship with White Sails");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("A gigantic ship with white sails approaches you unknowingly. "
		+ "Aboard are men and women wearing jewels and silken clothing.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(4);
		
		//Set up the Button Text 
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, true, false, false, false);
		//Set up the Button Visibility
		Main.getMapEventScreenController().setButtonText
		("Raid Ship", "Kidnap Noble", "Leave", null, null, null);
		
//-------------------------------------------------------------------------
		
		//Fight the Ship for Plunder
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
			Main.eventMenuVisibility(false);
			seaWin.seaWin2();
			Main.getBattleScreenController().getBattle().setBattleStat("Might");
			Main.battleScreenVisibility(true);
		});
		
		//Kidnap a noble woman
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
			Main.eventMenuVisibility(false);
			seaWin.seaWin3();
			Main.getBattleScreenController().getBattle().setBattleStat("Might");
			Main.getMapEventScreenController().getMapEvent().setEventDifficulty(5);
			Main.battleScreenVisibility(true);
		});
		
		//Leave
		Main.getMapEventScreenController().eventButton3.setOnAction(e -> {
			Main.getMapEventScreenController().closeEvent();
		});
		
		if (Main.getDragonScreenController().getDragon().getDragonMood() == 5) {
			Main.getMapEventScreenController().eventButton3.setVisible(false);
		}
//-------------------------------------------------------------------------		
		
	}
	
	
	
	
}
