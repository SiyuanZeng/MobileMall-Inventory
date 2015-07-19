package com.mindtree.mcse.mobilemall.dao;

import org.springframework.dao.DataAccessException;

import com.mindtree.mcse.mobilemall.domain.Item;
import com.mindtree.mcse.mobilemall.domain.Review;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HItem;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HReview;

public interface ItemDao {
  Item getItem(String itemId) throws DataAccessException;
  HItem getHItem(String itemId) throws DataAccessException;
  int addReview(Review review) throws DataAccessException;
  void addReviewHibernateAnnotation(HReview review) throws DataAccessException;

}
