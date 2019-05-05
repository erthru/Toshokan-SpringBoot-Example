package com.ertohru.toshokan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "book")
public class Book{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private long bookId;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	@Column(name = "book_synopsis")
	private String bookSynopsis;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	@Fetch(FetchMode.JOIN)
	private Author author;

	public Book() {
		
	}
	
	

	public Book(long bookId, String bookTitle, String bookSynopsis, Author author) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookSynopsis = bookSynopsis;
		this.author = author;
	}



	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookSynopsis() {
		return bookSynopsis;
	}

	public void setBookSynopsis(String bookSynopsis) {
		this.bookSynopsis = bookSynopsis;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	

}
