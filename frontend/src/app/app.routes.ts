import { Routes } from '@angular/router';
import { BooksComponent } from './pages/books/books.component';

export const routes: Routes = [
  { path: '', component: BooksComponent },   // 👈 root shows books
  // optional: keep /books as an alias
  { path: 'books', component: BooksComponent }
];