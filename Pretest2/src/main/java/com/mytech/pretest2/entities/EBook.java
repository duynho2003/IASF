package com.mytech.pretest2.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "eBook")
public class EBook implements Serializable {

	private static final long serialVersionUID = -1980980447745369420L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 200)
	@Size(min = 1, message = "eBook title must at least 1 chars")
	private String title;

	@Column(length = 200)
	@Size(min = 1, message = "eBook author must at least 1 chars")
	private String author;

	@Column(length = 200)
	@Size(min = 1, message = "eBook publisher must at least 1 chars")
	private String publisher;

	@Min(value = 50, message = "Must be equal or greater than 50")
	private int page;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
