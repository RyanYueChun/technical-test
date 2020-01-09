import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListInvestmentsComponent } from './list-investments.component';

describe('ListInvestmentsComponent', () => {
  let component: ListInvestmentsComponent;
  let fixture: ComponentFixture<ListInvestmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListInvestmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListInvestmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
