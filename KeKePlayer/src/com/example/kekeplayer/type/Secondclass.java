package com.example.kekeplayer.type;

import java.util.List;

public class Secondclass {
	private String argument_name;
	private List<SecondclassItem> items;
	private String mediatype;
	private String title;

	public String getArgument_name() {
		return this.argument_name;
	}

	public List<SecondclassItem> getItems() {
		return this.items;
	}

	public String getMediatype() {
		return this.mediatype;
	}

	public String getTitle() {
		return this.title;
	}

	public void setArgument_name(String paramString) {
		this.argument_name = paramString;
	}

	public void setItems(List<SecondclassItem> paramList) {
		this.items = paramList;
	}

	public void setMediatype(String paramString) {
		this.mediatype = paramString;
	}

	public void setTitle(String paramString) {
		this.title = paramString;
	}
}