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
	
	private Integer quantity;
	
	private String unitOfMeasurmet;
	
	private Double price;
	
	@JoinColumn(name = "invoice_id")
	@ManyToOne
	private Invoice invoice;
	
	
	
	public double getTotalPrice(){
		return price*quantity;
	}

	
	//--------GetSet----------
	
	
	
	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getUnitOfMeasurmet() {
		return unitOfMeasurmet;
	}

	public Double getPrice() {
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

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setUnitOfMeasurmet(String unitOfMeasurmet) {
		this.unitOfMeasurmet = unitOfMeasurmet;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

		
	
	
}
