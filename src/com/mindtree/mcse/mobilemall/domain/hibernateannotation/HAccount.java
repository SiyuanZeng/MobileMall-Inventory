/*
 * MyPetStore Project.
 */
package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;

@SuppressWarnings("unused")
public class HAccount implements Serializable {

	public HAccount(String username, String email, String firstName,
			String lastName, String status, String address1, String address2,
			String city, String state, String zip, String country,
			String phone, String creditCard, String expiryDate,
			String cardType, Signon signon) {
		super();
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		this.creditCard = creditCard;
		this.expiryDate = expiryDate;
		this.cardType = cardType;
		this.signon = signon;
	}


	private static final long serialVersionUID = 6399662273272710040L;
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String status;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	private String creditCard;
	private String expiryDate;
	private String cardType;

	private Signon signon;
	private Profile profile;
	
	
	public HAccount() {
		this.signon = new Signon();
		this.signon.setAccount(this);
		this.profile = new Profile();
		this.profile.setAccount(this);
	}

	public String getUsername() { 
		return username; 
	}
	
	public void setUsername(String newUsername) { 
		this.username = newUsername; 
	}

	public String getEmail() { 
		return email; 
	}
	
	public void setEmail(String newEmail) { 
		this.email = newEmail; 
	}

	public String getFirstName() { 
		return firstName; 
	}
	
	public void setFirstName(String newFirstName) { 
		this.firstName = newFirstName; 
	}

	public String getLastName() { 
		return lastName; 
	}
	
	public void setLastName(String newLastName) { 
		this.lastName = newLastName; 
	}

	public String getStatus() { 
		return status; 
	}
	
	public void setStatus(String newStatus) { 
		this.status = newStatus; 
	}

	public String getAddress1() { 
		return address1; 
	}
	
	public void setAddress1(String newAddress1) { 
		this.address1 = newAddress1; 
	}

	public String getAddress2() { 
		return address2; 
	}
	
	public void setAddress2(String newAddress2) { 
		this.address2 = newAddress2; 
	}

	public String getCity() { 
		return city; 
	}
	
	public void setCity(String newCity) { 
		this.city = newCity; 
	}

	public String getState() { 
		return state; 
	}
	
	public void setState(String newState) { 
		this.state = newState; 
	}

	public String getZip() { 
		return zip; 
	}
	
	public void setZip(String newZip) { 
		this.zip = newZip; 
	}

	public String getCountry() { 
		return country; 
	}
	
	public void setCountry(String newCountry) { 
		this.country = newCountry; 
	}

	public String getPhone() { 
		return phone; 
	}
	
	public void setPhone(String newPhone) { 
		this.phone = newPhone; 
	}
	
	public String getCreditCard() {
		return this.creditCard;
	}
	
	public void setCreditCard(String newCreditCard) {
		this.creditCard = newCreditCard;
	}
	
	public String getExpiryDate() {
		return this.expiryDate;
	}
	
	public void setExpiryDate(String newExpiryDate) {
		this.expiryDate = newExpiryDate;
	}
	
	public String getCardType() {
		return this.cardType;
	}
	
	public void setCardType(String newCardType) {
		this.cardType = newCardType;
	}
	
	//profile dependent object

	public Profile getProfile() {
		return this.profile;
	}
	
	private void setProfile(Profile newProfile) {
		this.profile = newProfile;
	}

	public String getFavoriteCategoryId() { 
		return this.profile.getFavoriteCategoryId();
	}
	 
	public void setFavoriteCategoryId(String newFavoriteCategoryId) { 
		System.out.println("FavCategoryID is: " + newFavoriteCategoryId);
		this.profile.setFavoriteCategoryId(newFavoriteCategoryId); 
	}

	public String getLanguagePreference() { 
		return this.profile.getLanguagePreference();
	}
	
	public void setLanguagePreference(String newLanguagePreference) { 
		this.profile.setLanguagePreference(newLanguagePreference); 
	}

	public boolean isListOption() { 
		return this.profile.isListOption();
	}
	
	public void setListOption(boolean newListOption) { 
		this.profile.setListOption(newListOption); 
	}

	public boolean isBannerOption() { 
		return this.profile.isBannerOption();
	}
	
	public void setBannerOption(boolean newBannerOption) { 
		this.profile.setBannerOption(newBannerOption); 
	}
	
	//signon dependent object
	public Signon getSignon() {
		return this.signon;
	}
	
	private void setSignon(Signon newSignon) { 
		this.signon = newSignon; 
	}
	 
	public String getPassword() { 
		return this.signon.getPassword(); 
	}
	
	public void setPassword(String newPassword) { 
		this.signon.setPassword(newPassword); 
	}
	
	public boolean isAdmin() {
		return this.signon.isAdmin();
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zip=");
		builder.append(zip);
		builder.append(", country=");
		builder.append(country);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", creditCard=");
		builder.append(creditCard);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", signon=");
		builder.append(signon);
		builder.append(", profile=");
		builder.append(profile);
		builder.append("]");
		return builder.toString();
	}
	
	
}
