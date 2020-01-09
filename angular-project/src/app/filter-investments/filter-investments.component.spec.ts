import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterInvestmentsComponent } from './filter-investments.component';

describe('FilterInvestmentsComponent', () => {
  let component: FilterInvestmentsComponent;
  let fixture: ComponentFixture<FilterInvestmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilterInvestmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterInvestmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
