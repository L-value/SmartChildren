package com.ydhl.common;

import java.util.ArrayList;

import android.app.Application;

public class BaseApplication extends Application
{
	private static BaseApplication application;
	private String beginTime;
	private String endTime;
	private String gameTime;
	private String userName;
	private ArrayList<BaseActivity> activities = new ArrayList<>();
	private  BaseApplication()
	{
		
	}
	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
	}
	public static BaseApplication getInstance()
	{
		if (application == null)
		{
			application = new BaseApplication();
		}
		return application;
	}
	public ArrayList<BaseActivity> getActivities()
	{
		return activities;
	}
	public void addActivities(BaseActivity activity)
	{
		activities.add(activity);
	}
	public void clearActivities()
	{
		for (BaseActivity baseActivity : activities)
		{
			baseActivity.finish();
		}
	}
	public String getBeginTime()
	{
		return beginTime;
	}
	public void setBeginTime(String beginTime)
	{
		this.beginTime = beginTime;
	}
	public String getEndTime()
	{
		return endTime;
	}
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}
	public String getGameTime()
	{
		return gameTime;
	}
	public void setGameTime(String gameTime)
	{
		this.gameTime = gameTime;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

}
