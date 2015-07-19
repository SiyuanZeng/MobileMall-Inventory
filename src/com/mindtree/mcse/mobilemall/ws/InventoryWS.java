package com.mindtree.mcse.mobilemall.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.mindtree.mcse.mobilemall.domain.Item;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HItem;
import com.mindtree.mcse.mobilemall.event.AddReviewEvent;
import com.mindtree.mcse.mobilemall.event.GetHItemEvent;
import com.mindtree.mcse.mobilemall.event.GetItemEvent;
import com.mindtree.mcse.mobilemall.event.InventoryCheckEvent;

@WebService
public interface InventoryWS {
	
	@WebMethod
	public int checkItemInventory(@WebParam(name="event") InventoryCheckEvent event);
	
	@WebMethod
	public void updateItemInventory(@WebParam(name="event") InventoryCheckEvent event);
	
	@WebMethod
	public int addReview(@WebParam(name="event") AddReviewEvent event);
	
	@WebMethod
	public void addReviewHibernateAnnotation(@WebParam(name="event") AddReviewEvent event);

	@WebMethod
	public Item getItem(@WebParam(name="event") GetItemEvent event);
	
	@WebMethod
	public HItem getHItem(@WebParam(name="event") GetHItemEvent event);
}

