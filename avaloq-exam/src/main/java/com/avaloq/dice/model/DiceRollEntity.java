package com.avaloq.dice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_DICE_ROLL_SUM")
public class DiceRollEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1394782692595242561L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "dice_id")
	private DiceEntity dice;

	@Column(name = "ROLL_SUM")
	private Integer rollSum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiceEntity getDice() {
		return dice;
	}

	public void setDice(DiceEntity dice) {
		this.dice = dice;
	}

	public Integer getRollSum() {
		return rollSum;
	}

	public void setRollSum(Integer rollSum) {
		this.rollSum = rollSum;
	}

}
