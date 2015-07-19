/*
 * MyPetStore Project.
 */
package com.mindtree.mcse.mobilemall.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class Item implements Serializable {

	private static final long serialVersionUID = 7868618541127653999L;
	private String itemId;
	private double listPrice;
	private double unitCost;
	private int supplierId;
	private String status;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private Product product;
	private Inventory inventory;
	private Set<Review> reviews = new HashSet<Review>();

	public Item() {
		this.inventory = new Inventory();
		this.inventory.setItem(this);
		this.product = new Product();
	}
	
	public String getItemId() { 
		return itemId; 
	}
	
	public void setItemId(String newItemId) { 
		this.itemId = newItemId;
	}

	public int getQuantity() { 
		return this.inventory.getQuantity();
	}
	
	public void setQuantity(int newQuantity) { 
		this.inventory.setQuantity(newQuantity); 
	}

	public int getSupplierId() { 
		return supplierId; 
	}
	
	public void setSupplierId(int newSupplierId) { 
		this.supplierId = newSupplierId; 
	}

	public double getListPrice() { 
		return listPrice; 
	}
	
	public void setListPrice(double newListPrice) { 
		this.listPrice = newListPrice; 
	}

	public double getUnitCost() { 
		return unitCost; 
	}
	
	public void setUnitCost(double newUnitCost) { 
		this.unitCost = newUnitCost; 
	}

	public String getStatus() { 
		return status; 
	}
	
	public void setStatus(String newStatus) { 
		this.status = newStatus; 
	}

	public String getAttribute1() { 
		return attribute1; 
	}
	
	public void setAttribute1(String newAttribute1) { 
		this.attribute1 = newAttribute1; 
	}

	public String getAttribute2() { 
		return attribute2; 
	}
	
	public void setAttribute2(String newAttribute2) { 
		this.attribute2 = newAttribute2; 
	}

	public String getAttribute3() { 
		return attribute3; 
	}
	
	public void setAttribute3(String newAttribute3) { 
		this.attribute3 = newAttribute3; 
	}

	public String getAttribute4() { 
		return attribute4; 
	}
	
	public void setAttribute4(String newAttribute4) { 
		this.attribute4 = newAttribute4; 
	}

	public String getAttribute5() { 
		return attribute5; 
	}
	
	public void setAttribute5(String newAttribute5) { 
		this.attribute5 = newAttribute5; 
	}
	
	public Product getProduct() { 
		return product; 
	}
	
	public void setProduct(Product newProduct) { 
		this.product = newProduct; 
	}
	
	public String getProductName() {
		return this.product.getName();
	}
	
	public String getDescription() {
		return this.product.getDescription();
	}
	
	public String getImage() {
		return this.product.getImage();
	}
	
	private Inventory getInventory() {
		return this.inventory;
	}
	
	private void setInventory(Inventory newInventory) {
		this.inventory = newInventory;
	}
	
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [itemId=");
		builder.append(itemId);
		builder.append(", listPrice=");
		builder.append(listPrice);
		builder.append(", unitCost=");
		builder.append(unitCost);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", attribute1=");
		builder.append(attribute1);
		builder.append(", attribute2=");
		builder.append(attribute2);
		builder.append(", attribute3=");
		builder.append(attribute3);
		builder.append(", attribute4=");
		builder.append(attribute4);
		builder.append(", attribute5=");
		builder.append(attribute5);
		builder.append("]");
		return builder.toString();
	}
	
	
}
