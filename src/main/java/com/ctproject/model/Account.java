package com.ctproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accId;

	@Column(name = "FIRSTNAME", nullable = false)
	private String firstname;


	@Column(name = "LASTNAME", nullable = false)
	private String lastname;
	
	@NotEmpty
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@NotEmpty
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PHONENUMBER")
	private String phonenumber;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CREDITNUMBER")
	private String creditnumber;

	

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}

	@Override
	public String toString() {
		return "Employee [id=" + accId + ", Firstname=" + firstname + ", Lastname="
				+ lastname + ", Email=" + email + "]";
	}
	
}
	