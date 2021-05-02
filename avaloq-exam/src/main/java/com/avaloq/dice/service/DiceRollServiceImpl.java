package com.avaloq.dice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaloq.dice.model.DiceEntity;
import com.avaloq.dice.model.DiceResponse;
import com.avaloq.dice.model.DiceRollEntity;
import com.avaloq.dice.model.DiceRollWrapper;
import com.avaloq.dice.repository.DiceRollRepository;
import com.avaloq.dice.util.DiceRoller;

@Service
public class DiceRollServiceImpl implements DiceRollService {

	private final Logger LOGGER = LoggerFactory.getLogger(DiceRollServiceImpl.class);

	@Autowired
	private DiceRoller diceRoller;

	@Autowired
	private DiceRollRepository diceRollRepository;

	@Override
	@Transactional
	public DiceResponse rollDice(Integer numOfDice, Integer numOfSides, Integer totalRolls) {

		DiceEntity dice = executeRollDice(numOfDice, numOfSides, totalRolls);
		
		//Populating Response Wrapper
		DiceResponse response = new DiceResponse();
		response.setDice(dice.getDice());
		response.setRoll(dice.getRoll());
		response.setSide(dice.getSide());
		
		List<DiceRollWrapper> rollWrapper = new ArrayList<DiceRollWrapper>();
		
		Map<Integer, Long> counters = dice.getDiceRoll().stream()
			     .collect(Collectors.groupingBy(p -> p.getRollSum(), Collectors.counting()));
		
		counters.forEach((k, v) -> {
			DiceRollWrapper roll = new DiceRollWrapper();
			
			roll.setRollSum(k);
			roll.setNumberOfTimes(v);
			roll.setRollPercentage((v * 100.0f) / dice.getRoll());
			
			rollWrapper.add(roll);
		});
		
		response.setDiceRoll(rollWrapper);
		
		return response;
	}

	private DiceEntity executeRollDice(Integer numOfDice, Integer numOfSides, Integer totalRolls) {

		DiceEntity dice = new DiceEntity();
		dice.setDice(numOfDice);
		dice.setRoll(totalRolls);
		dice.setSide(numOfSides);

		List<DiceRollEntity> diceRollList = new ArrayList<DiceRollEntity>();

		Integer rollCntr = 0;
		while (rollCntr < totalRolls) {
			rollCntr++;

			DiceRollEntity diceRoll = new DiceRollEntity();

			Integer diceResultCntr = 0;
			Integer diceRollSum = 0;
			while (diceResultCntr < numOfDice) {
				LOGGER.info("ROLLING DICE {}", diceResultCntr);

				diceRollSum += diceRoller.executeRoll(numOfSides);
				diceResultCntr++;
			}
			diceRoll.setRollSum(diceRollSum);
			diceRollList.add(diceRoll);
		}
		dice.setDiceRoll(diceRollList);

		LOGGER.info("SAVING TO H2 DB..");
		
		diceRollRepository.saveDiceRollData(dice);
		
		LOGGER.info("SAVING TO H2 DB SUCCESS..");

		return dice;

	}

	@Override
	public DiceResponse populateTotalSimulations(DiceResponse diceResponse) {

		Long totalRolls = diceRollRepository.getTotalRolls(diceResponse.getSide(), diceResponse.getDice());
		
		diceResponse.setTotalRollSimulations(totalRolls);
		
		diceResponse.getDiceRoll().stream().forEach(dr -> {
			Long totalOccurrence = diceRollRepository.getTotalOccurrence(diceResponse.getSide(), diceResponse.getDice(), dr.getRollSum());
			
			dr.setTotalNumberOfOccurence(totalOccurrence);
			dr.setTotalRollPercentage((totalOccurrence * 100.0f) / totalRolls);
		});
		
		return diceResponse;
	}

}
