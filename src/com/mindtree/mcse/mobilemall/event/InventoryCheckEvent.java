package com.mindtree.mcse.mobilemall.event;

import java.io.Serializable;
import java.util.Date;

public class InventoryCheckEvent implements Serializable{

	private static final long serialVersionUID = -6734232022452914606L;
	
	private Date createdDate;
	private String itemId;
	private int quantity;
	
	public InventoryCheckEvent(){
		createdDate = new Date();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryCheckEvent [createdDate=");
		builder.append(createdDate);
		builder.append(", itemId=");
		builder.append(itemId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}

}//eof
