/*
 * MyPetStore Project.
 */
package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Entity
@Table(name = "item")
public class HItem implements Serializable {
	
	private static final long serialVersionUID = 7868618541127653999L;
	private String itemId;
	private double listPrice;
	private double unitCost;
	private int supplierId;
	private String status;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private HProduct hProduct;
	private Inventory inventory;
	private Set<HReview> hReviews = new HashSet<HReview>();

	public HItem() {
		this.inventory = new Inventory();
		this.inventory.setItemH(this);
		this.hProduct = new HProduct();
	}
	@Id
    @Column(name = "itemid")
	public String getItemId() { 
		return itemId; 
	}
	
	public void setItemId(String newItemId) { 
		this.itemId = newItemId;
	}
	@Transient 
	public int getQuantity() { 
		return this.inventory.getQuantity();
	}
	
	public void setQuantity(int newQuantity) { 
		this.inventory.setQuantity(newQuantity); 
	}

	@Column(name = "SUPPLIER")
	public int getSupplierId() { 
		return supplierId; 
	}
	
	public void setSupplierId(int newSupplierId) { 
		this.supplierId = newSupplierId; 
	}
	@Column(name = "LISTPRICE")
	public double getListPrice() { 
		return listPrice; 
	}
	
	public void setListPrice(double newListPrice) { 
		this.listPrice = newListPrice; 
	}

	@Column(name = "UNITCOST")
	public double getUnitCost() { 
		return unitCost; 
	}
	
	public void setUnitCost(double newUnitCost) { 
		this.unitCost = newUnitCost; 
	}
	@Column(name = "STATUS")
	public String getStatus() { 
		return status; 
	}
	
	public void setStatus(String newStatus) { 
		this.status = newStatus; 
	}
	@Column(name = "ATTR1")
	public String getAttribute1() { 
		return attribute1; 
	}
	
	public void setAttribute1(String newAttribute1) { 
		this.attribute1 = newAttribute1; 
	}
	@Column(name = "ATTR2")
	public String getAttribute2() { 
		return attribute2; 
	}
	
	public void setAttribute2(String newAttribute2) { 
		this.attribute2 = newAttribute2; 
	}
	@Column(name = "ATTR3")
	public String getAttribute3() { 
		return attribute3; 
	}
	
	public void setAttribute3(String newAttribute3) { 
		this.attribute3 = newAttribute3; 
	}
	@Column(name = "ATTR4")
	public String getAttribute4() { 
		return attribute4; 
	}
	
	public void setAttribute4(String newAttribute4) { 
		this.attribute4 = newAttribute4; 
	}
	@Column(name = "ATTR5")
	public String getAttribute5() { 
		return attribute5; 
	}
	
	public void setAttribute5(String newAttribute5) { 
		this.attribute5 = newAttribute5; 
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productid", insertable=false, updatable=false, nullable=false)
	public HProduct getHProduct() { 
		return hProduct; 
	}
	
	public void setHProduct(HProduct newHProduct) { 
		this.hProduct = newHProduct; 
	}
	@Transient 
	public String getProductName() {
		return this.hProduct.getName();
	}
	public void setProductName(String productName) {
		this.hProduct.setName(productName);
	}
	@Transient 
	public String getDescription() {
		return this.hProduct.getDescription();
	}
	public void setDescription(String description) {
		this.hProduct.setDescription(description);
	}
	@Transient 
	public String getImage() {
		return this.hProduct.getImage();
	}

	public void setImage(String image) {
		this.hProduct.setImage(image);
	}
	@Transient 
	private Inventory getInventory() {
		return this.inventory;
	}
	
	private void setInventory(Inventory newInventory) {
		this.inventory = newInventory;
	}
	@OneToMany
    @JoinColumn(name="itemid", insertable=false, updatable=false, nullable=false)
	public Set<HReview> gethReviews() {
		return hReviews;
	}

	public void sethReviews(Set<HReview> hReviews) {
		this.hReviews = hReviews;
	}

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [itemId=");
		builder.append(itemId);
		builder.append(", listPrice=");
		builder.append(listPrice);
		builder.append(", unitCost=");
		builder.append(unitCost);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", attribute1=");
		builder.append(attribute1);
		builder.append(", attribute2=");
		builder.append(attribute2);
		builder.append(", attribute3=");
		builder.append(attribute3);
		builder.append(", attribute4=");
		builder.append(attribute4);
		builder.append(", attribute5=");
		builder.append(", " + attribute5);
		builder.append(hReviews);
		builder.append("]");
		return builder.toString();
	}
	
	
}
