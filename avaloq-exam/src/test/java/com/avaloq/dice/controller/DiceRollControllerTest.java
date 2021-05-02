package com.avaloq.dice.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.avaloq.dice.model.DiceResponse;
import com.avaloq.dice.service.DiceRollService;

public class DiceRollControllerTest {

	@Mock
	DiceRollService diceRollService;
	@Mock
	DiceResponse response;
	@InjectMocks
	DiceRollController diceRollController;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(diceRollService.rollDice(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(response);
	}

	@Test
	public void rollDiceTest() {

		Mockito.when(diceRollService.populateTotalSimulations(response)).thenReturn(response);
		Assert.assertNotNull(diceRollController.rollDice(1, 4, 3));
	}
	
	@Test
	public void rollDice100Test() {
		Assert.assertNotNull(diceRollController.rollDice100());
	}

}
