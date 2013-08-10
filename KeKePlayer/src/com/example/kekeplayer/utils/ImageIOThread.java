package com.example.kekeplayer.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class ImageIOThread extends Handler{
	 public static final int MSG_SAVE_BITMAP = 0;
	private static final String SUFFIX_JPEG = ".jpeg";
	private static final String SUFFIX_JPG = ".jpg";
	private static final String SUFFIX_PNG = ".png";
	private static final String THREAD_NAME = "ImageIOThread";
	private static HandlerThread mCacheThread;
	private static ImageIOThread mImageIOThread;
	private String mImagePath = "/mnt/sdcard/KeKePlayer/temp";
	
	private ImageIOThread(Looper paramLooper){
		super(paramLooper);
	}
	
	public static ImageIOThread getInstance(){
		if (mCacheThread == null) {
			mCacheThread = new HandlerThread("ImageIOThread");
			mCacheThread.start();
		}
		if (mImageIOThread == null)
	    {
	      Looper localLooper = mCacheThread.getLooper();
	      mImageIOThread = new ImageIOThread(localLooper);
	    }
	    return mImageIOThread;
	}
	
	public void stopImageIO()
	  {
	    removeCallbacksAndMessages(null);
	    try
	    {
	      if (mCacheThread != null)
	        mCacheThread.join();
	      mCacheThread = null;
	      mImageIOThread = null;
	      return;
	    }
	    catch (InterruptedException localInterruptedException)
	    {
	      localInterruptedException.printStackTrace();
	    }
	  }
	
	public class CacheImage{
		String fileName;
		public CacheImage(String arg2){
			
		}
	}

}
