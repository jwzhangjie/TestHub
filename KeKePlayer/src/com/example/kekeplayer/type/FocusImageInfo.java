package com.example.kekeplayer.type;

import java.io.Serializable;

public class FocusImageInfo implements Serializable {

	private static final long serialVersionUID = 7387172661221990407L;
	public static final String CONTENT_TYPE_PROGRAMA = "2";
	public static final String CONTENT_TYPE_TV = "1";
	public static final String CONTENT_TYPE_VIDEO = "4";
	public static final String CONTENT_TYPE_VIDEO_EPISODE = "3";
	private String content_id;
	private String content_type_id;
	private String desc;
	private String img;
	private String title;

	public String getContent_id() {
		return this.content_id;
	}

	public String getContent_type_id() {
		return this.content_type_id;
	}

	public String getDesc() {
		return this.desc;
	}

	public String getImg() {
		return this.img;
	}

	public String getTitle() {
		return this.title;
	}

	public void setContent_id(String paramString) {
		this.content_id = paramString;
	}

	public void setContent_type_id(String paramString) {
		this.content_type_id = paramString;
	}

	public void setDesc(String paramString) {
		this.desc = paramString;
	}

	public void setImg(String paramString) {
		this.img = paramString;
	}

	public void setTitle(String paramString) {
		this.title = paramString;
	}
}