package com.mindtree.mcse.mobilemall.dao.hibernate;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mindtree.mcse.mobilemall.dao.InventoryDao;
import com.mindtree.mcse.mobilemall.domain.Inventory;
import com.mindtree.mcse.mobilemall.domain.Review;

public class InventoryDaoHibernateImpl extends HibernateDaoSupport  implements InventoryDao {

	@Override
	public Inventory getInventory(String itemId) {
		Inventory inv = this.getHibernateTemplate().get(Inventory.class, itemId);
		System.out.println(inv);
		return inv;
	}
	
	@Override
	public void updateInventory(Inventory inv){
		try{
			this.getSession().merge(inv);
			System.out.println(inv.getItemId() + " updated");
			this.getHibernateTemplate().saveOrUpdate(inv);
		} catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public int addReview(Review review) throws DataAccessException {
		return Integer.parseInt((String) this.getSession().save(review));
	}

}
