package com.smileetpay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID")
	private int product_id;

	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate = new Date();

	@Column(name = "LABEL")
	private String label;

	@Column(name = "UNIT_PRICE")
	private long unit_price;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "WEIGHT")
	private long weight;

	@Column(name = "HEIGHT")
	private long height;


	@OneToMany(mappedBy = "product", cascade = { CascadeType.MERGE })
	private Set<MarchantProduct> marchantProducts = new HashSet<MarchantProduct>();

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(long unit_price) {
		this.unit_price = unit_price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public Product() {
		super();
	}
    public void addMarchantProduct(MarchantProduct marchantProduct) {
        this.marchantProducts.add(marchantProduct);
    }
}
