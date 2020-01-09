import { Component, OnInit, Input } from '@angular/core';
import { Investment } from '../models/Investment';
import { InitializeObjectsService } from '../services/initialize-objects.service';

@Component({
  selector: 'app-display-investment',
  templateUrl: './display-investment.component.html',
  styleUrls: ['./display-investment.component.css']
})
export class DisplayInvestmentComponent implements OnInit {

  @Input() public selectedInvestment: Investment;

  constructor(private initializeObjectsService: InitializeObjectsService) { }

  ngOnInit() {
    this.selectedInvestment = this.initializeObjectsService.getEmptyInvestment();
  }

}
