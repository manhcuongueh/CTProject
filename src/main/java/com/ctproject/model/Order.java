package com.ctproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Orders")
@JsonIgnoreProperties
public class Order {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERID", length = 50)
    private int orderId;
    
    
	@Column(name = "ORDER_DATE")
    private String order_Date;
	

	@Column(name = "AMOUNT", nullable = false)
    private double amount;
	
	@Column(name = "ACCID", nullable = false)
    private double accId;
	
	@Column(name = "STATUS", nullable = false)
    private String status;
	
	
	@OneToMany(fetch =FetchType.EAGER,mappedBy="order")
	private List<OrderDetail> orderDetail;
	
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int id) {
        this.orderId = id;
   
	}

	public double getAccId() {
		return accId;
	}

	public void setAccId(double accId) {
		this.accId = accId;
	}

    public String getOrderDate() {
        return order_Date;
    }

    public void setOrderDate(String string) {
        this.order_Date = string;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

    }
   
