package com.ydhl.smartchildren;

import cn.jpush.android.api.JPushInterface;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.example.smartchildren.R.menu;
import com.ydhl.common.BaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LaunchActivity extends BaseActivity
{
	private Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			Intent intent = new Intent();
			intent.setClass(LaunchActivity.this, LoginActivity.class);
			LaunchActivity.this.startActivity(intent);
			finish();
			
		}
	};
	private ImageView imageView; 
	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_launch);
		imageView = (ImageView) findViewById(R.id.launch);
		Animation animation = AnimationUtils.loadAnimation(this,R.anim.launch_from);
		imageView.setAnimation(animation);
		Thread thread = new Thread(){
			public void run() {
				try
				{
					Thread.sleep(1500);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				handler.sendMessage(Message.obtain());
			};
		};
		thread.start();

	}

	@Override
	public void initView()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void initListeners()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub

	}
	@Override
	protected void onResume()
	{
		JPushInterface.onResume(this);
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause()
	{
		JPushInterface.onPause(this);
		super.onPause();
	}

}
