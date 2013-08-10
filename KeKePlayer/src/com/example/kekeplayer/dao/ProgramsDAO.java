package com.example.kekeplayer.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.kekeplayer.KeKeApp;
import com.example.kekeplayer.KeKeSetting;
import com.example.kekeplayer.parse.josn.ProgramsParse;
import com.example.kekeplayer.type.Programs;
import com.example.kekeplayer.utils.JSONUtils;
import com.example.kekeplayer.utils.https.HttpApiImpl;

public class ProgramsDAO implements KeKeSetting{
	
	public List<Programs> getPrograms(String channelid, String currentdate){
		List<Programs> list = new ArrayList<Programs>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("http://api.cbox.cntv.cn/api/").append("program_list").append("?pid=").append("GC3ueQnxE8PrWVRkmaUvsJHZqNiXpgdz").append("&version=");
		buffer.append(KeKeApp.getVersion()).append("&channelid=").append(channelid).append("&currentdate=").append(currentdate);
		String url = buffer.toString();
		try {
			String json_result = new HttpApiImpl().doHttpGet(url);
			JSONObject result = JSONUtils.getBodyAndCheckHeader(url, json_result);
			JSONArray pragramsArray = result.getJSONArray("programs");
			ProgramsParse programsParse = new ProgramsParse(currentdate);
			int size = pragramsArray.length();
			for (int i = 0; i < size; i++) {
				list.add(programsParse.parse(pragramsArray.getJSONObject(i)));
			}
		} catch (Exception e) {
		}
		return list;
	}
}













