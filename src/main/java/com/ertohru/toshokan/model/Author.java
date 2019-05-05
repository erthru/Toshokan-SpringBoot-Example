package com.ertohru.toshokan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private long authorId;
	
	@Column(name = "author_full_name")
	private String authorFullName;
	
	@Column(name = "author_email")
	private String authorEmail;
	
	public Author() {
		
	}

	public Author(long authorId, String authorFullName, String authorEmail) {
		super();
		this.authorId = authorId;
		this.authorFullName = authorFullName;
		this.authorEmail = authorEmail;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorFullName() {
		return authorFullName;
	}

	public void setAuthorFullName(String authorFullName) {
		this.authorFullName = authorFullName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	
	
	
}
