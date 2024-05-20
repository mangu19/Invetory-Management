package com.jpa.controllert;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.model.Inventory;
import com.jpa.service.InventoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class InventoryManagements {

	@Autowired
	InventoryService inventoryService;
	
	// insert Inventory Details
	@PostMapping("/Inventory")
	 public Inventory createInventory(@RequestParam("productName") String productName,
	                          @RequestParam("description") String description,
	                          @RequestParam("status") String status,
	                          @RequestParam("file") MultipartFile file) throws IOException {
	    
		Inventory inventory=new Inventory();
		inventory.setProductName(productName);
		inventory.setDescription(description);
		inventory.setStatus(status);
		inventory.setImageData(file.getBytes());
		
	     return  this.inventoryService.createInventory(inventory);

	 }
	
	// Get All Inventory item List 	
		@GetMapping("/Inventory")
		public List<Inventory> allInvetoryDetailsList() {
			
			return this.inventoryService.getallInvetoryDetails();
		}
		
		// Update Inventory Details
		 @PutMapping("/Inventory/{id}")
		 public Inventory updateInventoryDetails(@RequestParam Long id, @RequestBody Inventory inventory) {
	
		     return this.inventoryService.getupdateInventoryDetails(id, inventory);
		 }
		 
		// Delete Inventory Details
			@DeleteMapping("/Inventory/{id}")
			public String DeleteInventoryDetails(@RequestParam String productid) {
				
				String a=this.inventoryService.getDeleteInventoryDetails(Long.parseLong(productid));
				return a;
			}
			
			// get specific product  Details
		    @GetMapping("/Inventory/{id}")
			public Inventory deleteCourse(@PathVariable String productid) {
							
			return  this.inventoryService.getInventoryProductDetail(Long.parseLong(productid));
			}
}
