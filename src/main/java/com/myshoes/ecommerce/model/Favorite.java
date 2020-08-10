package com.myshoes.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favorite")
public class Favorite implements Serializable {

	@Id
	@Column(name="id_favorite")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFavorite;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_customer")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_product")
	private Product product;
	
	@Column(name="quantity")
	private int quantity;

	public Favorite(Customer customer, Product product, int quantity) {
		super();
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdFavorite() {
		return idFavorite;
	}

	public void setIdFavorite(Long idFavorite) {
		this.idFavorite = idFavorite;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
