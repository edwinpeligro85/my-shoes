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
@Table(name="detail")
public class Detail implements Serializable {

	@Id
	@Column(name="id_detail")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetail;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_product")
	private Product product;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_order")
	private Orders order;
	
	@Column(name="quantity")
	private int quantity;

	public Detail(Product product, Orders order, int quantity) {
		super();
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
