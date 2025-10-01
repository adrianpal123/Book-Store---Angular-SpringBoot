package com.adrian.bookstore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String author;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String isbn;

    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Min(0)
    @Column(nullable = false)
    private Integer stock;

    // Constructors, getters, setters

    public Book() {}

    public Book(String title, String author, String isbn, BigDecimal price, Integer stock) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
    }

    public record BookRequest(
            @NotBlank String title,
            @NotBlank String author,
            @NotBlank String isbn,
            @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,
            @Min(0) Integer stock
    ) {}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public record BookResponse(
            Long id,
            String title,
            String author,
            String isbn,
            BigDecimal price,
            Integer stock
    ) {
        public static BookResponse from(Book b) {
            return new BookResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPrice(), b.getStock());
        }
    }
}