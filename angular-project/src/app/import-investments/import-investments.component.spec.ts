import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportInvestmentsComponent } from './import-investments.component';

describe('ImportInvestmentsComponent', () => {
  let component: ImportInvestmentsComponent;
  let fixture: ComponentFixture<ImportInvestmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportInvestmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportInvestmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
