package com.myshoes.ecommerce.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable {

	@Id
	@Column(name="id_product")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduct;
	
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="price")
	private double price;
	
	@Column(name="last_price")
	private double lastPrice;
	
	@Column(name="stock")
	private int stock;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_product")
	private Set<Favorite> favorites;
	
	@OneToMany
	@JoinColumn(name="id_product")
	private Set<Detail> detail;

	public Product(Categorie categorie, String displayName, String description, String brand, double price,
			double lastPrice, int stock) {
		super();
		this.categorie = categorie;
		this.displayName = displayName;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.lastPrice = lastPrice;
		this.stock = stock;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
