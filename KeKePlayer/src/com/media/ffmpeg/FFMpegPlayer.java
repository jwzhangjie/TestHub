package com.media.ffmpeg;

import java.io.IOException;
import java.lang.ref.WeakReference;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.Surface;
import android.view.SurfaceHolder;

public class FFMpegPlayer extends MediaPlayer {
	private static final int MEDIA_BUFFERING_UPDATE = 3;
	private static final int MEDIA_ERROR = 100;
	public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
	public static final int MEDIA_ERROR_SERVER_DIED = 100;
	public static final int MEDIA_ERROR_UNKNOWN = 1;
	private static final int MEDIA_INFO = 200;
	public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
	public static final int MEDIA_INFO_FRAMERATE_AUDIO = 901;
	public static final int MEDIA_INFO_FRAMERATE_VIDEO = 900;
	public static final int MEDIA_INFO_METADATA_UPDATE = 802;
	public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
	public static final int MEDIA_INFO_UNKNOWN = 1;
	public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
	private static final int MEDIA_NOP = 0;
	private static final int MEDIA_PLAYBACK_COMPLETE = 2;
	private static final int MEDIA_PREPARED = 1;
	private static final int MEDIA_SEEK_COMPLETE = 4;
	private static final int MEDIA_SET_VIDEO_SIZE = 5;
	private static final String TAG = "FFMpegPlayer";
	private static Bitmap mBitmap;
	private static Rect mRect = null;
	private EventHandler mEventHandler;
	private int mNativeContext;
	private int mNativeData = 0;
	private MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
	private MediaPlayer.OnCompletionListener mOnCompletionListener;
	private MediaPlayer.OnErrorListener mOnErrorListener;
	private MediaPlayer.OnInfoListener mOnInfoListener;
	private MediaPlayer.OnPreparedListener mOnPreparedListener;
	private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
	private MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
	private boolean mScreenOnWhilePlaying;
	private boolean mStayAwake;
	private Surface mSurface;
	private SurfaceHolder mSurfaceHolder;
	private AudioTrack mTrack;
	private PowerManager.WakeLock mWakeLock = null;

	public FFMpegPlayer() {
		Looper looper = Looper.myLooper();

	}

	private static native void _nativeDraw(Bitmap bitmap);

	private native void _pause() throws IllegalStateException;

	private native void _release();

	private native void _reset();

	private native void _setAudioTrack(AudioTrack paramAudioTrack)
			throws IOException;

	private native void _setVideoSurface(Bitmap paramBitmap) throws IOException;

	private native void _start() throws IllegalStateException;

	private native void _stop() throws IllegalStateException;

	public static void initAudioTrack(Object paramObject, int sampleRateInHz,
			int channelConfig) throws IOException {
		FFMpegPlayer ffMpegPlayer = (FFMpegPlayer) ((WeakReference) paramObject)
				.get();
		if (ffMpegPlayer == null) {
			return;
		}
		int i = AudioTrack.getMinBufferSize(sampleRateInHz, channelConfig, 2);
		ffMpegPlayer.mTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
				sampleRateInHz, channelConfig, 2, i, 1);
		ffMpegPlayer.mTrack.play();
	}

	private final native void native_finalize();

	private static final native void native_init() throws RuntimeException;

	private final native void native_setup(Object object);

	private native int native_suspend_resume(boolean paramBoolean);

	public native int getCurrentPosition();

	public native int getDuration();

	public native int getVideoHeight();

	public native int getVideoWidth();

	public native boolean isPlaying();

	class EventHandler extends Handler {

	}
}
