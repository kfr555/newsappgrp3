import { TestBed } from '@angular/core/testing';

import { TopnewsapiService } from './topnewsapi.service';

describe('TopnewsapiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TopnewsapiService = TestBed.get(TopnewsapiService);
    expect(service).toBeTruthy();
  });
});
