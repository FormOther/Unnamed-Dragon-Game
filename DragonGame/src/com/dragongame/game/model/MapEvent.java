package com.dragongame.game.model;

import com.dragongame.game.Main;
import com.dragongame.game.view.MapEventScreenController;


public class MapEvent {

	private String eventTitle;
	private String eventContent;
	private int eventDifficulty;
	private static final int EVENT_DIFFICULTY_MAX = 10;
	private static final int EVENT_DIFFICULTY_MIN = 0;
	
	//The button name options
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String option5;
	private String option6;
	
	
	public MapEvent() {
		this.eventTitle = "Map Title Goes Here";
		this.eventContent = "Content Goes Here";
				
		this.eventDifficulty = 0;
		
		this.option1 = "Button1";
		this.option2 = "Button2";
		this.option3 = "Button3"; 
		this.option4 = "Button4";
		this.option5 = "Button5";
		this.option6 = "Button6";
	}
	
//----------------------------------------------------------	
	
	public String getEventTitle() {
		return eventTitle;
	}
	
	public void setEventTitle(String title) {
		this.eventTitle = title;
	}
	
//----------------------------------------------------------	
	
	public String getEventContent() {
		return eventContent;
	}
	
	public void setEventContent(String content) {
		Main.getMapEventScreenController().resetButtonActions();
		this.eventContent = content;
	}
	
//----------------------------------------------------------
	public int getEventDifficulty() {
		return eventDifficulty;
	}
	
	public void setEventDifficulty(int difficulty) {
		this.eventDifficulty = Math.min(Math.max(difficulty, EVENT_DIFFICULTY_MIN), EVENT_DIFFICULTY_MAX);
	}
	
	public void incrementEventDifficulty(int increment) {
		setEventDifficulty(getEventDifficulty() + increment);
	}
	
//----------------------------------------------------------	
	
	public String getOption1() {
		return option1;
	}
	
	public void setOption1(String option) {
		this.option1 = option;
	}
	
//----------------------------------------------------------	
	
	public String getOption2() {
		return option2;
	}
		
	public void setOption2(String option) {
		this.option2 = option;
	}	
	
//----------------------------------------------------------	
		
	public String getOption3() {
		return option3;
	}
		
	public void setOption3(String option) {
		this.option3 = option;
	}
		
//----------------------------------------------------------	
		
	public String getOption4() {
		return this.option4;
	}
		
	public void setOption4(String option) {
		this.option4 = option;
	}
		
//----------------------------------------------------------	
		
	public String getOption5() {
		return this.option5;
	}
		
	public void setOption5(String option) {
		this.option5 = option;
	}
		
//----------------------------------------------------------	
		
	public String getOption6() {
		return this.option6;
	}
		
	public void setOption6(String option) {
		this.option6 = option;
	}
		
//----------------------------------------------------------	
		
}
