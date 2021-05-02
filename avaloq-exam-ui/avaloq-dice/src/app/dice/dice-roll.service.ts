import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Dice } from './dice.model';

@Injectable({
  providedIn: 'root'
})
export class DiceRollService {

  constructor(private http: HttpClient) { }

  rollDice(dice: number, side: number, roll: number){
    return this.http.get<Dice>(`http://localhost:8080/dice?numOfDice=${dice}&numOfSides=${side}&totalRolls=${roll}`);
  };

}
