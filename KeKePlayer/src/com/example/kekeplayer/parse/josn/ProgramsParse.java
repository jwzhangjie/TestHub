package com.example.kekeplayer.parse.josn;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.kekeplayer.type.Programs;

public class ProgramsParse {
	String realTime;

	public ProgramsParse(String paramString) {
		this.realTime = paramString;
	}

	public Programs parse(JSONObject paramJSONObject) throws JSONException {
		Programs localPrograms = new Programs();
		if (paramJSONObject.has("title")) {
			String str1 = paramJSONObject.getString("title");
			localPrograms.setTitle(str1);
		}
		if (paramJSONObject.has("showtime")) {
			String str2 = paramJSONObject.getString("showtime");
			localPrograms.setShowtime(str2);
		}
		if (paramJSONObject.has("playback")) {
			String str3 = paramJSONObject.getString("playback");
			localPrograms.setPlayback(str3);
		}
		String str4 = this.realTime;
		localPrograms.setRealTime(str4);
		Log.e("test", localPrograms.getShowtime()+"Programs:"+localPrograms.getTitle());
		return localPrograms;
	}
}