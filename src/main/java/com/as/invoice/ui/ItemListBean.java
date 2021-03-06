package com.as.invoice.ui;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.as.invoice.repo.*;



import com.as.invoice.entities.*;

public class ItemListBean {
	static final Logger log = LoggerFactory.getLogger(ItemListBean.class);

	private InvoiceRepo invoiceRepoImpl;
	private ItemRepo itemRepoImpl;

	private InvoiceListBean invoiceListBean;

	private Item newItem;

	public void init() {
		newItem = new Item();
	}

	public String addNew() {

		Invoice invoice=invoiceListBean.getInvoicePageData().getCurrentInvoice();
		newItem.setInvoice(invoice);
		log.info("Adding new item to invoice : {}", invoice);
		log.info("New item info: {}", newItem);
		invoice.addItem(newItem);
		invoiceRepoImpl.save(invoice);
		
		return "itemList";
	}
	
	public List<Item> getItemList() {
		return invoiceListBean.getInvoicePageData().getCurrentInvoice().getItems();
	}
	
	public String deleteSelected(Item item) {
		Invoice invoice=invoiceListBean.getInvoicePageData().getCurrentInvoice();
		invoice.getItems().remove(item);
		itemRepoImpl.delete(item);
		invoiceRepoImpl.save(invoice);		
		
	return "itemList";
}

	
	public double invoiceTotalPrice(){
		double total=0;
		Invoice invoice=invoiceListBean.getInvoicePageData().getCurrentInvoice();
		for(Item i:invoice.getItems()){
			total+=i.getTotalPrice();
		}
		
		return total;
	}
	
	//---GetSet-----
	public InvoiceRepo getInvoiceRepoImpl() {
		return invoiceRepoImpl;
	}

	public ItemRepo getItemRepoImpl() {
		return itemRepoImpl;
	}

	public InvoiceListBean getInvoiceListBean() {
		return invoiceListBean;
	}

	public Item getNewItem() {
		return newItem;
	}

	public void setInvoiceRepoImpl(InvoiceRepo invoiceRepoImpl) {
		this.invoiceRepoImpl = invoiceRepoImpl;
	}

	public void setItemRepoImpl(ItemRepo itemRepoImpl) {
		this.itemRepoImpl = itemRepoImpl;
	}

	public void setInvoiceListBean(InvoiceListBean invoiceListBean) {
		this.invoiceListBean = invoiceListBean;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}
	
	

	
	
	

}
