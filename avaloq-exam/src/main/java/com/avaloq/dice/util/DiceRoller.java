package com.avaloq.dice.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DiceRoller {

	private Random randomGenerator;

	public DiceRoller() {
		this.randomGenerator = new Random();
	}

	public Integer executeRoll(Integer side) {
		return randomGenerator.nextInt(side) + 1;
	}

}
