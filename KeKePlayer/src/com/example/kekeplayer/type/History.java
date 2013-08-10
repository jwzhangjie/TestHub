package com.example.kekeplayer.type;

public class History {
	private String content_id = "";
	private String content_type_id = "";
	private int id;
	private String pic = "";
	private int position = 0;
	private String series_num = "1";
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

	public String getPic() {
		return this.pic;
	}

	public int getPosition() {
		return this.position;
	}

	public String getSeries_num() {
		return this.series_num;
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

	public void setPic(String paramString) {
		this.pic = paramString;
	}

	public void setPosition(int paramInt) {
		this.position = paramInt;
	}

	public void setSeries_num(String paramString) {
		this.series_num = paramString;
	}

	public void setTitle(String paramString) {
		this.title = paramString;
	}

	public void setTotal(int paramInt) {
		this.total = paramInt;
	}
}