package com.ydhl.mylog;

import android.util.Log;

public class MyLog
{
	public static void i(String msg)
	{
		Log.i("info", msg);
	}
	public static void t(int msg)
	{
		Log.i("info", Integer.toString(msg));
	}
}
