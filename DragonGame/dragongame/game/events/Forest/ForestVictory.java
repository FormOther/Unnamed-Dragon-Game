package com.dragongame.game.events.Forest;

import com.dragongame.game.Main;

public class ForestVictory {

	public void forestDig() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("You dig up the disturbed ground and find a small satchel of treasure!");
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(false, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			(null, "Loot treasure", null, null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
			Main.getDragonScreenController().getDragon().incrementDragonHunger(-1);
			Main.getDragonScreenController().getDragon().incrementDragonMood(-2);
				Main.eventMenuVisibility(false);
			});		
		}
	
	public void forestElfWin() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("SUCCESS");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("You mercilessly kill several of the elves and the survivors either escape or are too wounded to flee.");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().getEventDifficulty();
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(false, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			(null, "Loot area", null, null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getDragonScreenController().getDragon().incrementDragonHunger(-1);
				Main.getDragonScreenController().getDragon().incrementDragonMood(-2);
				Main.eventMenuVisibility(false);
			});		
		}
		
}
