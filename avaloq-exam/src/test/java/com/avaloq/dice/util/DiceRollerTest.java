package com.avaloq.dice.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class DiceRollerTest {
	
	@InjectMocks
	DiceRoller diceRoller;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void executeRollTest() {
		Assert.assertNotNull(diceRoller.executeRoll(4));
	}
	
}
