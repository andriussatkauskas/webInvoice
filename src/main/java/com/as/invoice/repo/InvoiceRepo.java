package com.as.invoice.repo;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.invoice.entities.Invoice;

public interface InvoiceRepo extends JpaRepository <Invoice, Long>{
//	public Invoice findByNumber(Long number);
//
//	public List<Invoice> findAll();
//
//	public void save(Invoice newInvoice);
//
//	public void delete(Invoice invoice);

}
