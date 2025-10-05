package com.adrian.bookstore;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrian.bookstore.Book.BookRequest;
import com.adrian.bookstore.Book.BookResponse;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<BookResponse> list(String q) {
        List<Book> books = (q == null || q.isBlank())
                ? repo.findAll()
                : repo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(q, q);
        return books.stream().map(BookResponse::from).toList();
    }

    public BookResponse get(Long id) {
        Book b = repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return BookResponse.from(b);
    }

    public BookResponse create(BookRequest req) {
        repo.findByIsbn(req.isbn()).ifPresent(b -> {
            throw new DuplicateIsbnException(req.isbn());
        });
        Book b = new Book(req.title(), req.author(), req.isbn(), req.price(), req.stock(), req.imageUrl());
        return BookResponse.from(repo.save(b));
    }

    public BookResponse update(Long id, BookRequest req) {
        Book b = repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if (!b.getIsbn().equals(req.isbn())) {
            repo.findByIsbn(req.isbn()).ifPresent(existing -> {
                throw new DuplicateIsbnException(req.isbn());
            });
        }
        b.setTitle(req.title());
        b.setAuthor(req.author());
        b.setIsbn(req.isbn());
        b.setPrice(req.price());
        b.setStock(req.stock());
        return BookResponse.from(repo.save(b));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new BookNotFoundException(id);
        repo.deleteById(id);
    }
}