package com.dragongame.game.events.Port;

import java.util.Random;

import com.dragongame.game.Main;

public class CityPortEvents {

	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 1;
	private static final int EVENT_ROLLER_MIN = 1;
	private Random random = new Random();
	CityPortVictory portRaid = new CityPortVictory();
	
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
	
	public void cityPortEventRoulette() {
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			cityPortEvent1();
			break;

		}
	}
	
	private void cityPortEvent1() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("The port city");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("The city on the coast bustles with commerce.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(9);
		
		//Set up the Button Text and Visibility
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		Main.getMapEventScreenController().setButtonText
		("Raid City", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------	
		
			//Attack the Port City
			/*At some point this is going to trigger a minor siege scene. Something where there will be two skill checks in a row
			 * I'll have to ponder but this will basically be the baby version of the Capital city Raid.
			 */
			Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
			Main.eventMenuVisibility(false);
			portRaid.raidPortWin1();
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
		};
	

	
}
