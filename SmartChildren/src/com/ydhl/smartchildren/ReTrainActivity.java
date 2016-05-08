package com.ydhl.smartchildren;

import com.example.smartchildren.R;
import com.example.smartchildren.R.layout;
import com.ydhl.common.BaseActivity;
import com.ydhl.myview.ReGameView;
import com.ydhl.myview.ReTrainView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.Toast;

public class ReTrainActivity extends BaseActivity implements OnClickListener
{

	private ReTrainView reTrainActivity;
	private Button button01;
	private Button button02;
	private  Button button03;
	private boolean visible;
	private Animation upAnimationIn;
	private Animation upAnimationInCallback;
	private Animation downAnimationIn;
	private Animation downAnimationInCallback;
	private Animation outAnimation;
	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_re_train);
		reTrainActivity = (ReTrainView) findViewById(R.id.reGameView1);
		button01 = (Button) findViewById(R.id.button1);
		button02 = (Button) findViewById(R.id.button2);
		button03 = (Button) findViewById(R.id.button3);
		button02.setText("训练模式");
		button03.setText("培养模式");
	}

	@Override
	public void initView()
	{
		downAnimationIn = AnimationUtils.loadAnimation(this, R.anim.down_left_in);
		downAnimationInCallback = AnimationUtils.loadAnimation(this, R.anim.down_left_in_callback);
		upAnimationIn = AnimationUtils.loadAnimation(this, R.anim.up_left_in);
		upAnimationInCallback = AnimationUtils.loadAnimation(this, R.anim.up_left_in_callback);
		outAnimation = AnimationUtils.loadAnimation(this, R.anim.button_out);
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
	
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
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
			Intent intent = new Intent();
			intent.setClass(this, RememberActivity.class);
			ReTrainActivity.this.startActivity(intent);
			finish();
			overridePendingTransition(R.anim.main_come, R.anim.luncher_go);
			break;
		case R.id.button3:
			Toast.makeText(ReTrainActivity.this, "已在当前界面", 1000).show();
			
			break;
		default:
			break;
		}
	}
}
