package com.example.kekeplayer.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;

import com.example.kekeplayer.KeKeSetting;
import com.example.kekeplayer.player.CMPlayer;

public class AppUtils implements KeKeSetting {
	private static String DEVICE_ID = null;
	private static final String TAG = "AppUtils";
	public static final int isEverytime_Tip = 1;
	public static final int isNotforever_Tip = 3;
	public static final int isOnlyonce_Tip = 2;
	private Handler handler;

	public static void PlayLiveVideo(Activity startActity, String playUrl){
		Intent intent = new Intent(startActity, CMPlayer.class);
		intent.putExtra("play_url", playUrl);
		startActity.startActivity(intent);
	}
	
	public static int getVersionCode(Context paramContext) {
		try {
			PackageManager localPackageManager = paramContext
					.getPackageManager();
			String str = paramContext.getPackageName();
			int i = localPackageManager.getPackageInfo(str, 0).versionCode;
			return i;
		} catch (Throwable localThrowable) {
			throw new RuntimeException(localThrowable);
		}
	}

	public static String getVersionName(Context paramContext) {
		try {
			PackageManager localPackageManager = paramContext
					.getPackageManager();
			String str1 = paramContext.getPackageName();
			String str2 = localPackageManager.getPackageInfo(str1, 0).versionName;
			return str2;
		} catch (Throwable localThrowable) {
			throw new RuntimeException(localThrowable);
		}
	}
}
