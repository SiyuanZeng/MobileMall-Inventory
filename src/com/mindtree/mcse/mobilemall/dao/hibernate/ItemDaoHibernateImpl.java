package com.mindtree.mcse.mobilemall.dao.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mindtree.mcse.mobilemall.dao.ItemDao;
import com.mindtree.mcse.mobilemall.domain.Item;
import com.mindtree.mcse.mobilemall.domain.Review;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HItem;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HReview;

public class ItemDaoHibernateImpl extends HibernateDaoSupport implements ItemDao {

	@Override
	public int addReview(Review review) throws DataAccessException {
		return Integer.parseInt((String) this.getSession().save(review));
	}
	
	@Override
	public void addReviewHibernateAnnotation(HReview hReview) throws DataAccessException {
		Session session = null;
    	Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		    // create session
		    tx =session.beginTransaction();
		    // do something
		    session.save(hReview);
		    tx.commit();
		}catch(RuntimeException e){
    		try{
    			tx.rollback();
    		}catch(RuntimeException rbe){
    			System.out.println("Couldn’t roll back transaction");
    		}
    		throw e;
    	}finally{
    		if(session!=null){
    			session.close();
    		}
    	}
		
		
	}

	@Override
	public Item getItem(String itemId) {
/*	Old version	*/
		Item item = (Item)this.getHibernateTemplate().get(Item.class, itemId);
		
		System.out.println(item);
		return item;
	}

	@Override
	public HItem getHItem(String itemId) {
		HItem hItem = (HItem)HibernateUtil.getSessionFactory().openSession().get(HItem.class, itemId);
		System.out.println(hItem);
		return hItem;
	}
}
