import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DisplayInvestmentComponent } from './display-investment/display-investment.component';
import { ListInvestmentsComponent } from './list-investments/list-investments.component';
import { ImportInvestmentsComponent } from './import-investments/import-investments.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';


const routes: Routes = [
  { path: '', component: WelcomePageComponent },
  { path: 'investment-detail/:id', component: DisplayInvestmentComponent },
  { path: 'investment-list', component: ListInvestmentsComponent },
  { path: 'investment-import', component: ImportInvestmentsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
