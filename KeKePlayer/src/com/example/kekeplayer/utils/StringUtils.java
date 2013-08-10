package com.example.kekeplayer.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringUtils {

	public static String getStringUTF8(String paramString) throws UnsupportedEncodingException{
		return URLEncoder.encode(paramString, "UTF-8");
	}
	
	public static boolean isBlank(String paramString){
		return false;
//		int i = 1;
//		int j;
//		if (paramString != null) {
//			j = paramString.length();
//			if (j != 0) {
//				int k = 0;
//				
//			}
//		}
		
	}
}












