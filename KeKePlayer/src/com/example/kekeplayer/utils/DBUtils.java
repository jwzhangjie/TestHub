package com.example.kekeplayer.utils;

import android.content.Context;

import com.example.kekeplayer.db.DBHelper;
import com.example.kekeplayer.type.History;

public class DBUtils {
	private static DBHelper mDBHelper;
	private String TAG;
	private Context mContext;
	
	public DBUtils(Context paramContext){
		TAG = super.getClass().getSimpleName();
		mContext = paramContext;
		mDBHelper = new DBHelper(paramContext);
	}
	private void insertHistory(History history){
		
	}
	
}
















