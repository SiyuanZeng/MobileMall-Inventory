package com.mindtree.mcse.mobilemall.event;

import java.io.Serializable;

public class GetItemEvent implements Serializable {

	private static final long serialVersionUID = -6734232022452914606L;

	private String itemId;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}// eof
