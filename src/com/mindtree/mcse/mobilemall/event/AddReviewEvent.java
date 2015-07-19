package com.mindtree.mcse.mobilemall.event;

import java.io.Serializable;

public class AddReviewEvent implements Serializable{

	private static final long serialVersionUID = -6734232022452914606L;

	private String review;
	private String hReview;


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String gethReview() {
		return hReview;
	}

	public void sethReview(String hReview) {
		this.hReview = hReview;
	}
	
	

}//eof
