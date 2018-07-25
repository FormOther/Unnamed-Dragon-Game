package com.dragongame.game.events.Sky;

import com.dragongame.game.Main;

public class SkyEventsVictory {

	public void skyWin1() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("The bloodied griffin falls out of the sky, too wounded to continue fighting.");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().getEventDifficulty();
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(false, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			(null, "Eat Griffin", null, null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getDragonScreenController().getDragon().incrementDragonHunger(+1);
				Main.getDragonScreenController().getDragon().incrementDragonMood(-2);
				Main.eventMenuVisibility(false);
			});		
		}
		
		public void skyWin2() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("The airship violently crashes to the ground under your onslaught.");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().getEventDifficulty();
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(false, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			(null, "Loot wreckage", null, null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getDragonScreenController().getDragon().incrementDragonHunger(-1);
				Main.getDragonScreenController().getDragon().incrementDragonMood(-2);
				Main.eventMenuVisibility(false);
			});		
		}	
	
	
	
	
	
	
}
