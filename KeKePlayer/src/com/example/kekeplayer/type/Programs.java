package com.example.kekeplayer.type;

import java.io.Serializable;

public class Programs implements Serializable{

	private static final long serialVersionUID = -3761563035142486560L;
	private String playback;
	private String realTime;
	private String showtime;
	private String title;
	public String getPlayback() {
		return playback;
	}
	public void setPlayback(String playback) {
		this.playback = playback;
	}
	public String getRealTime() {
		return realTime;
	}
	public void setRealTime(String realTime) {
		this.realTime = realTime;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
