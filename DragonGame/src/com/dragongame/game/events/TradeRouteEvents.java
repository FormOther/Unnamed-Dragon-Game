package com.dragongame.game.events;

import java.util.Random;

import com.dragongame.game.Main;

public class TradeRouteEvents {

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
	
	public void tradeRouteEventRoulette() {
		rollEventRoll();
		switch (getEventRoll()) {
		
		case 1:
			tradeRouteEvent1();
			break;
		
		case 2:
			tradeRouteEvent2();
			break;
		}
	}
	
	private void tradeRouteEvent1() {
//-------------------------------------------------------------------------	
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A Merchant Caravan approaches");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("A several horse-drawn wagons trundle down the road, loaded high with crates, chests, and rolls of fabric. " + 
		"Alongside them several hard-eyes men and women wielding crossbows keep alert for the faintest sign of trouble. " + 
		"They have not yet noticed your approach.");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(6);
		
		//Set up the Button Text and Visibility
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, true, false, false, false);
		Main.getMapEventScreenController().setButtonText
		("Raid Caravan", "Demand Tribute", "Leave", null, null, null);
		
//-------------------------------------------------------------------------	
		
		//Raze the caravan
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		Main.getBattleScreenController().getBattle().setBattleStat("Might");
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(7);
		Main.battleScreenVisibility(true);
		});
		
		//Extort the caravan
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		Main.getBattleScreenController().getBattle().setBattleStat("Might");
		Main.battleScreenVisibility(true);
		});
		
		//Leave
		Main.getMapEventScreenController().eventButton3.setOnAction(e -> {
		Main.eventMenuVisibility(false);
			});
		
//-------------------------------------------------------------------------			
		}
	
	private void tradeRouteEvent2() {
//-------------------------------------------------------------------------			
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("A Wandering Knight appears");
		
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("A knight on horseback notices you and with a immediately draws his sword! "
		+ "With a mighty warcry he spurrs his horse into a headlong charge! ");
		
		//Set Event Difficulty
		Main.getMapEventScreenController().getMapEvent().setEventDifficulty(9);
		
		//Set up the Button Text 
		Main.getMapEventScreenController().setButtonVisibility
		(true, true, false, false, false, false);
		//Set up the Button Visibility
		Main.getMapEventScreenController().setButtonText
		("Defend Yourself", "Leave", null, null, null, null);
		
//-------------------------------------------------------------------------	
		
		Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
		Main.eventMenuVisibility(false);
		Main.getBattleScreenController().getBattle().setBattleStat("Might");
		Main.battleScreenVisibility(true);
		});
		
		//Functions for the buttons
		Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
		Main.eventMenuVisibility(false);
			});
		
//-------------------------------------------------------------------------	
	}
	
}
