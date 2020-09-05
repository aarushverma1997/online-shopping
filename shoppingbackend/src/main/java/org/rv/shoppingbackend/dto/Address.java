package org.rv.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="address_line_one")
	@NotBlank(message = "enter the address 1")
	private String addressLineOne;
	
	@Column(name="address_line_two")
	@NotBlank(message = "enter the address 2")
	private String addressLineTwo;
	@NotBlank(message = "enter the city")
	private String city;
	@NotBlank(message = "enter the state")
	private String state;
	@NotBlank(message = "enter the country")
	private String country;
	@Column(name="postal_code")
	@NotBlank(message = "enter the Postal Code")
	private String  postalCode;
	@Column(name="is_billing")
	private boolean isBilling;
	@Column(name="is_shipping")
	private boolean isShipping;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isBilling() {
		return isBilling;
	}

	public void setBilling(boolean isBilling) {
		this.isBilling = isBilling;
	}

	public boolean isShipping() {
		return isShipping;
	}

	public void setShipping(boolean isShipping) {
		this.isShipping = isShipping;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", isBilling=" + isBilling + ", isShipping=" + isShipping + ", userId=" + userId + "]";
	}
	
	

}
