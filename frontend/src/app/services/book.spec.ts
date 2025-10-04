import { TestBed } from '@angular/core/testing';

import { Book } from '../models/book';

describe('Book', () => {
  let service: Book;

  beforeEach(() => {
    service = {} as Book;
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
