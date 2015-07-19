/*
 * MyPetStore Project.
 */
package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;


public class LineItem implements Serializable {

	private static final long serialVersionUID = 3598851706599423696L;
	private int orderId;
	private int lineNumber;
	private int quantity;
	private String itemId;
	private double unitPrice;
	
	private HItem item;
	
	public LineItem() {
	}
	
	public int getOrderId() { 
		return orderId; 
	}
	
	public void setOrderId(int newOrderId) { 
		this.orderId = newOrderId; 
	}

	public int getLineNumber() { 
		return lineNumber; 
	}
	
	public void setLineNumber(int newLineNumber) { 
		this.lineNumber = newLineNumber; 
	}

	public String getItemId() { 
		return itemId; 
	}
	
	public void setItemId(String newItemId) { 
		this.itemId = newItemId; 
	}

	public double getUnitPrice() { 
		return unitPrice; 
	}
	
	public void setUnitPrice(double newUnitprice) { 
		this.unitPrice = newUnitprice; 
	}

	public int getQuantity() { 
		return quantity; 
	}
	
	public void setQuantity(int newQuantity) {
	  this.quantity = newQuantity;
	}

	public double getTotalPrice() {
		return this.unitPrice * this.quantity;
	}
	
	public boolean equals(Object obj) {
		if (obj != null) {
			if (obj instanceof LineItem) {
				return this.orderId == ((LineItem)obj).orderId && 
					this.lineNumber == ((LineItem)obj).lineNumber;
			}
		}
		
		return false;
	}
	
	public int hashCode() {
		return this.orderId + this.lineNumber;
	}

	public HItem getItem() {
		return item;
	}

	public void setItem(HItem item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineItem [orderId=");
		builder.append(orderId);
		builder.append(", lineNumber=");
		builder.append(lineNumber);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", itemId=");
		builder.append(itemId);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append("]");
		return builder.toString();
	}
	
	
}
