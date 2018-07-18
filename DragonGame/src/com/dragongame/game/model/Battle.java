package com.dragongame.game.model;

import java.util.Random;

import com.dragongame.game.Main;

public class Battle {

	private String battleTitle;
	private String battleContent;
	private String battleStat;
	
	private int battleStatValue;
	private static final int BATTLE_STAT_MIN = 0;
	
	private int appliedStatValue;
	private static final int APPLIED_STAT_MIN = 0;
	private static final int APPLIED_STAT_MAX = 10;
	
	private int successChance;
	private static final int SUCCESS_CHANCE_MIN = 0;
	private static final int SUCCESS_CHANCE_MAX = 10;
	
	private int damageChance;
	private static final int DAMAGE_CHANCE_MIN = 0;
	private static final int DAMAGE_CHANCE_MAX = 10;
	
	private int targetWinNumber;
	private static final int TARGET_NUMBER_MIN = 0;
	private static final int TARGET_NUMBER_MAX = 20;
	
	private int battleRoll;
	private static final int BATTLE_ROLL_MIN = 0;
	private static final int BATTLE_ROLL_MAX = 20;
	
	private boolean Victory;
	
	
	private Random random = new Random();
	
	public Battle() {
		this.battleTitle = "Battle";
		this.battleContent = "This is where the flavor text goes.";
		this.battleStat = "Battle Stat";
		
		this.battleStatValue = 0;
		this.appliedStatValue = 0;
		
		this.targetWinNumber = Main.getMapEventScreenController().getMapEvent().getEventDifficulty() * 2;
		
		this.successChance = getTargetWinNumber() / 2;
		this.damageChance = 0;
		
		this.Victory = false;
		
		this.battleRoll = 0;
	}
	
	//----------------------------------------------------------	
	
	public String getBattleTitle() {
		return this.battleTitle;
	}
	
	public void setBattleTitle(String title) {
		this.battleTitle = title;
	}
	
	//----------------------------------------------------------	

	public String getBattleContent() {
		return this.battleContent;
	}
	
	public void setbattleContent(String content) {
		this.battleContent = content;
	}
	
	//----------------------------------------------------------	

	public String getBattleStat() {
		return this.battleStat;
		
	}
	
	public void setBattleStat(String statName) {
		this.battleStat = statName;
		
		switch (statName) {
		case "Might":
			setBattleStatValue(Main.getDragonScreenController().getDragon().getDragonMight());
			break;
			
		case "Intellect":
			setBattleStatValue(Main.getDragonScreenController().getDragon().getDragonIntellect());
			break;
		}
	}
	
	public void battleStatCheck() {
		switch (getBattleStat()) {
		case "Might":
			Main.getDragonScreenController().getDragon().setDragonMight(getBattleStatValue());
			break;
			
		case "Intellect":
			Main.getDragonScreenController().getDragon().setDragonIntellect(getBattleStatValue());
			break;
		}
	}
	
	
	//----------------------------------------------------------	
	
	public int getBattleStatValue() {
		return this.battleStatValue;
	}
	
	public void setBattleStatValue(int value) {
		this.battleStatValue = Math.max(value, BATTLE_STAT_MIN);
	}
	
	public void incrementBattleStatValue(int increment) {
		setBattleStatValue(getBattleStatValue() + increment);
		Main.getBattleScreenController().updateBattleScreen();
	}
	
	//----------------------------------------------------------	
	
	public int getAppliedStatValue() {
		return this.appliedStatValue;
	}
	
	public void setAppliedStatValue(int value) {
		this.appliedStatValue = Math.min(Math.max(value, APPLIED_STAT_MIN), APPLIED_STAT_MAX);
		Main.getBattleScreenController().updateBattleScreen();
		}
	
	public void incrementAppliedStatValue(int increment) {
		setAppliedStatValue(getAppliedStatValue() + increment);
		Main.getBattleScreenController().updateBattleScreen();
	}
	
	//----------------------------------------------------------	
	
	public int getTargetWinNumber() {
		this.targetWinNumber = (Main.getMapEventScreenController().getMapEvent().getEventDifficulty() - getAppliedStatValue()) * 2 ;
		return this.targetWinNumber;
	}
		
	public void setTargetWinNumber(int value) {
		this.targetWinNumber = Math.min(Math.max(value, TARGET_NUMBER_MIN), TARGET_NUMBER_MAX);
	}
		
	public void incrementTargetWinNumber(int increment) {
		setTargetWinNumber(getTargetWinNumber() + increment);
	}
		
	
	//----------------------------------------------------------	
	
	public int getSuccessChance() {	
		this.successChance = Main.getMapEventScreenController().getMapEvent().getEventDifficulty() - getAppliedStatValue();
		return this.successChance;
	}
	
	public void setSuccessChance(int value) {
		this.successChance = Math.min(Math.max(value, SUCCESS_CHANCE_MIN), SUCCESS_CHANCE_MAX);
	}
	
	public void incrementSuccessChance(int increment) {
		setSuccessChance(getSuccessChance() + increment);
	}
	
	//----------------------------------------------------------	
	
	public int getDamageChance() {
		return this.damageChance;
	}
	
	public void setDamageChance(int value) {
		this.damageChance = Math.min(Math.max(value, DAMAGE_CHANCE_MIN), DAMAGE_CHANCE_MAX);
	}
	
	public void incrementDamageChance(int increment) {
		setDamageChance(getDamageChance() + increment);
	}
	
	//----------------------------------------------------------	
	
	public int getBattleRoll() {
		return this.battleRoll;
	}
	
	public void makeBattleRoll() {
		this.battleRoll = random.nextInt(BATTLE_ROLL_MAX) + BATTLE_ROLL_MIN;
	}
	
	//----------------------------------------------------------	
	
	public boolean getVictoryBoolean() {
		return this.Victory;
	}
	
	public void setVictoryBoolean(boolean value) {
		this.Victory = value;
	}
	
	//----------------------------------------------------------
	
	public void winChecker() {
		makeBattleRoll();
		
		if (getBattleRoll() >= getTargetWinNumber()) {
			setVictoryBoolean(true);
		} else {
			setVictoryBoolean(false);
		}
	}
	
	
}
