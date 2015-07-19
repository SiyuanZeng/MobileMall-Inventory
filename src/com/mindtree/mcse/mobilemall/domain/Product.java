
package com.mindtree.mcse.mobilemall.domain;

import java.io.Serializable;


public class Product implements Serializable {

	private static final long serialVersionUID = 6324339670680699177L;
	private String productId;
	private String categoryId;
	private String name;
	private String descriptionWithImage;
	private String description;
	private String image;
	
	public Product() {
	}

	public String getProductId() { 
		return productId; 
	}
	
	public void setProductId(String newProductId) { 
		this.productId = newProductId; 
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
	
	public String getDescriptionWithImage() {
		return this.descriptionWithImage;
	}
	
	public void setDescriptionWithImage(String newDespWithImage) {
		this.parseDescription(newDespWithImage);
	}

	public String getDescription() { 
		return description; 
	}
	
	public void setDescription(String desc) { 
		this.description = desc; 
	}
	
	public String getImage() {
		return this.image;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", image=");
		builder.append(image);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * To follow the original Pet Store db schema,
	 * image location and description are stored
	 * inside the same description column. 
	 * Ideally, they should be stored in seperated column.
	 * 
	 * @param desp the product description to be parsed
	 */
	private void parseDescription(String desp) {
		if (desp != null && desp.indexOf(">") > 0) {
			this.image = desp.substring(0, desp.indexOf(">"));
			this.description = desp.substring(desp.indexOf(">") + 1);
		}
		else {
			this.description = desp;
		}
	}
}
