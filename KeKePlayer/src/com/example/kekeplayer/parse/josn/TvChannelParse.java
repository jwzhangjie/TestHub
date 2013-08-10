package com.example.kekeplayer.parse.josn;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.kekeplayer.type.TvChannel;

public class TvChannelParse {
	public TvChannel parse(JSONObject paramJSONObject) throws JSONException {
		TvChannel localTvChannel = new TvChannel();
		if (paramJSONObject.has("viewback")) {
			int i = paramJSONObject.getInt("viewback");
			localTvChannel.setViewback(i);
		}
		if (paramJSONObject.has("channelname")) {
			String str1 = paramJSONObject.getString("channelname");
			localTvChannel.setChannelname(str1);
		}
		if (paramJSONObject.has("channellogo")) {
			String str2 = paramJSONObject.getString("channellogo");
			localTvChannel.setChannellogo(str2);
		}
		if (paramJSONObject.has("channelurl")) {
			String str3 = paramJSONObject.getString("channelurl");
			localTvChannel.setChannelurl(str3);
		}
		if (paramJSONObject.has("channelid")) {
			String str4 = paramJSONObject.getString("channelid");
			localTvChannel.setChannelid(str4);
		}
		if (paramJSONObject.has("program_name")) {
			String str5 = paramJSONObject.getString("program_name");
			localTvChannel.setProgram_name(str5);
		}
		System.out.println(localTvChannel.getChannelname());
		return localTvChannel;
	}
}