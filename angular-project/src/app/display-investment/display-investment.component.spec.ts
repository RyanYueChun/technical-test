import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayInvestmentComponent } from './display-investment.component';

describe('DisplayInvestmentComponent', () => {
  let component: DisplayInvestmentComponent;
  let fixture: ComponentFixture<DisplayInvestmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayInvestmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayInvestmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
