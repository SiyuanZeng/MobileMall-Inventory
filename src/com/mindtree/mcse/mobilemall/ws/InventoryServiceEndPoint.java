package com.mindtree.mcse.mobilemall.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.google.gson.Gson;
import com.mindtree.mcse.mobilemall.dao.InventoryDao;
import com.mindtree.mcse.mobilemall.dao.ItemDao;
import com.mindtree.mcse.mobilemall.domain.Inventory;
import com.mindtree.mcse.mobilemall.domain.Item;
import com.mindtree.mcse.mobilemall.domain.Review;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HItem;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HReview;
import com.mindtree.mcse.mobilemall.event.AddReviewEvent;
import com.mindtree.mcse.mobilemall.event.GetHItemEvent;
import com.mindtree.mcse.mobilemall.event.GetItemEvent;
import com.mindtree.mcse.mobilemall.event.InventoryCheckEvent;

@WebService(endpointInterface="com.mindtree.mcse.mobilemall.ws.InventoryWS", serviceName="InventoryService")
public class InventoryServiceEndPoint implements InventoryWS {

	private InventoryDao inventoryDao;
	private ItemDao itemDao;
	Gson gson = new Gson();
	
	
    public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}



	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}



	public int checkItemInventory(final InventoryCheckEvent event)  {
        return processInventoryCheck(event);
    }//end of checkItemInventory
	
    private int processInventoryCheck(final InventoryCheckEvent event) {
    	System.out.println("Received Event: " + event);
    	Inventory inv = inventoryDao.getInventory(event.getItemId());
    	System.out.println("Stock: " + inv.getQuantity());
    	return inv.getQuantity();
    }//end of processInventoryCheck

	@Override
	@WebMethod
	public void updateItemInventory(final InventoryCheckEvent event) {
		Inventory inv = inventoryDao.getInventory(event.getItemId());
		inv.setQuantity(inv.getQuantity() - event.getQuantity());
		inventoryDao.updateInventory(inv);
		
	}

	@Override
	@WebMethod
	public int addReview(final AddReviewEvent event) {
    	System.out.println("Received Event: " + event);
		Review review = gson.fromJson(event.getReview(), Review.class);
    	int result= itemDao.addReview(review);
    	System.out.println("Review Id: " + result);
		return result;
	}
	
	@Override
	@WebMethod
	public void addReviewHibernateAnnotation(final AddReviewEvent event) {
		System.out.println("Received Event: " + event);
		HReview hReview = gson.fromJson(event.gethReview(), HReview.class);
		itemDao.addReviewHibernateAnnotation(hReview);
//		System.out.println("Review Id: " + result);
//		return result;
	}

	@Override
	public Item getItem(GetItemEvent event) {
    	System.out.println("Get Item: " + event);
    	Item item= itemDao.getItem(event.getItemId());
    	System.out.println("Get Item: " + item);
//		return gson.toJson(item);
    	return item;
	}
	
	@Override
	public HItem getHItem(GetHItemEvent event) {
		System.out.println("Get Item: " + event);
		HItem item= itemDao.getHItem(event.getHItemId());
		System.out.println("Get Item: " + item);
		return item;
	}
}//eof
