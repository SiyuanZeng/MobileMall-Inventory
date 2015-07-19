package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Cart implements Serializable {

	/* Private Fields */

	private static final long serialVersionUID = -6250282918710948271L;

	private final Map itemMap = Collections.synchronizedMap(new HashMap());

	private final PagedListHolder itemList = new PagedListHolder();
	
	/* JavaBeans Properties */

	public Cart() {
		this.itemList.setPageSize(4);
	}

	public Iterator getAllCartItems() {
		return itemList.getSource().iterator();
	}

	public PagedListHolder getCartItemList() {
		return itemList;
	}

	public int getNumberOfItems() {
		return itemList.getSource().size();
	}

	/* Public Methods */

	public boolean containsItemId(String itemId) {
		return itemMap.containsKey(itemId);
	}

	public void addItem(HItem item, boolean isInStock) {
		CartItem cartItem = (CartItem) itemMap.get(item.getItemId());
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setQuantity(0);
			cartItem.setInStock(isInStock);
			itemMap.put(item.getItemId(), cartItem);
			itemList.getSource().add(cartItem);
		}
		cartItem.incrementQuantity();
	}

	public HItem removeItemById(String itemId) {
		CartItem cartItem = (CartItem) itemMap.remove(itemId);
		if (cartItem == null) {
			return null;
		} else {
			itemList.getSource().remove(cartItem);
			return cartItem.getItem();
		}
	}

	public void incrementQuantityByItemId(String itemId) {
		CartItem cartItem = (CartItem) itemMap.get(itemId);
		cartItem.incrementQuantity();
	}

	public void setQuantityByItemId(String itemId, int quantity) {
		CartItem cartItem = (CartItem) itemMap.get(itemId);
		cartItem.setQuantity(quantity);
	}

	public double getSubTotal() {
		double subTotal = 0;
		Iterator items = getAllCartItems();
		while (items.hasNext()) {
			CartItem cartItem = (CartItem) items.next();
			HItem item = cartItem.getItem();
			double listPrice = item.getListPrice();
			int quantity = cartItem.getQuantity();
			subTotal += listPrice * quantity;
		}
		return subTotal;
	}

}
