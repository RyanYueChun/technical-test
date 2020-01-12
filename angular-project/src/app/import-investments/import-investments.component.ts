import { Component, OnInit } from '@angular/core';
import { InvestmentRestApisService } from '../services/investment-rest-apis.service';
import { ResponseMessage } from '../models/ResponseMessage';

@Component({
  selector: 'app-import-investments',
  templateUrl: './import-investments.component.html',
  styleUrls: ['./import-investments.component.css']
})
export class ImportInvestmentsComponent implements OnInit {
  private stringJsonToUpload = '';
  public loadingMessage = 'No file sent';

  constructor(
    private investmentService: InvestmentRestApisService
    ) { }

  ngOnInit( ) {
  }

  public saveAllInvestments() {
    this.investmentService.saveAll(this.stringJsonToUpload).subscribe(
      (responseMessage: ResponseMessage) => this.loadingMessage = responseMessage.content);
  }

  public onFileChange(event) {
    const file = event.target.files[0];
    const reader = new FileReader();

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
