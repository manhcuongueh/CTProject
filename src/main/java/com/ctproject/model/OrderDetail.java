package com.ctproject.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Details")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oderId;

	@Column(name = "ID", nullable = false)
    private String id;
	
	@Column(name = "QUANTITY", nullable = false)
    private int quantity;

	@Column(name = "AMOUNT", nullable = false)
    private double amount;
	
	@Column(name = "PRICE", nullable = false)
    private double price;
	
	@Column(name = "Name", nullable = false)
    private String  name;
	
	@Column(name = "CODE", nullable = false)
    private String  code;

	
	public int getOderId() {
		return oderId;
	}

	public void setOderId(int oderId) {
		this.oderId = oderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}