package com.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.model.Inventory;

// service layer
@Service
public interface InventoryService {
	
	// for create new Inventory.
	public Inventory createInventory(Inventory inventory);
	
	//  List all Inventory product. 
	public List<Inventory> getallInvetoryDetails();
	
	// Update to Inventory Details.
	public Inventory getupdateInventoryDetails(long id ,Inventory inventory);
	
	// for delete Inventory Product.
	public String getDeleteInventoryDetails(long productId);
	
	// get specific Inventory Product.
		public Inventory getInventoryProductDetail(long productId);

}
