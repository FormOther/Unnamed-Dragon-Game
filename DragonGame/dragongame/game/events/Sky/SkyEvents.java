package com.dragongame.game.events.Sky;

import java.util.Random;

import com.dragongame.game.Main;

public class SkyEvents {


	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 2;
	private static final int EVENT_ROLLER_MIN = 1;
	private Random random = new Random();
	SkyEventsVictory skyWin = new SkyEventsVictory();
	
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
	
	public void skyEventRoulette() {
		//If I ever want to change where the button function reset method goes, here is a good place.
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			skyEvent1();
			break;
		
		case 2:
			skyEvent2();
			break;
		}
	}
	
	private void skyEvent1() {
//-------------------------------------------------------------------------	
		
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A shriek from above");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("You hear a piercing shriek from behind you. Angling to the side, you can see a large griffin on your tail "
		+ "intent on shredding you to ribbons with it's talons!");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(7);
		
		//Set up the Button Text and Visibility
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		Main.getMapEventScreenController().setButtonText
		("Defend Yourself", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------		
		
		//Starts the battle with the Griffin
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		skyWin.skyWin1();
		Main.getBattleScreenController().getBattle().setBattleStat("Might");
		Main.battleScreenVisibility(true);
		});
		
		//Leaves the battle 
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
		Main.getMapEventScreenController().closeEvent();
		});
		
		if (Main.getDragonScreenController().getDragon().getDragonMood() == 5) {
			Main.getMapEventScreenController().eventButton2.setVisible(false);
		}
//-------------------------------------------------------------------------			
		
		};
		
		
	
	private void skyEvent2() {
//-------------------------------------------------------------------------	
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A Ship in the Sky");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("While flying through the air, you spot a large airship floating not too far away. "
		+ "As you get closer you can smell that there is gold on board, and a lot of it! "
		+ "You begin to fly closer when several cannons in the side of the airship swivel in your direction, "
		+ "ready to engage should you choose to attack!");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(8);
		
		//Set up the Button Text 
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		//Set up the Button Visibility
		Main.getMapEventScreenController().setButtonText
		("Raid Ship", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------			

		//Engage the flying ship in battle
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		skyWin.skyWin2();
		Main.getBattleScreenController().getBattle().setBattleStat("Might");
		Main.battleScreenVisibility(true);
		});	
		
		//Functions for the buttons
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
		Main.getMapEventScreenController().closeEvent();
		});
		
		if (Main.getDragonScreenController().getDragon().getDragonMood() == 5) {
			Main.getMapEventScreenController().eventButton2.setVisible(false);
		}
//-------------------------------------------------------------------------	
	}
	
	
	
}
