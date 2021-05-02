package com.avaloq.dice.model;

import java.io.Serializable;

public class DiceRollWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -18289533542319168L;

	private Integer rollSum;

	private Long numberOfTimes;
	private Float rollPercentage;

	private Long totalNumberOfOccurence;
	private Float totalRollPercentage;

	public Integer getRollSum() {
		return rollSum;
	}

	public void setRollSum(Integer rollSum) {
		this.rollSum = rollSum;
	}

	public Long getNumberOfTimes() {
		return numberOfTimes;
	}

	public void setNumberOfTimes(Long numberOfTimes) {
		this.numberOfTimes = numberOfTimes;
	}

	public Float getRollPercentage() {
		return rollPercentage;
	}

	public void setRollPercentage(Float rollPercentage) {
		this.rollPercentage = rollPercentage;
	}

	public Long getTotalNumberOfOccurence() {
		return totalNumberOfOccurence;
	}

	public void setTotalNumberOfOccurence(Long totalNumberOfOccurence) {
		this.totalNumberOfOccurence = totalNumberOfOccurence;
	}

	public Float getTotalRollPercentage() {
		return totalRollPercentage;
	}

	public void setTotalRollPercentage(Float totalRollPercentage) {
		this.totalRollPercentage = totalRollPercentage;
	}

}
