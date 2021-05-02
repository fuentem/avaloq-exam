import { Component, OnInit } from '@angular/core';
import { DiceRollService } from '../dice-roll.service';
import { Dice } from '../dice.model';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-dice-roll',
  templateUrl: './dice-roll.component.html',
  styleUrls: ['./dice-roll.component.css']
})
export class DiceRollComponent implements OnInit {

  dice: Dice;
  formGroup: FormGroup;


  constructor(private diceRollService: DiceRollService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      dice: 0,
      side: 0,
      roll: 0
    });
  }

  rollDice(){
    console.log(this.formGroup.value)
    this.diceRollService.rollDice(this.formGroup.value.dice, this.formGroup.value.side, this.formGroup.value.roll).subscribe((data: Dice) => {
      this.dice = data;
    });
  }

}
