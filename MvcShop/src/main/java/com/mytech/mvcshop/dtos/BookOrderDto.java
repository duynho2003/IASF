package com.mytech.mvcshop.dtos;

public class BookOrderDto {

	private long userId;
	private long[] selectedBooks;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long[] getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(long[] selectedBooks) {
		this.selectedBooks = selectedBooks;
	}

}
