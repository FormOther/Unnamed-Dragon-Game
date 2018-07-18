package com.dragongame.game.events;

import java.util.Random;

import com.dragongame.game.Main;

public class ForestEvents {

	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 2;
	private static final int EVENT_ROLLER_MIN = 1;
	private Random random = new Random();
	
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
	
	public void forestEventRoulette() {
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			forestEvent1();
			break;
		
		case 2:
			forestEvent2();
			break;
		}
	}
	
	private void forestEvent1() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("Something buried in the Forest");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("You notice two shifty looking men pat down a recently disturbed patch of earth with their shovels before "
		+ "sneaking off into the shadows. Judging from the size of the mound, they appear to have buried something "
		+ "rather large and heavy...");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(3);
		
		//Set up the Button Text and Visibility
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		Main.getMapEventScreenController().setButtonText
		("Dig Up", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------	
		
		//Attempt to dig up the treasure 
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		Main.getBattleScreenController().getBattle().setBattleStat("Might");
		Main.battleScreenVisibility(true);
		});
				
		//Leave the Event
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		});
				
//-------------------------------------------------------------------------		
		};
	
		
	private void forestEvent2() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A quiet rustle in the trees");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("You are wandering through the woods when an arrow buries itself into a tree near your head. "
		+ "Hissing you turn and see a tall elf in a long cloak nock another arrow and aim at you! ");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(6);
		
		//Set up the Button Text 
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		//Set up the Button Visibility
		Main.getMapEventScreenController().setButtonText
		("Defend Yourself", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------	
		
				//Attack the Elf
				Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
				Main.eventMenuVisibility(false);
				Main.getBattleScreenController().getBattle().setBattleStat("Might");
				Main.battleScreenVisibility(true);
				});
						
				//Leave the Event
				Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.eventMenuVisibility(false);
				});
						
//-------------------------------------------------------------------------		
	}
	
	
}
