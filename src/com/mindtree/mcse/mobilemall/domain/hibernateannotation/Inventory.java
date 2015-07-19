
package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;

public class Inventory implements Serializable{

	private static final long serialVersionUID = 2080017291348056747L;
	private String itemId;
	private int quantity;
	private HItem item;
	private HItem itemH;

	public Inventory() {
	}
	
	public String getItemId() {
		return this.itemId;
	}
	
	public void setItemId(String newItemId) {
		this.itemId = newItemId;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}
	
	public HItem getItem() {
		return this.item;
	}
	
	public void setItem(HItem newItem) {
		this.item = newItem;
	}

	public HItem getItemH() {
		return itemH;
	}

	public void setItemH(HItem itemH) {
		this.itemH = itemH;
	}
	
}
