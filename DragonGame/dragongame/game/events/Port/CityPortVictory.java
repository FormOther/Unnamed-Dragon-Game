package com.dragongame.game.events.Port;

import com.dragongame.game.Main;

public class CityPortVictory {

	public void raidPortWin1() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("Port City Central Plaza");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("You break through the port town's main defenses. You are currently in the center plaza of the city.");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().getEventDifficulty();
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(true, true, true, false, false, false);
			Main.getMapEventScreenController().setButtonText
			("Raid the Docks", "Raid the Marketplace", "Raid the Warehouses", null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
				raidPortDocks();
			});		
			
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				raidPortWarehouses();
			});
			
			Main.getMapEventScreenController().eventButton3.setOnAction(e -> {
				raidPortMarketplace();
			});
		}
	
	public void raidPortDocks() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("Shipyard");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("You tear your way to the ports where the ships are moored and pause. "
			+ "A line of determined sailors with a motley collection of weapons hold their ground between you and the boats.");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().setEventDifficulty(9);
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(true, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			("Attack the Ships", "Leave", null, null, null, null);
					
	//-------------------------------------------------------------------------
							
			Main.getMapEventScreenController().eventButton1.setOnAction(e -> {
				Main.eventMenuVisibility(false);
				raidPortDockWin();
				Main.getBattleScreenController().getBattle().setBattleStat("Might");
				Main.battleScreenVisibility(true);
			});		
			
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getDragonScreenController().getDragon().incrementDragonMood(+1);
				Main.eventMenuVisibility(false);
			});	
			
			if (Main.getDragonScreenController().getDragon().getDragonMood() == 5) {
				Main.getMapEventScreenController().eventButton2.setVisible(false);
			}
		}
		
		public void raidPortWarehouses() {
		//-------------------------------------------------------------------------
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("Warehouse District");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("You make your way to the warehouses and find them completely unguarded in the mayhem of your arrival.");
					
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
	
		public void raidPortMarketplace() {
			//-------------------------------------------------------------------------
				//Set Event Title
				Main.getMapEventScreenController().getMapEvent().setEventTitle
				("Marketplace");
						
				//Set Event Content
				Main.getMapEventScreenController().getMapEvent().setEventContent
				("You follow the screams until you burst into the still crowded marketplace. "
				+ "Citizens scream and flee at your arrival. Several of the market stalls lie completely unguarded.");
						
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
	
		public void raidPortDockWin() {
			//Set Event Title
			Main.getMapEventScreenController().getMapEvent().setEventTitle
			("VICTORY");
					
			//Set Event Content
			Main.getMapEventScreenController().getMapEvent().setEventContent
			("With the sailors either butchered or fled, the ships lay vulnerable to you.");
					
			//Set Event Difficulty
			Main.getMapEventScreenController().getMapEvent().getEventDifficulty();
					
			//Set up the Button Text and Visibility
			Main.getMapEventScreenController().setButtonVisibility
			(false, true, false, false, false, false);
			Main.getMapEventScreenController().setButtonText
			(null, "Loot and sink ships", null, null, null, null);
			
			//-------------------------------------------------------------------------
			
			Main.getMapEventScreenController().eventButton2.setOnAction(e -> {
				Main.getDragonScreenController().getDragon().incrementDragonHunger(-1);
				Main.getDragonScreenController().getDragon().incrementDragonMood(-2);
				Main.eventMenuVisibility(false);
			});	
		}
	
}
