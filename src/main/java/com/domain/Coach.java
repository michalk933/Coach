package com.domain;

import java.lang.annotation.Inherited;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

@Entity
public class Coach {
	
	@Id
	private long id;
	@NotNull
	@Size(min=1,max=50)
	private String firstName;
	@Size(min=6)
	private String password;
	@Size(min=6)
	private String login;
	@NotNull
	@Size(min=1,max=50)
	private String lastName;
	@NotNull
	@Size(min=1,max=50)
	private String cuntry;
	@NotNull
	@Size(min=1,max=50)
	private String city;
	private String zipCode;
	@NotNull
	@Size(min=9,max=20)
	private String mob;
	@NotNull
	private BigDecimal price;
	private Date addDate;
	
	@OneToMany
	private List<Comment> coment;

	
	
	public List<Comment> getComent() {
		return coment;
	}
	public void setComent(List<Comment> coment) {
		this.coment = coment;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCuntry() {
		return cuntry;
	}
	public void setCuntry(String cuntry) {
		this.cuntry = cuntry;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Coach [firstName=" + firstName + ", lastName=" + lastName + ", cuntry=" + cuntry
				+ ", city=" + city + ", zipCode=" + zipCode + ", mob=" + mob + ", price=" + price + "]";
	}
	
	
	
	
	

}
