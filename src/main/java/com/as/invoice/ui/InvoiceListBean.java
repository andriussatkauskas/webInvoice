package com.as.invoice.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.as.invoice.entities.*;

import com.as.invoice.repo.*;

public class InvoiceListBean {
	static final Logger log = LoggerFactory.getLogger(InvoiceListBean.class);

	
	
	//--------container-------------
	
 public static class InvoicePageData implements Serializable {

		private static final long serialVersionUID = -3924198083822619907L;

		@Valid
		private Invoice newInvoice;

		@Valid
		private Invoice currentInvoice;

		private List<Invoice> foundInvoices;

		public void init() {
			newInvoice = new Invoice();
			foundInvoices = new ArrayList<Invoice>();
		}

		public Invoice getNewInvoice() {
			return newInvoice;
		}

		public void setNewInvoice(Invoice newInvoice) {
			this.newInvoice = newInvoice;
		}

		public Invoice getCurrentInvoice() {
			return currentInvoice;
		}

		public void setCurrentInvoice(Invoice currentInvoice) {
			this.currentInvoice = currentInvoice;
		}

		public List<Invoice> getFoundInvoices() {
			return foundInvoices;
		}

		public void setFoundInvoices(List<Invoice> foundInvoices) {
			this.foundInvoices = foundInvoices;
		}
	}
//-----------bean fields---------------
 
 
	private InvoicePageData invoicePageData;

	private InvoiceRepo invoiceRepoImpl;
	
	
//---------bean methods---------------
	public String addNew() {
		invoiceRepoImpl.save(invoicePageData.newInvoice);
		invoicePageData.newInvoice = new Invoice();

		return "invoiceList";
	}

	public String deleteSelected(Invoice invoice) {
		
		
		
		invoiceRepoImpl.delete(invoice);

		return "invoiceList";
	}

	public String showAddItemPage(Invoice invoice) {
		invoicePageData.currentInvoice = invoice;
		return "itemList";
	}	
		
	public List<Invoice> getInvoiceList() {
		return invoiceRepoImpl.findAll();
	}
	
	
	//----------get and set-----------------
	public InvoicePageData getInvoicePageData() {
		return invoicePageData;
	}

	public InvoiceRepo getInvoiceRepoImpl() {
		return invoiceRepoImpl;
	}

	public void setInvoicePageData(InvoicePageData invoicePageData) {
		this.invoicePageData = invoicePageData;
	}

	public void setInvoiceRepoImpl(InvoiceRepo invoiceRepoImpl) {
		this.invoiceRepoImpl = invoiceRepoImpl;
	}

	
	
	

}
