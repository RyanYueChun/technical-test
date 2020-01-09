import { TestBed } from '@angular/core/testing';

import { InitializeObjectsService } from './initialize-objects.service';

describe('InitializeObjectsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InitializeObjectsService = TestBed.get(InitializeObjectsService);
    expect(service).toBeTruthy();
  });
});
