package com.dragongame.game.events.TradeRoute;

import com.dragongame.game.Main;

public class TradeRouteVictory {
	

	public void tradeRouteCaravanWin1() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("You obliterate the caravan, scattering the merchants and killing the guards who defend it!");
					
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
	
	public void tradeRouteCaravanWin2() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("After making short work of their guards, the terrified merchants give you the majority of their goods!");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().getEventDifficulty();
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(false, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			(null, "Take goods", null, null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getDragonScreenController().getDragon().incrementDragonHunger(-1);
				Main.getDragonScreenController().getDragon().incrementDragonMood(-2);
				Main.eventMenuVisibility(false);
			});		
		}
		
		public void tradeRouteKnightWin() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("The knight crumples to the ground as you deal him a killing blow.");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().getEventDifficulty();
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(false, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			(null, "Loot corpse", null, null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getDragonScreenController().getDragon().incrementDragonHunger(-1);
				Main.getDragonScreenController().getDragon().incrementDragonMood(-2);
				Main.eventMenuVisibility(false);
			});			
			}
		
		
		}
