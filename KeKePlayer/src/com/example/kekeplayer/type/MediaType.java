package com.example.kekeplayer.type;

import java.io.Serializable;

public class MediaType implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mediatype;
	private String name;

	public MediaType() {
	}

	public MediaType(String paramString1, String paramString2) {
		this.name = paramString1;
		this.mediatype = paramString2;
	}

	public String getMediatype() {
		return this.mediatype;
	}

	public String getName() {
		return this.name;
	}

	public void setMediatype(String paramString) {
		this.mediatype = paramString;
	}

	public void setName(String paramString) {
		this.name = paramString;
	}
}