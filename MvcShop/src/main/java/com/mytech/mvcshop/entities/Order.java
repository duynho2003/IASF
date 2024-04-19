package com.mytech.mvcshop.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order extends AbstractEntity {

	private static final long serialVersionUID = 2879145126325347235L;

	@Column(unique = true)
	private String orderNumber;
	private LocalDate orderDate;
	private Double total;
	
	@OneToOne
    @JoinColumn(name = "shipping_id")
    private OrderShipping orderShipping;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
