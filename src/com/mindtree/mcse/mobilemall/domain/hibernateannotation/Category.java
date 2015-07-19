/*
 * MyPetStore Project.
 */
package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;

public class Category implements Serializable {

	public Category(String categoryId, String name, String description) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
	}

	private static final long serialVersionUID = 8265957051193499588L;
	private String categoryId;
	private String name;
	private String description;

	public Category() {
	}
	
	public String getCategoryId() { 
		return categoryId; 
	}
	
	public void setCategoryId(String newCategoryId) { 
		this.categoryId = newCategoryId; 
	}

	public String getName() { 
		return name; 
	}
	
	public void setName(String newName) { 
		this.name = newName; 
	}

	public String getDescription() { 
		return description; 
	}
	
	public void setDescription(String newDescription) { 
		this.description = newDescription; 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [categoryId=");
		builder.append(categoryId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	
}
