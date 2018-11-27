package com.naresh.Jersey2.x_BookProvider.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "book_details")
@XmlRootElement(name = "Book")
public class Book {
	@Id
	@Column(name = "book_id")
	private Integer bookId;
	@Column(name = "book_title")
	private String bookTitle;
	@Column(name = "price")
	private Double price;
	@Column(name = "author")
	private String author;

	public Book() {
		super();
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", price=" + price + ", author=" + author + "]";
	}

}
