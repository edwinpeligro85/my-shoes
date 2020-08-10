package com.myshoes.ecommerce.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Categorie implements Serializable {

	@Id
	@Column(name="id_categorie")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="categorie")
	private Set<Product> products;
	
	public Categorie(String displayName, String description) {
		super();
		this.displayName = displayName;
		this.description = description;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
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
}
