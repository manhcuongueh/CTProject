package com.ctproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product")
public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
	
	@Column(name = "NAME", nullable = false)
    private String name;
	
	@Column(name="PRICE", nullable = false)
    private double price;
	
	@Size(min=3, max=50)
	@Lob
    @Column(name = "SCR", length = Integer.MAX_VALUE, nullable = true)
    private String scr;

    // For sort.
	@Size(min=3, max=50)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
    private Date createDate;
	
	@Size(min=3, max=50)
	@Column(name = "INFO", nullable = false)
    private String info;
	
	@Size(min=3, max=50)
	@Column(name = "CATEGORY", nullable = false)
    private String category;

    public Product() {
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getScr() {
        return scr;
    }

    public void setScr(String scr) {
        this.scr =scr;
    }


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
    

}