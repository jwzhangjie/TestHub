package com.example.kekeplayer.parse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.kekeplayer.type.Group;

public abstract interface Parser<T> {
	public abstract T parse(JSONObject paramJSONObject) throws JSONException;

	public abstract Group parse(JSONArray paramJSONArray) throws JSONException;
}
