import { Component, OnInit, Input } from '@angular/core';
import { Investment } from '../models/Investment';
import { InvestmentRestApisService } from '../services/investment-rest-apis.service';

@Component({
  selector: 'app-list-investments',
  templateUrl: './list-investments.component.html',
  styleUrls: ['./list-investments.component.css']
})
export class ListInvestmentsComponent implements OnInit {
  public investmentsArray: Investment[] = [];
  public investmentCity = '';
  public investmentAdvancementState = '';

  constructor(
    private investmentService: InvestmentRestApisService
    ) { }

  ngOnInit() {
  }

  public getInvestmentsByCity() {
    this.investmentService.getByCity(this.investmentCity).subscribe(
      (response: Investment[]) => this.investmentsArray = response);
  }

  public getInvestmentsByAdvancementState() {
    this.investmentService.getByAdvancementState(this.investmentAdvancementState).subscribe(
      (response: Investment[]) => this.investmentsArray = response);
  }

  public getInvestmentsByCityAndAdvancementState() {
    this.investmentService.getByCityAndAdvancementState(this.investmentCity, this.investmentAdvancementState).subscribe(
      (response: Investment[]) => this.investmentsArray = response);
  }

  public getAllInvestments() {
    this.investmentService.getAll().subscribe(
      (response: Investment[]) => this.investmentsArray = response);
  }

}
