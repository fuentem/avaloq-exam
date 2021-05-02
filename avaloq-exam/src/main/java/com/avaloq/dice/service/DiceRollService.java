package com.avaloq.dice.service;

import com.avaloq.dice.model.DiceResponse;

public interface DiceRollService {
	
	DiceResponse rollDice(Integer numOfDice, Integer numOfSides, Integer totalRolls);
	
	DiceResponse populateTotalSimulations(DiceResponse diceResponse);
	
}
