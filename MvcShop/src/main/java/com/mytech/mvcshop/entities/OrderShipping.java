package com.mytech.mvcshop.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderShippings")
public class OrderShipping extends AbstractEntity {

	private static final long serialVersionUID = 867129203469553435L;
	
	private String trackingNumber;
	private String status;
	private LocalDate completedDate;
	
	@OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(LocalDate completedDate) {
		this.completedDate = completedDate;
	}

}
