package com.ydhl.smartchildren;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;

import com.example.smartchildren.R;
import com.ydhl.bean.PlayTime;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.myview.StreamView;
import com.ydhl.utils.DBManager;
import com.ydhl.utils.MyHttpUtils;

public class WordGameActivity extends BaseActivity
{
	private StreamView streamView;
	private String begin_time;
	private String end_time;
	private String socre;
	private DBManager dbManager;
	private boolean isFirstPlay = true;
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;

	@Override
	public void setContentView()
	{
		
		setContentView(R.layout.activity_word_game);
		
	}

	@Override
	public void initView()
	{
		streamView = (StreamView) findViewById(R.id.stream);
		dbManager = new DBManager(this,application.getUserName());
		SimpleDateFormat df = new SimpleDateFormat("HH.mm");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		begin_time = df.format(new Date());
		sharedPreferences = getSharedPreferences("isFirst", MODE_PRIVATE);
		isFirstPlay = sharedPreferences.getBoolean("isFirstw", true);
		
	}

	@Override
	public void initListeners()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initData()
	{
		
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		SimpleDateFormat df = new SimpleDateFormat("HH.mm");//设置日期格式
		System.out.println(df.format(new Date())+"aa");// new Date()为获取当前系统时间
		end_time = df.format(new Date());
		socre = Integer.toString(streamView.getScore());
		MyHttpUtils myHttpUtils = new MyHttpUtils("POST"
				, new PlayTime(begin_time+"~"+end_time,
							   null, 
							   null,
							   streamView.getScore()+"", 
							   null,
							   null),
							   "http://zcs.svnt.ml/rzet/Client_Interface.php", 
							   new MyHttpListener()
							{
								
								@Override
								public void onSuccess(String content)
								{
									System.out.println(content);
									
								}
								
								@Override
								public void onFailed(String content)
								{
									System.exit(0);
									
								}
							});
		myHttpUtils.DoRequestByHttpUrlConnection();
		if (isFirstPlay)
		{
			ContentValues contentValues = new ContentValues();
			contentValues.put("high", streamView.getScore());
			contentValues.put("low", streamView.getScore());
			dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"WordGame"});
			editor = sharedPreferences.edit();
			editor.putBoolean("isFirstw", false);
			editor.commit();
		}else {
			int oldHighscore = 0;
			int oldLowscore = 0;
			Cursor cursor = dbManager.query(application.getUserName(), null, "_id = 'WordGame'", null, null,
					null, null, null);
			while (cursor.moveToNext())
			{
				oldHighscore = cursor.getInt(cursor.getColumnIndex("high"));
				oldLowscore = cursor.getInt(cursor.getColumnIndex("low"));
			}
			if (oldHighscore <= streamView.getScore())
			{
				ContentValues contentValues = new ContentValues();
				contentValues.put("high", streamView.getScore());
				contentValues.put("low", oldLowscore);
				dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"WordGame"});
			} else if (oldLowscore >= streamView.getScore())
			{
				ContentValues contentValues = new ContentValues();
				contentValues.put("high", oldHighscore);
				contentValues.put("low", streamView.getScore());
				dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"WordGame"});
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
