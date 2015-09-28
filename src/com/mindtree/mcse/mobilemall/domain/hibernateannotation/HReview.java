package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "review")
public class HReview implements Comparable<HReview> {
	private String id;
	private String itemId;
	private String name;
	private Date timeStamp;
	private String title;
	private String description;
	// Fixing the Gson Serialization Error	
	private transient Logger LOGGER = Logger.getLogger(HReview.class);

	public HReview(String id, String itemId, String name, Date timeStamp,
			String title, String description) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.name = name;
		this.timeStamp = timeStamp;
		this.title = title;
		this.description = description;
	}

	public HReview() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "itemid")
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TimeStamp")
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Description")
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
		HReview other = (HReview) obj;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}

	@Override
	public int compareTo(HReview review) {
		return -timeStamp.compareTo(review.getTimeStamp());
	}

	@Override
	public String toString() {
		return "HReview [id=" + id + ", itemId=" + itemId + ", name=" + name
				+ ", timeStamp=" + timeStamp + ", title=" + title
				+ ", description=" + description + "]";
	}

	public static class HReviewComparator implements Comparator<HReview> {
		// Fixing the Gson Serialization Error
		private transient Logger LOGGER = Logger.getLogger(HReviewComparator.class);
		public int compare(HReview r1, HReview r2) {
			LOGGER.debug("r1:" + r1.getTimeStamp());
			LOGGER.debug("r2:" + r2.getTimeStamp());
			return -r1.timeStamp.compareTo( r2.getTimeStamp()) ;
		}
	}
}
