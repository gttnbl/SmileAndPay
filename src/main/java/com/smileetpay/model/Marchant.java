package com.smileetpay.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "MARCHANT")
//@XmlAccessorType(XmlAccessType.NONE)
public class Marchant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID")
	private int marchant_id;

	@Column(name = "NAME")
	// @XmlElement
	private String name;

	@Column(name = "LASTNAME")
	// @XmlElement
	private String lastname;

	@Column(name = "BIRTHDATE")
	// @XmlElement
	private Date birthdate;

	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	// @XmlElement
	private Date creationDate = new Date();

	@OneToMany(mappedBy = "marchant", cascade = { CascadeType.MERGE })
	private Set<MarchantProduct> marchantProducts = new HashSet<MarchantProduct>();

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Address> address;

	public Marchant() {
		super();
	}

	public Marchant(int marchant_id, String name, String lastname, Date birthdate,
			Set<MarchantProduct> marchantProducts, List<Address> address) {
		super();
		this.marchant_id = marchant_id;
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.marchantProducts = marchantProducts;
		this.address = address;
		this.creationDate = new Date();
	}

	public int getMarchant_id() {
		return marchant_id;
	}

	public void setMarchant_id(int marchant_id) {
		this.marchant_id = marchant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@JsonIgnore
	public Set<MarchantProduct> getMarchantProducts() {
		return marchantProducts;
	}

	@JsonProperty("marchantProducts")
	public void setMarchantProducts(Set<MarchantProduct> marchantProducts) {
		this.marchantProducts = marchantProducts;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Marchant [marchant_id=" + marchant_id + ", name=" + name + ", lastname=" + lastname + ", birthdate="
				+ birthdate + ", marchantProducts=" + marchantProducts + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birthdate, lastname, marchantProducts, marchant_id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marchant other = (Marchant) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthdate, other.birthdate)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(marchantProducts, other.marchantProducts)
				&& marchant_id == other.marchant_id && Objects.equals(name, other.name);
	}

}
