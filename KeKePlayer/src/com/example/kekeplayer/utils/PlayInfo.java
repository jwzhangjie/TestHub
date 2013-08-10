package com.example.kekeplayer.utils;

import java.io.Serializable;
import java.util.List;

public class PlayInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Integer> HQdurations;
	private List<String> HQurls;
	private String content_id;
	private String content_type_id;
	private List<Integer> durations;
	private int order;
	private String pic_url;
	private boolean playback;
	private int position;
	private String title;
	private int totalorder;
	private List<String> urls;

	public PlayInfo() {
	}

	public PlayInfo(String content_id, String content_type_id,
			List<Integer> durations, String title, List<String> urls) {
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.durations = durations;
		this.title = title;
		this.urls = urls;
	}

	public String getContentId() {
		return this.content_id;
	}

	public String getContentTypeId() {
		return this.content_type_id;
	}

	public List<Integer> getDurations() {
		return this.durations;
	}

	public List<Integer> getHQdurations() {
		return this.HQdurations;
	}

	public List<String> getHQurls() {
		return this.HQurls;
	}

	public int getOrder() {
		return this.order;
	}

	public String getPic_url() {
		return this.pic_url;
	}

	public int getPosition() {
		return this.position;
	}

	public String getTitle() {
		return this.title;
	}

	public int getTotalorder() {
		return this.totalorder;
	}

	public List<String> getUrls() {
		return this.urls;
	}

	public boolean isPlayback() {
		return this.playback;
	}

	public void setContentId(String paramString) {
		this.content_id = paramString;
	}

	public void setContentTypeId(String paramString) {
		this.content_type_id = paramString;
	}

	public void setDudations(List<Integer> paramList) {
		this.durations = paramList;
	}

	public void setHQdurations(List<Integer> paramList) {
		this.HQdurations = paramList;
	}

	public void setHQurls(List<String> paramList) {
		this.HQurls = paramList;
	}

	public void setOrder(int paramInt) {
		this.order = paramInt;
	}

	public void setPic_url(String paramString) {
		this.pic_url = paramString;
	}

	public void setPlayback(boolean paramBoolean) {
		this.playback = paramBoolean;
	}

	public void setPosition(int paramInt) {
		this.position = paramInt;
	}

	public void setTitle(String paramString) {
		this.title = paramString;
	}

	public void setTotalorder(int paramInt) {
		this.totalorder = paramInt;
	}

	public void setUrls(List paramList) {
		this.urls = paramList;
	}
}