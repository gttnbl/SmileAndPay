package com.smileetpay.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "marchant_product")
public class MarchantProduct {

	private Long id;
	private Marchant marchant;
	private Product product;
	private Date registeredDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marchant_product_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "MARCHANT_ID")
	public Marchant getMarchant() {
		return marchant;
	}

	public void setMarchant(Marchant marchant) {
		this.marchant = marchant;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "PRODUCT_ID")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "REGISTERED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

}
