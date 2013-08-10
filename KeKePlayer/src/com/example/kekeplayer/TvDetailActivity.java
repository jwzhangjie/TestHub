package com.example.kekeplayer;

import java.util.List;

import com.example.kekeplayer.adapter.TvProgramAdapt;
import com.example.kekeplayer.dao.ProgramsDAO;
import com.example.kekeplayer.type.Programs;
import com.example.kekeplayer.type.TvChannel;
import com.example.kekeplayer.utils.KeKeUtils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TvDetailActivity extends Activity implements OnItemClickListener, OnCheckedChangeListener, OnClickListener{
	public TvChannel mCurTvChannel;
	public static int monclicweekday = 1;
	protected final int FIRST_ID =  436;
	private List<Programs> mCurProgramList;
	private List<String> mCurWeeKDate;
	private int mCurWeek;
	private ListView mTvDetailListView;
	private TvProgramAdapt mTvProgramAdapt;
	private RadioGroup week_group;

	
	public TvDetailActivity() {
		mCurWeek = 1;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_tv_detail_activity);
		initTime();
		initLayout();
	}

	private Dialog showLoadingDialog(){
		ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage("加载中....");
		progressDialog.setCancelable(true);
		return progressDialog;
	}
	
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = super.onCreateDialog(id);
		dialog = showLoadingDialog();
		return dialog;
	}

	public void initLayout(){
		Bundle bundle = getIntent().getExtras();
		mCurTvChannel = (TvChannel) bundle.getSerializable("TvChannel");
		mTvDetailListView = (ListView)findViewById(R.id.tv_detail_list);
		mTvProgramAdapt = new TvProgramAdapt(this, mCurTvChannel);
		mTvDetailListView.setAdapter(mTvProgramAdapt);
		mTvDetailListView.setOnItemClickListener(this);
		week_group = (RadioGroup)findViewById(R.id.week_group);
		week_group.setOnCheckedChangeListener(this);
		int i = KeKeUtils.getTodayWeek()-1;
		((RadioButton)week_group.getChildAt(i)).setChecked(true);
		findViewById(R.id.back_btn).setOnClickListener(this);
		
	}
	public void initTime() {
		mCurWeek = KeKeUtils.getTodayWeek();
		mCurWeeKDate = KeKeUtils.getCurWeekOfDate(mCurWeek);
	}
	private void setProgram(String paramString1, String paramString2){
		InitData localInitData = new InitData(paramString1, paramString2);
	    Void[] arrayOfVoid = new Void[0];
	    localInitData.execute(arrayOfVoid);
	}
	class InitData extends AsyncTask<Void, Void, Void>
	{
		private String channelID;
	    private String dateTime;
	    
		public InitData(String channelID, String dateTime) {
			super();
			this.channelID = channelID;
			this.dateTime = dateTime;
		}

		@Override
		protected Void doInBackground(Void... paramArrayOfVoid) {
			try {
				ProgramsDAO programsDAO = new ProgramsDAO();
				mCurProgramList = programsDAO.getPrograms(channelID, dateTime);
			} catch (Exception e) {
			
			}
			return null;
		}

		@SuppressWarnings("deprecation")
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			TvDetailActivity.this.showDialog(0);
		}

		@SuppressWarnings("deprecation")
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			mTvProgramAdapt.notifyDataSetChanged(mCurProgramList);
			dismissDialog(0);
		}
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
//		Intent intent = new Intent();
//		intent.setClass(TvDetailActivity.this, JieVideoPlayer.class);
//		Bundle bundle = new Bundle();
//		bundle.putSerializable("Channel", mCurTvChannel);
//		intent.putExtras(bundle);
//		startActivity(intent);
		mTvProgramAdapt.playBack(this, mTvProgramAdapt.mPrograms.get(position));
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (mCurWeeKDate == null) {
			return;
		}
		String dateTime ="";
		switch (checkedId) {
		case R.id.play_time_one:
			dateTime = mCurWeeKDate.get(0);
			monclicweekday = 1;
			break;
		case R.id.play_time_two:
			dateTime = mCurWeeKDate.get(1);
			monclicweekday = 2;
			break;
		case R.id.play_time_three:
			dateTime = mCurWeeKDate.get(2);
			monclicweekday = 3;
			break;
		case R.id.play_time_four:
			dateTime = mCurWeeKDate.get(3);
			monclicweekday = 4;
			break;
		case R.id.play_time_five:
			dateTime = mCurWeeKDate.get(4);
			monclicweekday = 5;
			break;
		case R.id.play_time_six:
			dateTime = mCurWeeKDate.get(5);
			monclicweekday = 6;
			break;
		case R.id.play_time_seven:
			dateTime = mCurWeeKDate.get(6);
			monclicweekday = 7;
			break;
		}
		String channelId = mCurTvChannel.getChannelid();
		setProgram(channelId, dateTime);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back_btn:
			this.finish();
			break;
		}
	}
}
