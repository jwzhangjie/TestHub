package com.example.kekeplayer;

import java.util.ArrayList;
import java.util.List;

import com.example.kekeplayer.adapter.KeKeChannelListViewAdapter;
import com.example.kekeplayer.dao.MediaTypeDAO;
import com.example.kekeplayer.dao.TvChannelDAO;
import com.example.kekeplayer.type.MediaType;
import com.example.kekeplayer.type.TvChannel;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class KeKePlayer extends Activity implements OnCheckedChangeListener{

	private ListView KeKe_Channel_List = null;
	private List<MediaType> mMediaTypesList;
	private LayoutInflater mLayoutInflater;
	private KeKeChannelListViewAdapter mTvAdapter;
	private List<List<TvChannel>> mTvChanenList;
	private ArrayList<Integer> radioList;
	private RadioGroup tv_all;
	private int mCurRadioIndex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tv_activity);
		mLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
		initLayout();
		InitData localInitData = new InitData();
	    Void[] arrayOfVoid = new Void[0];
	    AsyncTask localAsyncTask = localInitData.execute(arrayOfVoid);
	}
	public void initLayout(){
		mTvChanenList = new ArrayList<List<TvChannel>>();
		radioList = new ArrayList<Integer>();
		mCurRadioIndex = -1;
		KeKe_Channel_List = (ListView)findViewById(R.id.tv_listView);
		mTvAdapter = new KeKeChannelListViewAdapter(this);
		KeKe_Channel_List.setAdapter(mTvAdapter);
		KeKe_Channel_List.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				TvChannel tvChannel = mTvChanenList.get(mCurRadioIndex).get(position);
				bundle.putSerializable("TvChannel", tvChannel);
				intent.putExtras(bundle);
				intent.setClass(KeKePlayer.this, TvDetailActivity.class);
				startActivity(intent);
			}
		});
		tv_all = (RadioGroup)findViewById(R.id.tv_all);
		tv_all.setOnCheckedChangeListener(this);
	}
	private void addButtonByNet(){
		int i = mMediaTypesList.size();
		for (int j = 0; j < i; j++) {
			 RadioButton localRadioButton = (RadioButton)this.mLayoutInflater.inflate(R.layout.page_tv_radio_btn, null);
			 String name = mMediaTypesList.get(j).getName();
			 localRadioButton.setText(name);
			 int k = j + 436;
			 localRadioButton.setId(k);
			 radioList.add(k);
			 tv_all.addView(localRadioButton);
			 ((ViewGroup.MarginLayoutParams)localRadioButton.getLayoutParams()).rightMargin = 10;
		}
	}
	private Dialog showLoadingDialog()
	  {
	    ProgressDialog localProgressDialog = new ProgressDialog(this);
	    localProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	    localProgressDialog.setMessage("加载中....");
	    localProgressDialog.setCancelable(true);
	    return localProgressDialog;
	  }
	
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = super.onCreateDialog(id);
		dialog = showLoadingDialog();
		return dialog;
	}


	class InitData extends AsyncTask<Void, Void, Void>
	  {
		InitData()
	    {
	    }
		@Override
		protected Void doInBackground(Void... paramArrayOfVoid) {
			try {
				MediaTypeDAO mediaTypeDAO = new MediaTypeDAO();
				mMediaTypesList = mediaTypeDAO.getMediaTypes();
				TvChannelDAO localTvChannelDAO = new TvChannelDAO();
				int size = mMediaTypesList.size();
				for (int i = 0; i < size; i++) {
					String stringType = ((MediaType)mMediaTypesList.get(i)).getMediatype();
					List<TvChannel> localList2 = localTvChannelDAO.getTvChannel(stringType);
					mTvChanenList.add(localList2);
				}
			} catch (Exception e) {
			}
			return null;
		}
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			showDialog(0);
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			addButtonByNet();
			((RadioButton)tv_all.getChildAt(0)).setChecked(true);
			dismissDialog(0);
		}
	  }
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		Integer newInteger = Integer.valueOf(checkedId);
		int i = radioList.indexOf(newInteger);
		if (i != mCurRadioIndex) {
			mCurRadioIndex = i;
			List<TvChannel> loList = (List<TvChannel>)mTvChanenList.get(i);
			mTvAdapter.notifyDataSetChanged(loList);
		}
	}
}