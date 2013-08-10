package com.example.kekeplayer.parse.josn;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.kekeplayer.type.MediaType;

public class MediaTypeParse {
	public MediaType parse(JSONObject paramJSONObject) throws JSONException {
		MediaType localMediaType = new MediaType();
		if (paramJSONObject.has("name")) {
			String str1 = paramJSONObject.getString("name");
			localMediaType.setName(str1);
		}
		if (paramJSONObject.has("mediatype")) {
			String str2 = paramJSONObject.getString("mediatype");
			localMediaType.setMediatype(str2);
		}
		Log.e("st", localMediaType.getMediatype()+":"+localMediaType.getName());
		return localMediaType;
	}
}