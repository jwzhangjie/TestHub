package com.example.kekeplayer.type;

public class Collect {
	private String content_id = "";
	private String content_type_id = "";
	private int id;
	private String intro = "";
	private String liveurl = "";
	private String pic = "";
	private String title = "";
	private int total = 1;

	public String getContent_id() {
		return this.content_id;
	}

	public String getContent_type_id() {
		return this.content_type_id;
	}

	public int getId() {
		return this.id;
	}

	public String getIntro() {
		return this.intro;
	}

	public String getLiveurl() {
		return this.liveurl;
	}

	public String getPic() {
		return this.pic;
	}

	public String getTitle() {
		return this.title;
	}

	public int getTotal() {
		return this.total;
	}

	public void setContent_id(String paramString) {
		this.content_id = paramString;
	}

	public void setContent_type_id(String paramString) {
		this.content_type_id = paramString;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public void setIntro(String paramString) {
		this.intro = paramString;
	}

	public void setLiveurl(String paramString) {
		this.liveurl = paramString;
	}

	public void setPic(String paramString) {
		this.pic = paramString;
	}

	public void setTitle(String paramString) {
		this.title = paramString;
	}

	public void setTotal(int paramInt) {
		this.total = paramInt;
	}
}