package com.mindtree.mcse.mobilemall.dao;

import org.springframework.dao.DataAccessException;

import com.mindtree.mcse.mobilemall.domain.Inventory;
import com.mindtree.mcse.mobilemall.domain.Review;

public interface InventoryDao {
	Inventory getInventory(String itemId);
	void updateInventory(Inventory inv);
	int addReview(Review review) throws DataAccessException;
}
