package com.ctproject.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

	@Column(name = "ORDER_DATE")
    private String order_Date;
	
	@Column(name = "ORDERNUMBER")
    private int orderNumber;

	@Column(name = "AMOUNT", nullable = false)
    private double amount;
	
	@Column(name = "ACCID", nullable = false)
    private double accId;
	
     
	
    @Id
    @Column(name = "ID", length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 


	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getAccId() {
		return accId;
	}

	public void setAccId(double accId) {
		this.accId = accId;
	}

	@Column(name = "Order_Date", nullable = false)
    public String getOrderDate() {
        return order_Date;
    }

    public void setOrderDate(String string) {
        this.order_Date = string;
    }

    @Column(name = "Amount", nullable = false)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    }
   
