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
  title = 'Investment-project';
  currentInvestment: Investment;
  investmentsArray: Investment[] = [];
  stringJsonToUpload = '';
  loadingMessage = 'No process done yet';

  constructor(
    private initializeObjectsService: InitializeObjectsService,
    private investmentService: InvestmentRestApisService
    ) { }

  ngOnInit() {
    this.currentInvestment = this.initializeObjectsService.getEmptyInvestment();
  }

  public getInvestmentById(id: string) {
    this.investmentService.getById(id).subscribe(
      (response: Investment) => this.setCurrentInvestment(response));
  }

  public getAllInvestments() {
    this.investmentService.getAll().subscribe(
      (response: Investment[]) => this.investmentsArray = response);
  }

  public saveAllInvestments() {
    this.investmentService.saveAll(this.stringJsonToUpload).subscribe(
      (responseMessage: ResponseMessage) => this.loadingMessage = responseMessage.content);
  }

  private setCurrentInvestment(newInvestment: Investment) {
    this.currentInvestment = newInvestment;
  }

  onFileChange(event) {
    const file = event.target.files[0];
    let reader = new FileReader();

    // The below processings will be done when there is a load event, like "readAsText"
    reader.onload = (e) => {
      const target = e.target as FileReader;
      const text = target.result as string;
      this.stringJsonToUpload = text;
  };
    
    // Fills the FileReader with the file data; triggers a load event,
    // hence why it is written after the "reader.onLoad" above
    reader.readAsText(file);
  }















}
