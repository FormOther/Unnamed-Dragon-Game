package com.dragongame.game.events;

import java.util.Random;

import com.dragongame.game.Main;

public class CityMainEvents {

	private int eventRoll;
	private static final int EVENT_ROLLER_MAX = 1;
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
	
	public void cityMainEventRoulette() {
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			cityMainEvent1();
			break;

		}
	}
	
	private void cityMainEvent1() {
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("The Capital");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("The Capital City of the Region stands tall and proud.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(10);
		
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
				Main.getBattleScreenController().getBattle().setBattleStat("Might");
				Main.battleScreenVisibility(true);
				});
						
				//Leave the Event
				Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.eventMenuVisibility(false);
				});
						
//-------------------------------------------------------------------------	
		};
	

}
