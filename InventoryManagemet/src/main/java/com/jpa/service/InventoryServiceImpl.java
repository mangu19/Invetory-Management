package com.jpa.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.dao.InventoryRepository1;
import com.jpa.model.Inventory;

public class InventoryServiceImpl  implements InventoryService{
@Autowired
InventoryRepository1 inventoryRepository1;
	
@Override
	// insert inventory details.
	public Inventory createInventory(Inventory inventory) {
		inventoryRepository1.save(inventory);
		return null;
	}
// list All Inventory with Details
@Override
public List<Inventory> getallInvetoryDetails() {
	// TODO Auto-generated method stub
	return (List<Inventory>) inventoryRepository1.findAll();
}
// update Inventory Details 
@Override
public Inventory getupdateInventoryDetails(long id,Inventory inventory) {
	inventory.setId(id);
	return inventoryRepository1.save(inventory);
}

// delete product
@Override
public String getDeleteInventoryDetails(long productid) {
	
	inventoryRepository1.deleteById(productid);
			
	return "product deleted succesfull...";
}


@Override
public Inventory getInventoryProductDetail(long productId) {
	Inventory inventory=null;  		  
	  Optional<Inventory> optional=inventoryRepository1.findById(productId);
	  inventory=optional.get();
	 		
	return inventory;
}
}
