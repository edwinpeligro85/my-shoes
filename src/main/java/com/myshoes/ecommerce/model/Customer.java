package com.myshoes.ecommerce.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

	@Id
	@Column(name="id_customer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCustomer;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="profile_img")
	private String profileImg;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_customer")
	private Set<Favorite> favorites;
	
	@OneToMany(mappedBy="customer")
	private Set<Orders> orders;
	
	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
//		String hash = BCrypt.hashpw(password);
		this.password = password;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
}
