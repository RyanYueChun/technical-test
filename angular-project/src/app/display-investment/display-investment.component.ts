import { Component, OnInit, Input } from '@angular/core';
import { Investment } from '../models/Investment';
import { InitializeObjectsService } from '../services/initialize-objects.service';
import { InvestmentRestApisService } from '../services/investment-rest-apis.service';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-display-investment',
  templateUrl: './display-investment.component.html',
  styleUrls: ['./display-investment.component.css']
})
export class DisplayInvestmentComponent implements OnInit {
  title = 'Investment details';
  public selectedInvestment: Investment;
  public selectedId = '';

  constructor(
    private initializeObjectsService: InitializeObjectsService,
    private investmentService: InvestmentRestApisService,
    private route: ActivatedRoute,
    private location: Location
    ) { }

  ngOnInit() {
    this.selectedId = this.route.snapshot.paramMap.get('id');
    this.selectedInvestment = this.initializeObjectsService.getEmptyInvestment();
    if (this.selectedId.length > 0) {
      this.getInvestmentById();
    }
  }

  public getInvestmentById() {
    this.investmentService.getById(this.selectedId).subscribe(
      (response: Investment) => this.selectedInvestment = response);
  }

  goBack(): void {
    this.location.back();
  }

}
