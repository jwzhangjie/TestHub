package com.example.kekeplayer.type;

import java.io.Serializable;

public class PlayBackInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String duration;
	private String url;

	public String getDuration() {
		return this.duration;
	}

	public String getUrl() {
		return this.url;
	}

	public void setDuration(String paramString) {
		this.duration = paramString;
	}

	public void setUrl(String paramString) {
		this.url = paramString;
	}
}