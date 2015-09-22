package com.mindtree.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.mindtree.mcse.mobilemall.domain.hibernateannotation.HReview;
import com.mindtree.mcse.mobilemall.event.AddReviewEvent;
import com.mindtree.mcse.mobilemall.ws.InventoryServiceEndPoint;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml" })
public class InventoryServiceEndPointTest {

	@Autowired
	@Qualifier("inventorySEP")
	private InventoryServiceEndPoint inventoryServiceEndPoint;
	
	private Gson gson = new Gson();
	
	@Test
	public void testAddReviewHibernateAnnotation(){
		HReview hReview = new HReview("1", "EST-5", "Nokia", new Date(), "TitleReal", "Description");
		String json = gson.toJson(hReview);
		AddReviewEvent event = new AddReviewEvent();
		event.sethReview(json);
		inventoryServiceEndPoint.addReviewHibernateAnnotation(event);
	}
	
//	@Test
//	public void testAddReview(){
//		HReview hReview = new HReview("1", "EST-5", "Nokia", new Date(), "TitleReal", "Description");
//		String json = gson.toJson(hReview);
//		AddReviewEvent event = new AddReviewEvent();
//		event.sethReview(json);
//		inventoryServiceEndPoint.addReviewHibernateAnnotation(event);
//	}

}
