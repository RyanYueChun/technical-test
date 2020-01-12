import { Component, OnInit } from '@angular/core';
import { Investment } from './models/Investment';
import { InitializeObjectsService } from './services/initialize-objects.service';
import { InvestmentRestApisService } from './services/investment-rest-apis.service';
import { ResponseMessage } from './models/ResponseMessage';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  loadingMessage = 'No process done yet';

  constructor(
    private investmentService: InvestmentRestApisService
    ) { }

  ngOnInit() { }

  public deleteInvestmentById(id: string) {
    this.investmentService.deleteById(id).subscribe(
      (response: ResponseMessage) => this.loadingMessage = response.content);
  }

}
