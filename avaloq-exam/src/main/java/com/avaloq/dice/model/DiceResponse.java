package com.avaloq.dice.model;

import java.io.Serializable;
import java.util.List;

public class DiceResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3096469874232105980L;
	private List<DiceRollWrapper> diceRoll;
	private Integer side;
	private Integer dice;
	private Integer roll;
	private Long totalRollSimulations;

	public List<DiceRollWrapper> getDiceRoll() {
		return diceRoll;
	}

	public void setDiceRoll(List<DiceRollWrapper> diceRoll) {
		this.diceRoll = diceRoll;
	}

	public Integer getSide() {
		return side;
	}

	public void setSide(Integer side) {
		this.side = side;
	}

	public Integer getDice() {
		return dice;
	}

	public void setDice(Integer dice) {
		this.dice = dice;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public Long getTotalRollSimulations() {
		return totalRollSimulations;
	}

	public void setTotalRollSimulations(Long totalRollSimulations) {
		this.totalRollSimulations = totalRollSimulations;
	}

}
