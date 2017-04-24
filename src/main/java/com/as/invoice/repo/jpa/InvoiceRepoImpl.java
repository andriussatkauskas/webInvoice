package com.as.invoice.repo.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.as.invoice.entities.Invoice;
import com.as.invoice.repo.InvoiceRepo;

public class InvoiceRepoImpl implements InvoiceRepo {
	static final Logger log = LoggerFactory.getLogger(InvoiceRepoImpl.class);

	private EntityManagerFactory entityManagerFactory;

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	
	public Invoice findByNumber(Long number) {
		EntityManager em = getEntityManager();
		try {
			TypedQuery<Invoice> invoiceQuery = em.createQuery("SELECT i From Invoice i WHERE i.number =:number",
					Invoice.class);
			invoiceQuery.setParameter("number", number);
			invoiceQuery.setMaxResults(1);

			return invoiceQuery.getSingleResult();
		} finally {
			em.close();
		}
	}

	public List<Invoice> findAll() {
		EntityManager em = getEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
			Root<Invoice> root = cq.from(Invoice.class);
			cq.select(root);
			TypedQuery<Invoice> tq = em.createQuery(cq);
			return tq.getResultList();
		} finally {
			em.close();
		}
	}

	
//	public void save(Invoice newInvoice) {
//		EntityManager em = getEntityManager();
//		try {
//			em.getTransaction().begin();
//			if (!em.contains(newInvoice))
//				newInvoice = em.merge(newInvoice);
//			em.persist(newInvoice);
//			em.getTransaction().commit();
//		} finally {
//			em.close();
//		}
//
//	}

	
	public void delete(Invoice invoice) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			invoice = em.merge(invoice);
			em.remove(invoice);
			em.getTransaction().commit();
		} finally {
			em.close();
		}

	}

	private EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}


	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteInBatch(Iterable<Invoice> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Invoice> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Invoice> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Invoice> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Invoice> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Invoice getOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Invoice> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Invoice> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Invoice> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Iterable<? extends Invoice> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Invoice findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Invoice> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <S extends Invoice> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public <S extends Invoice> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Invoice> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Invoice> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
