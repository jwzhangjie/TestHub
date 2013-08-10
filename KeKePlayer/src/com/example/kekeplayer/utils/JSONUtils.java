package com.example.kekeplayer.utils;

import org.json.JSONObject;

import com.example.kekeplayer.KeKeApp;

public class JSONUtils {
	public static JSONObject getBodyAndCheckHeader(String url, String returnResutl){
		JSONObject result = null;
		try {
			JSONObject main = new JSONObject(returnResutl);
			JSONObject status = main.getJSONObject("status");
			String date = status.getString("now");
			KeKeApp.setNow(DateUtils.str2Date(date));
			result = main.getJSONObject("result");
		} catch (Exception e) {
		}
		return result;
	}
}
















