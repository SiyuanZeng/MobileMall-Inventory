package com.mindtree.mcse.mobilemall.domain;

import java.util.Date;


public class Review  implements Comparable<Review>{
	private String id;
	private String itemId;
	private String name;
	private Date timeStamp;
	private String title;
	private String description;
	
	public Review(String id, String itemId, String name, Date timeStamp, String title, String description) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.name = name;
		this.timeStamp = timeStamp;
		this.title = title;
		this.description = description;
	}
	public Review() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId= itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((timeStamp == null) ? 0 : timeStamp.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}
	@Override
	public int compareTo(Review review) {
		// TODO Auto-generated method stub
		return timeStamp.compareTo( review.getTimeStamp()) ;
	}

	
	
}
