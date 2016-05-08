package com.ydhl.listener;

public interface MyHttpListener
{
	void onSuccess(String content);
	void onFailed(String content);
}
