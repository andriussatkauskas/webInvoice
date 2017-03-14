package com.as.invoice.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dateOfInvoice;
	private Long number;
	private String enterprise;
	private String client;

	@OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Item> items;

	public void addItem(Item item) {

		if (getItems() == null) {
			setItems(new ArrayList<Item>());
		}
		if (!getItems().contains(item)) {
			getItems().add(item);
		}
	}

	public Long getId() {
		return id;
	}

	public Date getDateOfInvoice() {
		return dateOfInvoice;
	}

	public Long getNumber() {
		return number;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public String getClient() {
		return client;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDateOfInvoice(Date dateOfInvoice) {
		this.dateOfInvoice = dateOfInvoice;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
