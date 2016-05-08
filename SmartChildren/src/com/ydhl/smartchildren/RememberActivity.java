package com.ydhl.smartchildren;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.example.smartchildren.R.menu;
import com.ydhl.bean.PlayTime;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.mylog.MyLog;
import com.ydhl.myview.ReGameView;
import com.ydhl.utils.DBManager;
import com.ydhl.utils.MyHttpUtils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RememberActivity extends BaseActivity implements OnClickListener
{
	private ReGameView reGameView;
	private Button button01;
	private Button button02;
	private  Button button03;
	private boolean visible;
	private Animation upAnimationIn;
	private Animation upAnimationInCallback;
	private Animation downAnimationIn;
	private Animation downAnimationInCallback;
	private Animation outAnimation;
	private String begin_time;
	private String end_time;
	private DBManager dbManager;
	private boolean isFirstPlay = true;
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_remember);
		reGameView = (ReGameView) findViewById(R.id.reGameView1);
		button01 = (Button) findViewById(R.id.button1);
		button02 = (Button) findViewById(R.id.button2);
		button03 = (Button) findViewById(R.id.button3);
		button02.setText("训练模式");
		button03.setText("培养模式");
		
	}

	@Override
	public void initView()
	{
		dbManager = new DBManager(this,application.getUserName());
		downAnimationIn = AnimationUtils.loadAnimation(this, R.anim.down_left_in);
		downAnimationInCallback = AnimationUtils.loadAnimation(this, R.anim.down_left_in_callback);
		upAnimationIn = AnimationUtils.loadAnimation(this, R.anim.up_left_in);
		upAnimationInCallback = AnimationUtils.loadAnimation(this, R.anim.up_left_in_callback);
		outAnimation = AnimationUtils.loadAnimation(this, R.anim.button_out);
		sharedPreferences = getSharedPreferences("isFirst", MODE_PRIVATE);
		isFirstPlay = sharedPreferences.getBoolean("isFirstr", true);
		upAnimationIn.setAnimationListener(new AnimationListener()
		{
			
			@Override
			public void onAnimationStart(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation)
			{
				button02.startAnimation(upAnimationInCallback);
				
			}
		});
		downAnimationIn.setAnimationListener(new AnimationListener()
		{
			
			@Override
			public void onAnimationStart(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation)
			{
				button03.startAnimation(downAnimationInCallback);
				
			}
		});
	}

	@Override
	public void initListeners()
	{
		button01.setOnClickListener(this);
		button02.setOnClickListener(this);
		button03.setOnClickListener(this);
	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
SimpleDateFormat df = new SimpleDateFormat("HH.mm");//设置日期格式
		
		end_time = df.format(new Date());
		
		MyHttpUtils myHttpUtils = new MyHttpUtils("POST"
				, new PlayTime(begin_time+"~"+end_time,
							   null, 
							   null,
							   reGameView.step+"", 
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
		myHttpUtils.DoRequestByHttpUrlConnection();System.out.println(isFirstPlay);
		if (isFirstPlay)
		{
			ContentValues contentValues = new ContentValues();
			contentValues.put("high", reGameView.step);		
			contentValues.put("low", reGameView.step);
			dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"RememberGame"});
			editor = sharedPreferences.edit();
			editor.putBoolean("isFirstr", false);
			editor.commit();
		}else {
			int oldHighscore = 0;
			int oldLowscore = 0;
			Cursor cursor = dbManager.query(application.getUserName(), null, "_id = 'RememberGame'", null, null,
					null, null, null);
			while (cursor.moveToNext())
			{
				oldHighscore = cursor.getInt(cursor.getColumnIndex("high"));
				oldLowscore = cursor.getInt(cursor.getColumnIndex("low"));
			}
			MyLog.t(oldHighscore);
			MyLog.t(oldLowscore);
			if (oldHighscore <= reGameView.step)
			{
				ContentValues contentValues = new ContentValues();
				contentValues.put("high", reGameView.step);
				contentValues.put("low", oldLowscore);
				dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"RememberGame"});
			} else if (oldLowscore >= reGameView.step)
			{
				ContentValues contentValues = new ContentValues();
				contentValues.put("high", oldHighscore);
				contentValues.put("low", reGameView.step);
				dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"RememberGame"});
			}
		}
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			ReGameView.step = 0;
			finish();
			overridePendingTransition(R.anim.game_back, R.anim.game_go);
		}
		return false;
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.button1:
			if (!visible)
			{
				button02.setVisibility(View.VISIBLE);
				button02.startAnimation(upAnimationIn);
				button03.setVisibility(View.VISIBLE);
				button03.startAnimation(downAnimationIn);
				visible = true;
			}else {
				button02.startAnimation(outAnimation);
				button03.startAnimation(outAnimation);
				button02.setVisibility(View.GONE);
				button03.setVisibility(View.GONE);
				visible = false;
			}
			break;
		case R.id.button2:
			Toast.makeText(RememberActivity.this, "已在当前界面", 1000).show();
			break;
		case R.id.button3:
			Intent intent = new Intent();
			intent.setClass(this, ReTrainActivity.class);
			RememberActivity.this.startActivity(intent);
			finish();
			overridePendingTransition(R.anim.main_come, R.anim.luncher_go);
			break;
		default:
			break;
		}
	}
	
	
}
