package com.avaloq.dice.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_DICE")
public class DiceEntity  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8200423323822716455L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "dice_id")
	@OrderBy("id")
	private List<DiceRollEntity> diceRoll;
	
	@Column(name = "side")
	private Integer side;
	
	@Column(name = "dice")
	private Integer dice;
	
	@Column(name = "roll")
	private Integer roll;

	public List<DiceRollEntity> getDiceRoll() {
		return diceRoll;
	}

	public void setDiceRoll(List<DiceRollEntity> diceRoll) {
		this.diceRoll = diceRoll;
	}

	public Integer getSide() {
		return side;
	}

	public void setSide(Integer side) {
		this.side = side;
	}

	public Integer getDice() {
		return dice;
	}

	public void setDice(Integer dice) {
		this.dice = dice;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

}
