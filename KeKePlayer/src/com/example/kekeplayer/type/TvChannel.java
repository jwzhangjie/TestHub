package com.example.kekeplayer.type;

import java.io.Serializable;

public class TvChannel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String channelid;
	private String channellogo;
	private String channelname;
	private String channelurl;
	private String program_name;
	private int viewback;
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getChannellogo() {
		return channellogo;
	}
	public void setChannellogo(String channellogo) {
		this.channellogo = channellogo;
	}
	public String getChannelname() {
		return channelname;
	}
	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}
	public String getChannelurl() {
		return channelurl;
	}
	public void setChannelurl(String channelurl) {
		this.channelurl = channelurl;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	public int getViewback() {
		return viewback;
	}
	public void setViewback(int viewback) {
		this.viewback = viewback;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "channelid:"+channelid+" channelname :"+channelname+"channelurl :"+channelurl;
	}
	
}
