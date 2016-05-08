package com.ydhl.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;

public abstract class BaseActivity extends Activity{
	public BaseApplication application;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		application = BaseApplication.getInstance();
		setContentView();
		initView();
		initListeners();
		initData();
	}
	public abstract void setContentView();
	public abstract void initView();
	public abstract void initListeners();
	public abstract void initData();
}
