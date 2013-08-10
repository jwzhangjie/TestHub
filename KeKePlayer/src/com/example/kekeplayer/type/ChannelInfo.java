package com.example.kekeplayer.type;

import java.io.Serializable;
import java.util.List;

public class ChannelInfo implements Serializable {

	private static final long serialVersionUID = 3673779883827332825L;
	private String channelid;
	private String channelname;
	private List<Secondclass> secondclasses;

	public ChannelInfo() {
	}

	public ChannelInfo(String paramString1, String paramString2) {
		this.channelid = paramString1;
		this.channelname = paramString2;
	}

	public String getChannelid() {
		return this.channelid;
	}

	public String getChannelname() {
		return this.channelname;
	}

	public List<Secondclass> getSecondclasses() {
		return this.secondclasses;
	}

	public void setChannelid(String paramString) {
		this.channelid = paramString;
	}

	public void setChannelname(String paramString) {
		this.channelname = paramString;
	}

	public void setSecondclasses(List<Secondclass> paramList) {
		this.secondclasses = paramList;
	}
}