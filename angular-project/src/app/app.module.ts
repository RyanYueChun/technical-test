import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DisplayInvestmentComponent } from './display-investment/display-investment.component';
import { ListInvestmentsComponent } from './list-investments/list-investments.component';
import { FilterInvestmentsComponent } from './filter-investments/filter-investments.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    DisplayInvestmentComponent,
    ListInvestmentsComponent,
    FilterInvestmentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // import HttpClientModule after BrowserModule.
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
