package com.dragongame.game.events.Sea;

import com.dragongame.game.Main;

public class SeaEventsVictory {
	
	
	public void seaWin1() {
	//-------------------------------------------------------------------------
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("VICTORY");
				
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("Pirates flee from the wreckage of their ship as you finish off their remaining crewmates.");
				
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
	
	public void seaWin2() {
	//-------------------------------------------------------------------------
		//Set Event Title
		Main.getMapEventScreenController().getMapEvent().setEventTitle
		("VICTORY");
				
		//Set Event Content
		Main.getMapEventScreenController().getMapEvent().setEventContent
		("Nobles flounder in the water, the remains of the splintered ship strewn around them.");
				
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
	
	public void seaWin3() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("You leave the sinking ship and it's floundering passengers. "
			+ "The noble woman you kidnapped sobs and screams in terror.");
					
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
