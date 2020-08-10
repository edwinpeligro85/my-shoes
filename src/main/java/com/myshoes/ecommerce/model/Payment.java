package com.myshoes.ecommerce.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment implements Serializable {

	@Id
	@Column(name="id_payment")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPayment;
	
	@Column(name="method_payment")
	private String methodPayment;
	
	@Column(name="reference")
	private String reference;
	
	@Column(name="date_payment")
	private Date datePayment;

	public Payment(String methodPayment, String reference, Date datePayment) {
		super();
		this.methodPayment = methodPayment;
		this.reference = reference;
		this.datePayment = datePayment;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(Long idPayment) {
		this.idPayment = idPayment;
	}

	public String getMethodPayment() {
		return methodPayment;
	}

	public void setMethodPayment(String methodPayment) {
		this.methodPayment = methodPayment;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}
}
