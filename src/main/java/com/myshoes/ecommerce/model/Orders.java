package com.myshoes.ecommerce.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

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
@Table(name="orders")
public class Orders implements Serializable {

	@Id
	@Column(name="id_order")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrder;
	
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_customer")
	private Customer customer;
	
	/*@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_payment")
	private Payment payment;*/
	
	@Column(name="date_order")
	private Date dateOrder;
	
	@Column(name="date_sales")
	private Date dateSales;
	
	@Column(name="code_descount")
	private String codeDescount;
	
	@Column(name="amount_initial")
	private double amountInitial;
	
	@Column(name="amount_descount")
	private double amountDescount;
	
	@Column(name="amount_total")
	private double amountTotal;
	
	@OneToMany
	@JoinColumn(name="id_order")
	private Set<Detail> detail;

	public Orders(Customer customer, Payment payment, Date dateOrder, Date dateSales,
			String codeDescount, double amountInitial, double amountDescount, double amountTotal) {
		super();
		this.customer = customer;
		// this.payment = payment;
		this.dateOrder = dateOrder;
		this.dateSales = dateSales;
		this.codeDescount = codeDescount;
		this.amountInitial = amountInitial;
		this.amountDescount = amountDescount;
		this.amountTotal = amountTotal;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/*public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}*/

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getDateSales() {
		return dateSales;
	}

	public void setDateSales(Date dateSales) {
		this.dateSales = dateSales;
	}

	public String getCodeDescount() {
		return codeDescount;
	}

	public void setCodeDescount(String codeDescount) {
		this.codeDescount = codeDescount;
	}

	public double getAmountInitial() {
		return amountInitial;
	}

	public void setAmountInitial(double amountInitial) {
		this.amountInitial = amountInitial;
	}

	public double getAmountDescount() {
		return amountDescount;
	}

	public void setAmountDescount(double amountDescount) {
		this.amountDescount = amountDescount;
	}

	public double getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(double amountTotal) {
		this.amountTotal = amountTotal;
	}
}
