package com.dragongame.game.view;

import com.dragongame.game.Main;
import com.dragongame.game.model.Battle;
import com.dragongame.game.util.ChanceValueConversion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BattleScreenController {

@FXML
private Label battleTitle;

@FXML
private Label battleText;

@FXML
private Label battleStatName;

@FXML
private Label battleStatValue;

@FXML
private Label battleStatApplyName;

@FXML
private Label battleStatApplyValue;

@FXML
private Label battleSuccessChance;

@FXML
private Label battleHarmChance;

@FXML
public Button increaseSuccessChance;
	
@FXML
public Button decreaseSuccessChance;

@FXML
public Button Engage;

@FXML
public Button Flee;

private Main main;
private static Battle battle;
ChanceValueConversion chanceConversion = new ChanceValueConversion();


public BattleScreenController() {
}

public static Battle getBattle() {
	return battle;
}

@FXML
private void initialize() {
	battle = new Battle();
	
	battleTitle.setText(battle.getBattleTitle());
	
	battleText.setText(battle.getBattleContent());
	
	battleStatName.setText(battle.getBattleStat());
	battleStatValue.setText(""+battle.getBattleStatValue());
	
	
	battleStatApplyName.setText("Apply " + battle.getBattleStat());
	battleStatApplyValue.setText("" + battle.getAppliedStatValue());
	battle.battleStatCheck();
	
	battle.getTargetWinNumber();
	
	battleSuccessChance.setText(chanceConversion.successChanceWords[battle.getSuccessChance()]);
	battleHarmChance.setText("TBD");
	
	Engage.setText("Engage!");
	Flee.setText("Leave");
	
	battle.getVictoryBoolean();
	buttonControl();
	
}

public void updateBattleScreen() {
	battleTitle.setText(battle.getBattleTitle());
	
	battleText.setText(battle.getBattleContent());
	
	battleStatName.setText(battle.getBattleStat());
	battleStatValue.setText(""+battle.getBattleStatValue());
	
	
	battleStatApplyName.setText("Apply " + battle.getBattleStat());
	battleStatApplyValue.setText("" + battle.getAppliedStatValue());
	battle.battleStatCheck();
	
	battleSuccessChance.setText(chanceConversion.successChanceWords[battle.getSuccessChance()]);
	battleHarmChance.setText("TBD");
	
	Flee.setText("Leave");
	buttonControl();

	
}

public void addToChances() {
	battle.incrementAppliedStatValue(+1);
	battle.incrementBattleStatValue(-1);
	System.out.println(battle.getTargetWinNumber());
}

public void takeFromChances() {
	battle.incrementAppliedStatValue(-1);
	battle.incrementBattleStatValue(+1);
	System.out.println(battle.getTargetWinNumber());
}

public void closeBattleScreen() {
	Main.battleScreenVisibility(false);
}

/**
 * Method to control the button visibility under certain circumstances
 */
public void buttonControl() {
	
	if (battle.getAppliedStatValue() == 0) {
		decreaseSuccessChance.setVisible(false);
	} else {
		decreaseSuccessChance.setVisible(true);
	}
	
	if (battle.getAppliedStatValue() == 10) {
		increaseSuccessChance.setVisible(false);
	} else {
		increaseSuccessChance.setVisible(true);
	}
	
	if (battle.getTargetWinNumber() == 0) {
		increaseSuccessChance.setVisible(false);
	} else if (battle.getBattleStatValue() == 0) {
		increaseSuccessChance.setVisible(false);
	} else {
		increaseSuccessChance.setVisible(true);
	}
	
	
}

public void appliedStatValueLimiter() {
	
}

public void rollToWin() {
	battle.winChecker();
	System.out.println("The targer win number is " + battle.getTargetWinNumber());
	System.out.println("The player rolled a " + battle.getBattleRoll());
	System.out.println("Victory Boolean is currently: " + battle.getVictoryBoolean());
	System.out.println("");
	battle.setAppliedStatValue(0);

}

public void setMain (Main main) {
	this.main = main;
}






























}
