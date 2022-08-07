package com.smileetpay.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADDRESS")
public class Address  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID")
	@JsonIgnore
	private int id;

	@Column(name = "NUMBER")
	private int number;

	@Column(name = "STREET")
	private String street;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	 //@ManyToOne @JoinColumn(name="marchant_id", nullable=false)
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="MARCHANT_ID")
	    private Marchant marchant;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Marchant getMarchant() {
		return marchant;
	}

	public void setMarchant(Marchant marchant) {
		this.marchant = marchant;
	}

	public Address(int id, int number, String street, String zipCode, Marchant marchant) {
		super();
		this.id = id;
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.marchant = marchant;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", zipCode=" + zipCode
				+ ", marchant=" + marchant + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, marchant, number, street, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return id == other.id && Objects.equals(marchant, other.marchant) && number == other.number
				&& Objects.equals(street, other.street) && Objects.equals(zipCode, other.zipCode);
	}





}
