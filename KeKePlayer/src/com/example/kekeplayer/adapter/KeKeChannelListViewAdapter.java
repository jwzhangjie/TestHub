package com.example.kekeplayer.adapter;

import java.util.List;

import com.example.kekeplayer.R;
import com.example.kekeplayer.type.TvChannel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class KeKeChannelListViewAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private Context mContext;
//	private Bitmap mDefaultCover;
	private List<TvChannel> mTvChannelList;
	
	
	public KeKeChannelListViewAdapter(Context mContext) {
		super();
		this.mContext = mContext;
		inflater = LayoutInflater.from(mContext);
//		Resources localResources = mContext.getResources();
//		BitmapFactory.Options localOptions = getBitmapOption();
//		mDefaultCover = BitmapFactory.decodeResource(localResources, R.drawable.ic_launcher, localOptions);
		
	}

	private BitmapFactory.Options getBitmapOption()
	  {
	    BitmapFactory.Options localOptions = new BitmapFactory.Options();
	    localOptions.inScaled = true;
	    localOptions.inDensity = 160;
	    int i = this.mContext.getResources().getDisplayMetrics().densityDpi;
	    localOptions.inTargetDensity = i;
	    return localOptions;
	  }
	@Override
	public int getCount() {
		if (mTvChannelList != null) {
			return mTvChannelList.size();
		}else {
			return 0;
		}
		
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0L;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final TvChannel localTvChannel = (TvChannel)mTvChannelList.get(position);
		HolderView holderView;
		if (convertView == null) {
			holderView = new HolderView();
			convertView = inflater.inflate(R.layout.tv_list_item, null);
			holderView.logo = (ImageView)convertView.findViewById(R.id.logo);
			holderView.tv_title = (TextView)convertView.findViewById(R.id.tv_title);
			holderView.content = (TextView)convertView.findViewById(R.id.content);
			holderView.playBtn = (ImageView)convertView.findViewById(R.id.play_btn);
			convertView.setTag(holderView);
		}else {
			holderView = (HolderView)convertView.getTag();
		}
		holderView.tv_title.setText(localTvChannel.getChannelname());
		holderView.content.setText(localTvChannel.getProgram_name());
		return convertView;
	}

	class HolderView {
		ImageView logo;
		TextView tv_title;
		TextView content;
		ImageView playBtn;
	}
	
	public List<TvChannel> getmTvChanenList()
	{
		return mTvChannelList;
	}
	public void notifyDataSetChanged(List<TvChannel> paramList)
	  {
	    if (paramList == null)
	      return;
	    this.mTvChannelList = paramList;
	    notifyDataSetChanged();
	  }
	
}