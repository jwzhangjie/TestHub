package com.example.kekeplayer.adapter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.kekeplayer.JieVideoPlayer;
import com.example.kekeplayer.KeKeApp;
import com.example.kekeplayer.R;
import com.example.kekeplayer.dao.PlayBackDAO;
import com.example.kekeplayer.type.PlayBackInfo;
import com.example.kekeplayer.type.Programs;
import com.example.kekeplayer.type.TvChannel;
import com.example.kekeplayer.utils.DateUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TvProgramAdapt extends BaseAdapter {

	private Activity mContext;
	private TvChannel mCurTvChannel;
	private SimpleDateFormat mFormat;
	private LayoutInflater mLayoutInflater;
	public List<Programs> mPrograms;

	@SuppressLint("SimpleDateFormat")
	public TvProgramAdapt(Activity paramActivity, TvChannel paramTvChannel)
	{
		mFormat = new SimpleDateFormat("HH:mm");
		mContext = paramActivity;
		mCurTvChannel = paramTvChannel;
		mLayoutInflater = (LayoutInflater)mContext.getSystemService("layout_inflater"); 
	}
	/**
	 * 
	 * @param paramString 视频的播放时间(不是长度)
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	private Boolean nowIsAfterBoolean(String paramString){
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
		Boolean localBoolean = false;
		try {
			Date localDate1 = localSimpleDateFormat.parse(paramString);
			Date localDate2 = KeKeApp.getNow();
			String str = localSimpleDateFormat.format(localDate2);
			localBoolean  = Boolean.valueOf(localSimpleDateFormat.parse(str).after(localDate1));
		} catch (Exception e) {
		}
		return localBoolean;
	}
	//直播的播放状态
	private void playingLive(ViewHolder viewHolder){
		viewHolder.program_status.setText(R.string.tv_time_playnow);
		viewHolder.program_status.setBackgroundResource(R.drawable.transparent_background);
		viewHolder.program_time.setTextColor(mContext.getResources().getColor(R.color.solid_red));
		viewHolder.program_name.setTextColor(mContext.getResources().getColor(R.color.solid_red));
		viewHolder.program_time.setTextColor(mContext.getResources().getColor(R.color.solid_red));
		
	}
	
	public void playBack(final Activity activity, final Programs programs){
		new Thread(new Runnable() {
			@Override
			public void run() {
				String playBack = programs.getPlayback();
				String title = programs.getTitle();
				try {
					PlayBackDAO localPlayBackDAO = new PlayBackDAO();
					List<PlayBackInfo> list = localPlayBackDAO.getPlayBackList(playBack);
					Intent intent = new Intent(activity, JieVideoPlayer.class);
					Bundle bundle = new Bundle();
					bundle.putSerializable("PlayBackInfo", (Serializable) list);
					intent.putExtras(bundle);
					activity.startActivity(intent); 
				} catch (Exception e) {
				}
			}
		}).start();
	}
	private String switchDate(String parmString){
		String string = null;
		try {
			Date date = DateUtils.sdf7.parse(parmString);
			string = DateUtils.sdf5.format(date);
		} catch (Exception e) {
		}
		return string;
	}
	
	public class PlayLiveClick implements View.OnClickListener{

		@Override
		public void onClick(View v) {
//			String channelName = 
		}
		
	};
	@Override
	public int getCount() {
		if (mPrograms != null) {
			return mPrograms.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return mPrograms.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Programs programs = (Programs)mPrograms.get(position);
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mLayoutInflater.inflate(R.layout.tv_play_program_item, null);
			viewHolder.program_name = (TextView)convertView.findViewById(R.id.program_name);
			viewHolder.program_time = (TextView)convertView.findViewById(R.id.program_time);
			viewHolder.program_status = (TextView)convertView.findViewById(R.id.program_status);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		viewHolder.program_name.setText(programs.getTitle());
		viewHolder.program_time.setText(programs.getShowtime());
		viewHolder.program_status.setText("回看");
		return convertView;
	}
	public void notifyDataSetChanged(List<Programs> paramList)
	  {
	    if ((paramList == null) || (paramList.size() <= 0))
	      return;
	    this.mPrograms = paramList;
	    notifyDataSetChanged();
	  }
	class ViewHolder
	  {
	    TextView program_name;
	    TextView program_status;
	    TextView program_time;
	  }
}
