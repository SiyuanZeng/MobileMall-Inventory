package com.mindtree.mcse.mobilemall.event;

import java.io.Serializable;

public class GetHItemEvent implements Serializable {

	private static final long serialVersionUID = -6734232022452914606L;

	private String hItemId;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}

	public String getHItemId() {
		return hItemId;
	}

	public void setHItemId(String hItemId) {
		this.hItemId = hItemId;
	}

}// eof
