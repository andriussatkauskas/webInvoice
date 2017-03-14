package com.as.invoice.entities;

import java.io.Serializable;


import javax.persistence.*;



@Entity
public class Item implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	
	private String itemName;
	
	private int quantity;
	
	private String unitOfMeasurmet;
	
	private double price;
	
	@JoinColumn(name = "invoice_id")
	@ManyToOne(optional = true, cascade = { CascadeType.ALL})
	private Invoice invoice;
	
	public double getTotalPrice(){
		return price*quantity;
	}

	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getUnitOfMeasurmet() {
		return unitOfMeasurmet;
	}

	public double getPrice() {
		return price;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnitOfMeasurmet(String unitOfMeasurmet) {
		this.unitOfMeasurmet = unitOfMeasurmet;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	

	
	
	
}
