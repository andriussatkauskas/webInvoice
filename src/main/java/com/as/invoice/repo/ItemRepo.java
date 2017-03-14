package com.as.invoice.repo;

import java.util.List;

import com.as.invoice.entities.Item;

public interface ItemRepo {
public void insertOrUpdate(Item item);
	
	public void delete(Item item);
	
	public void deleteById(Long itemId);
	
	public List<Item> findAll();
	
	public Long countAllItems();
	
	

}
