package com.mindtree.test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.jws.WebMethod;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.mindtree.mcse.mobilemall.domain.Item;
import com.mindtree.mcse.mobilemall.domain.Review;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HItem;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HReview;
import com.mindtree.mcse.mobilemall.event.AddReviewEvent;
import com.mindtree.mcse.mobilemall.event.GetHItemEvent;
import com.mindtree.mcse.mobilemall.event.GetItemEvent;
import com.mindtree.mcse.mobilemall.ws.InventoryServiceEndPoint;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext-test.xml" })
public class InventoryServiceEndPointTest {
	private Logger logger = Logger.getLogger(InventoryServiceEndPointTest.class);
	
	@Autowired
	@Qualifier("inventorySEP")
	InventoryServiceEndPoint inventoryServiceEndPoint;
	
	private Gson gson = new Gson();
	
	@Test
	public void testAddReviewHibernateAnnotation(){
		HReview hReview = new HReview("1", "EST-5", "Nokia", new Date(), "TitleReal", "Description");
		String json = gson.toJson(hReview);
		AddReviewEvent event = new AddReviewEvent();
		event.sethReview(json);
		inventoryServiceEndPoint.addReviewHibernateAnnotation(event);
	}
	
	@Test
	public void testAddReview(){
		Review review = new Review("1", "EST-5", "Nokia", new Date(), "TitleReal", "Description");
		String json = gson.toJson(review);
		AddReviewEvent event = new AddReviewEvent();
		event.setReview(json);
		inventoryServiceEndPoint.addReview(event);
	}
	
	@Test
	public void testGetItem(){
		HReview hReview = new HReview("1", "EST-5", "Nokia", new Date(), "TitleReal", "Description");
		String json = gson.toJson(hReview);
		GetItemEvent event = new GetItemEvent();
		event.setItemId(hReview.getItemId());
		Item item = inventoryServiceEndPoint.getItem(event);
		logger.debug(item);
		assertNotNull(item);
	}
	
	@Test
	public void testGetHItem(){
		HReview hReview = new HReview("1", "EST-5", "Nokia", new Date(), "TitleReal", "Description");
		String json = gson.toJson(hReview);
		GetHItemEvent event = new GetHItemEvent();
		event.setHItemId(hReview.getItemId());
		HItem item = inventoryServiceEndPoint.getHItem(event);
		logger.debug(item);
		assertNotNull(item);
	}
	
	
	
	
	

}
