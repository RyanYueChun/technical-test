import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Investment } from '../models/Investment';
import { ResponseMessage } from '../models/ResponseMessage';

@Injectable({
  providedIn: 'root'
})
export class InvestmentRestApisService {
  private baseInvestmentUrl = 'http://localhost:8080/investments';
  private getAllUrl = '/getAll';
  private saveAllUrl = '/saveAll';
  private getByIdUrl = '/getById/';
  private deleteByIdUrl = '/deleteById/'
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Investment[]> {
    return this.httpClient.get<Investment[]>(`${this.baseInvestmentUrl}${this.getAllUrl}`);
  }

  saveAll(investmentsJson: string): Observable<ResponseMessage> {
    return this.httpClient.post<ResponseMessage>(`${this.baseInvestmentUrl}${this.saveAllUrl}`, investmentsJson, this.httpOptions);
    
  }

  getById(id: string): Observable<Investment> {
    return this.httpClient.get<Investment>(`${this.baseInvestmentUrl}${this.getByIdUrl}${id}`);
  }

  deleteById(id: string): Observable<ResponseMessage> {
    return this.httpClient.delete<ResponseMessage>(`${this.baseInvestmentUrl}${this.getByIdUrl}${id}`);
  }
}
