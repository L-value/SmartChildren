package com.ydhl.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ydhl.bean.LoginInfo;
import com.ydhl.bean.PlayTime;
import com.ydhl.bean.UserInfo;
import com.ydhl.listener.MyHttpListener;

public class MyHttpUtils
{
	private String method;
	private UserInfo data;
	private PlayTime playTime;
	private String path;
	private MyHttpListener myHttpListener;
	private Map<String, String>  dataMap;
	private JsonObject jsonObject = new JsonObject();
	private Gson gson = new Gson();
	private LoginInfo loginInfo;
	private String facade;
	public MyHttpUtils(String method, UserInfo data, String path,MyHttpListener myHttpListener)
	{
		super();
		this.method = method;
		this.data = data;
		this.path = path;
		this.myHttpListener = myHttpListener;
		dataMap = new HashMap<>();
		dataMap.put("code","300");
		dataMap.put("UserName",data.getUserName());
		dataMap.put("Password",data.getPassWord());
		dataMap.put("sex",data.getSex());
		dataMap.put("age",Integer.toString(data.getAge()));
		dataMap.put("tel", data.getTel());
		dataMap.put("parent", data.getLead());

	}
	public MyHttpUtils(String method,String facade, String path,MyHttpListener myHttpListener)
	{
		super();
		this.method = method;
		this.facade = facade;
		this.path = path;
		this.myHttpListener = myHttpListener;
		dataMap = new HashMap<>();
		dataMap.put("", facade);
	}
	public MyHttpUtils(String method,String username,String tel,String email, String path,MyHttpListener myHttpListener)
	{
		super();
		
		this.method = method;
		this.path = path;
		this.myHttpListener = myHttpListener;
		dataMap = new HashMap<>();
		dataMap.put("Username", username);
		dataMap.put("tel", tel);
		dataMap.put("email", email);
	}
	public MyHttpUtils(String method, LoginInfo loginInfo, String path,MyHttpListener myHttpListener)
	{
		super();
		this.method = method;
		this.loginInfo = loginInfo;
		this.path = path;
		this.myHttpListener = myHttpListener;
		dataMap = new HashMap<>();
		dataMap.put("code","302");
		dataMap.put("UserName",loginInfo.getUserName());
		dataMap.put("Password",loginInfo.getPassWord());
	}
	public MyHttpUtils(String method, PlayTime playTime, String path,MyHttpListener myHttpListener)
	{
		super();
		this.method = method;
		this.playTime = playTime;
		this.path = path;
		this.myHttpListener = myHttpListener;
		dataMap = new HashMap<>();
		dataMap.put("code","100");
		dataMap.put("Game_1_time", playTime.getGame_1_Time());
		dataMap.put("Game_2_time", playTime.getGame_2_Time());
		dataMap.put("Game_3_time", playTime.getGame_3_Time());
		dataMap.put("Game_1_grade", playTime.getGame_1_Grade());
		dataMap.put("Game_2_grade", playTime.getGame_2_Grade());
		dataMap.put("Game_3_grade", playTime.getGame_3_Grade());
	
	}
	public MyHttpUtils(String method,String path,String key,int a,MyHttpListener myHttpListener)
	{
		super();
		this.method = method;
		this.path = path;
		this.myHttpListener = myHttpListener;
		dataMap = new HashMap<>();
		dataMap.put("key", key);
	}
	public void DoRequestByHttpUrlConnection(){
		MyHttpTask myHttpTask = new MyHttpTask();
		myHttpTask.execute();
	}
	private String doGetByHttpClient(){
		HttpGet httpGet = new HttpGet(path);
		String content = null;
		HttpClient httpClient = MyHttpClient.getInstatnce();
		try
		{
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				content = EntityUtils.toString(response.getEntity(),"utf-8");
				myHttpListener.onSuccess(content);
			}
		} catch (Exception e)
		{
			myHttpListener.onFailed(content);
			e.printStackTrace();
		}
		return content;
	}
	private String doPostByHttpClient(){
		String content = null;
		HttpPost httpPost = new HttpPost(path);
		HttpClient httpClient = MyHttpClient.getInstatnce();
		List<NameValuePair> parameters = new ArrayList<>();
		for (Entry<String, String> entry : dataMap.entrySet())
		{
			NameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), entry.getValue());
			parameters.add(nameValuePair);
		}
		try
		{
			UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(parameters);
			httpPost.setEntity(encodedFormEntity);
			HttpResponse response = httpClient.execute(httpPost);
			
			if (response.getStatusLine().getStatusCode() == 200)
			{
				content = EntityUtils.toString(response.getEntity(),"utf-8");
				myHttpListener.onSuccess(content);
			}
		} catch (Exception e1)
		{
			myHttpListener.onFailed(content);
			e1.printStackTrace();
		}

		
		return content;
	}
	private class MyHttpTask extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params)
		{
			if (method.equals("GET"))
			{
				return doGetByHttpClient();
			}else if(method.equals("POST")){
				return doPostByHttpClient();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result)
		{	
			super.onPostExecute(result);
		}
		
	}
}
