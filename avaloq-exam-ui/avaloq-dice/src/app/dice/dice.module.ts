import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DiceRollComponent } from './dice-roll/dice-roll.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [DiceRollComponent],
  imports: [
    CommonModule,
    FormsModule, ReactiveFormsModule
  ]
})
export class DiceModule { }
