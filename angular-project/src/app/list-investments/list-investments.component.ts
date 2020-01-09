import { Component, OnInit, Input } from '@angular/core';
import { Investment } from '../models/Investment';

@Component({
  selector: 'app-list-investments',
  templateUrl: './list-investments.component.html',
  styleUrls: ['./list-investments.component.css']
})
export class ListInvestmentsComponent implements OnInit {

  @Input() public investmentsToList: Investment[] = [];

  constructor() { }

  ngOnInit() {
  }

}
