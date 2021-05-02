package com.avaloq.dice.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.avaloq.dice.model.DiceEntity;
import com.avaloq.dice.model.DiceResponse;
import com.avaloq.dice.model.DiceRollWrapper;
import com.avaloq.dice.repository.DiceRollRepository;
import com.avaloq.dice.util.DiceRoller;

public class DiceRollServiceTest {

	@Mock
	DiceRoller diceRoller;
	@Mock
	DiceRollRepository diceRollRepository;
	
	@InjectMocks
	DiceRollServiceImpl diceRollService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void rollDiceTest() {
		DiceEntity mock = Mockito.mock(DiceEntity.class);
		Mockito.when(diceRoller.executeRoll(Mockito.anyInt())).thenReturn(10);
		Mockito.when(diceRollRepository.saveDiceRollData(Mockito.any())).thenReturn(mock);
		Assert.assertNotNull(diceRollService.rollDice(1,4,3));
	}
	
	@Test
	public void populateTotalSimulationsTest() {
		
		DiceResponse diceResp = new DiceResponse();
		List<DiceRollWrapper> rollWrapper = new ArrayList<DiceRollWrapper>();
		rollWrapper.add(new DiceRollWrapper());
		diceResp.setDiceRoll(rollWrapper);
		
		Mockito.when(diceRollRepository.getTotalRolls(Mockito.anyInt(), Mockito.anyInt())).thenReturn(10l);
		Mockito.when(diceRollRepository.getTotalOccurrence(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(10l);
		Assert.assertNotNull(diceRollService.populateTotalSimulations(diceResp));
	}

}
