import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { BookService }  from '../../services/book.services';
import { CommonModule } from '@angular/common'

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css'],
  imports: [CommonModule]
})
export class BooksComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.bookService.getBooks().subscribe((data: Book[]) => {
      console.log('Books from backend:', data); // 👈 check browser console
      this.books = data;
    });
  }
}