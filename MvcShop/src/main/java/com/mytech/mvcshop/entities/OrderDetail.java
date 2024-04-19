package com.mytech.mvcshop.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderDetail extends AbstractEntity {

	private static final long serialVersionUID = -1861975268867148809L;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	private Double price;
	private int quantity;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
