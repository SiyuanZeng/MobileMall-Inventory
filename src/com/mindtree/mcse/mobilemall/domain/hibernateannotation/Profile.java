
package com.mindtree.mcse.mobilemall.domain.hibernateannotation;

import java.io.Serializable;

public class Profile implements Serializable {

	private static final long serialVersionUID = 7393134044313477033L;
	private String username;
	private String favoriteCategoryId;
	private String languagePreference;
	private boolean listOption;
	private boolean bannerOption;
	
	private HAccount account;


	public Profile() {
	}
	
	public String getUsername() { 
		return username; 
	}
	
	public void setUsername(String newUsername) { 
		this.username = newUsername; 
	}
	
	public String getFavoriteCategoryId() { 
		return favoriteCategoryId; 
	}
	
	public void setFavoriteCategoryId(String newFavoriteCategoryId) { 
		this.favoriteCategoryId = newFavoriteCategoryId; 
	}

	public String getLanguagePreference() { 
		return languagePreference; 
	}
	
	public void setLanguagePreference(String newLanguagePreference) { 
		this.languagePreference = newLanguagePreference; 
	}

	public boolean isListOption() { 
		return listOption; 
	}
	
	public void setListOption(boolean newListOption) { 
		this.listOption = newListOption; 
	}

	public boolean isBannerOption() { 
		return bannerOption; 
	}
	
	public void setBannerOption(boolean newBannerOption) { 
		this.bannerOption = newBannerOption; 
	}
	
	public HAccount getAccount() {
		return this.account;
	}
	
	public void setAccount(HAccount newAccount) {
		this.account = newAccount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profile [username=");
		builder.append(username);
		builder.append(", favoriteCategoryId=");
		builder.append(favoriteCategoryId);
		builder.append(", languagePreference=");
		builder.append(languagePreference);
		builder.append(", listOption=");
		builder.append(listOption);
		builder.append(", bannerOption=");
		builder.append(bannerOption);
		builder.append("]");
		return builder.toString();
	}
	
	
}
