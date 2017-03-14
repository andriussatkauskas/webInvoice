package com.as.invoice.repo;

import java.util.List;

import com.as.invoice.entities.Invoice;

public interface InvoiceRepo {
	public Invoice findByNumber(Long number);

	public List<Invoice> findAll();

	public void save(Invoice newInvoice);

	public void delete(Invoice invoice);

}
