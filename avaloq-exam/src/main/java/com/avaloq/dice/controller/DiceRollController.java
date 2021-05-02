package com.avaloq.dice.controller;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avaloq.dice.model.DiceResponse;
import com.avaloq.dice.service.DiceRollService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dice")
@Api(value = "Dice Roll API", produces = "application/json")
@Validated
public class DiceRollController {

	@Autowired
	private DiceRollService diceRollService;


	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Roll Dice", response = Object.class)
	public ResponseEntity<DiceResponse> rollDice(@RequestParam @Min(1) Integer numOfDice, @RequestParam @Min(4) Integer numOfSides, @Min(1) @RequestParam Integer totalRolls) {
		
		DiceResponse rollDice = diceRollService.rollDice(numOfDice, numOfSides, totalRolls);
		DiceResponse rollCompleteResponse = diceRollService.populateTotalSimulations(rollDice);
		
		return new ResponseEntity<>(rollCompleteResponse, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/roll100")
	@ApiOperation(value = "Roll 3 Dice for 100 times", response = Object.class)
	public ResponseEntity<DiceResponse> rollDice100() {
		return new ResponseEntity<>(diceRollService.rollDice(3, 6, 100), HttpStatus.OK);
	}

}
