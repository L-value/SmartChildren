package com.ydhl.utils;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class MyHttpClient
{
	private static HttpClient httpClient = null;
	public static HttpClient getInstatnce(){
		synchronized (MyHttpClient.class)
		{
			if (httpClient == null)
			{
				httpClient = new DefaultHttpClient();
			}
		}
		return httpClient;
	}
}
