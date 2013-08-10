package com.example.kekeplayer.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.kekeplayer.parse.josn.PlayBackInfoParse;
import com.example.kekeplayer.type.PlayBackInfo;
import com.example.kekeplayer.utils.https.HttpApiImpl;

public class PlayBackDAO {
	public List<PlayBackInfo> getPlayBackList(String url){
		List<PlayBackInfo> list = new ArrayList<PlayBackInfo>();
		try {
			String result_json = new HttpApiImpl().doHttpGet(url);
			 PlayBackInfoParse backInfoParse = new PlayBackInfoParse();
			JSONObject result_Obj = new JSONObject(result_json);
			JSONArray chapters = result_Obj.getJSONObject("video").getJSONArray("chapters");
			int size = chapters.length();
			for (int i = 0; i < size; i++) {
				list.add(backInfoParse.parse(chapters.getJSONObject(i)));
			}
		} catch (Exception e) {
		}
		return list;
	}
}














