package com.avaloq.dice.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.avaloq.dice.model.DiceEntity;

public class DiceRollRepositoryTest {
	
	@Mock
	EntityManager entityManager;

	@InjectMocks
	DiceRollRepositoryImpl diceRollRepository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveDiceRollDataTest() {
		DiceEntity mock = Mockito.mock(DiceEntity.class);
		Mockito.doNothing().when(entityManager).persist(Mockito.any());
		Mockito.doNothing().when(entityManager).flush();
		Assert.assertNotNull(diceRollRepository.saveDiceRollData(mock));
	}
	
	@Test
	public void getTotalRollsTest() {
		Query query = Mockito.mock(Query.class);
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.any())).thenReturn(query);
		Mockito.when(query.getSingleResult()).thenReturn(10l);
		Assert.assertNotNull(diceRollRepository.getTotalRolls(4, 4));
	}
	
	@Test
	public void getTotalOccurrenceTest() {
		Query query = Mockito.mock(Query.class);
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.setParameter(Mockito.anyString(), Mockito.any())).thenReturn(query);
		Mockito.when(query.getSingleResult()).thenReturn(10l);
		Assert.assertNotNull(diceRollRepository.getTotalOccurrence(4, 4, 4));
	}

}
