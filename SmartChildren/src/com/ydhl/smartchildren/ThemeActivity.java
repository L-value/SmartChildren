package com.ydhl.smartchildren;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.example.smartchildren.R.menu;
import com.ydhl.common.BaseActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ThemeActivity extends BaseActivity implements OnClickListener
{
	private ImageButton imageButton;
	private ImageButton imageButton2;
	private ImageButton imageButton3;
	private View view;
	private LinearLayout linearLayout;
	private int[] bgs = new int[] { R.drawable.bg01, R.drawable.bg03,
			R.drawable.bg_04 };

	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_theme);
		imageButton = (ImageButton) findViewById(R.id.image01);
		imageButton2 = (ImageButton) findViewById(R.id.image02);
		imageButton3 = (ImageButton) findViewById(R.id.image03);
		view = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
		linearLayout = (LinearLayout) view.findViewById(R.id.linearmain);

	}

	@Override
	public void initView()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void initListeners()
	{
		imageButton.setOnClickListener(this);
		imageButton2.setOnClickListener(this);
		imageButton3.setOnClickListener(this);
	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.image01:
			MainActivity.linearLayout.setBackgroundResource(bgs[0]);
			break;
		case R.id.image02:
			MainActivity.linearLayout.setBackgroundResource(bgs[1]);
			break;
		case R.id.image03:
			MainActivity.linearLayout.setBackgroundResource(bgs[2]);
			break;

		default:
			break;
		}
	}

}
