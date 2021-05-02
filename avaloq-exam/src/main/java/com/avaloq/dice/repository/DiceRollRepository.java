package com.avaloq.dice.repository;

import com.avaloq.dice.model.DiceEntity;

public interface DiceRollRepository {
	
	DiceEntity saveDiceRollData(DiceEntity diceEntity);
	 
	Long getTotalRolls(Integer side, Integer dice);

	Long getTotalOccurrence(Integer side, Integer dice, Integer rollSum);
}
