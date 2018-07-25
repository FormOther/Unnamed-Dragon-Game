package com.dragongame.game.events.Rural;

import java.util.Random;

import com.dragongame.game.Main;

public class RuralAreaEvents {

	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 2;
	private static final int EVENT_ROLLER_MIN = 1;
	private Random random = new Random();
	RuralAreaVictory ruralWin = new RuralAreaVictory();
	
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
	
	public void ruralAreaEventRoulette() {
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			ruralAreaEvent1();
			break;
		
		case 2:
			ruralAreaEvent2();
			break;
		}
	}
	
	private void ruralAreaEvent1() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A Celebration in the Fields");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("While prowling around the countryside you hear the laughter and conversation of many people. "
		+ "It appears as though the local peasants have set up for some sort of festival and "
		+ "Many beautiful maidens have attended along with prize livestock. "
		+ "The villagers don't appear to have noticed you yet.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(5);
		
		//Set up the Button Text and Visibility
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, true, false, false, false);
		Main.getMapEventScreenController().setButtonText
		("Raze the Fair", "Demand Tribute", "Leave", null, null, null);
		
//-------------------------------------------------------------------------	
		
		//Destroy the Celebration
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		ruralWin.ruralFairKill();
		Main.getBattleScreenController().getBattle().setBattleStat("Might");
		Main.battleScreenVisibility(true);
		});
		
		//Extort the Villagers
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		ruralWin.ruralFairExtort();
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
		};
	
	private void ruralAreaEvent2() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("Training in the Field");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("You notice several dozen young men and women training with a collection of swords and spears under "
		+ "the watchful gaze of a grizzled man in armor. They don't appear to have noticed you yet.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(5);
		
		//Set up the Button Text 
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		//Set up the Button Visibility
		Main.getMapEventScreenController().setButtonText
		("Attack the Militia", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------	
		
				//Destroy the Militia
			Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
			Main.eventMenuVisibility(false);
			ruralWin.ruralTrainingKill();
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
	
	
}
