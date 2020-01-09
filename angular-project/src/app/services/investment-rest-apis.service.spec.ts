import { TestBed } from '@angular/core/testing';

import { InvestmentRestApisService } from './investment-rest-apis.service';

describe('InvestmentRestApisService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InvestmentRestApisService = TestBed.get(InvestmentRestApisService);
    expect(service).toBeTruthy();
  });
});
