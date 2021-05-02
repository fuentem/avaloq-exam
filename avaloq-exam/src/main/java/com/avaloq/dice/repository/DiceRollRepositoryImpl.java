package com.avaloq.dice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.avaloq.dice.model.DiceEntity;

@Repository
public class DiceRollRepositoryImpl implements DiceRollRepository {


	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DiceEntity saveDiceRollData(DiceEntity diceEntity) {
		entityManager.persist(diceEntity);
		entityManager.flush();
		return diceEntity;
	}

	@Override
	public Long getTotalRolls(Integer side, Integer dice) {
		Object query = entityManager.createQuery("SELECT SUM(d.roll) FROM DiceEntity d WHERE d.side = :side AND d.dice = :dice")
				.setParameter("side", side)
				.setParameter("dice", dice).getSingleResult();

		return query != null ? Long.parseLong(query.toString()) : 0l;
	}
	
	
	@Override
	public Long getTotalOccurrence(Integer side, Integer dice, Integer rollSum) {
		Object query = entityManager.createQuery("SELECT COUNT(dr) FROM DiceRollEntity dr WHERE dr.rollSum = :rollSum AND dr.dice.side = :side AND dr.dice.dice = :dice")
				.setParameter("rollSum", rollSum)
				.setParameter("side", side)
				.setParameter("dice", dice).getSingleResult();

		return query != null ? Long.parseLong(query.toString()) : 0l;
	}

}
