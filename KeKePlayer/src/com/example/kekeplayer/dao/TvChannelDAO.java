package com.example.kekeplayer.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.kekeplayer.parse.josn.TvChannelParse;
import com.example.kekeplayer.type.TvChannel;
import com.example.kekeplayer.utils.JSONUtils;
import com.example.kekeplayer.utils.https.HttpApiImpl;

public class TvChannelDAO {
	public List<TvChannel> getTvChannel(String paramString){
		List<TvChannel> list = new ArrayList<TvChannel>();
		StringBuilder localBuilder = new StringBuilder();
		localBuilder.append("http://api.cbox.cntv.cn/api/").append("channel_list").append("?pid=").append("GC3ueQnxE8PrWVRkmaUvsJHZqNiXpgdz").append("&mediatype=").append(paramString);
		String url = localBuilder.toString();
		String result = new HttpApiImpl().doHttpGet(url);
		try {
			
			JSONObject resultJson = JSONUtils.getBodyAndCheckHeader(url, result);
			TvChannelParse localTvChannelParse = new TvChannelParse();
			JSONArray localJSONArray = resultJson.getJSONArray("channels");
			int size = localJSONArray.length();
			for (int i = 0; i < size; i++) {
				JSONObject jObject = localJSONArray.getJSONObject(i);
				list.add(localTvChannelParse.parse(jObject));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}
}
