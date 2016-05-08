package com.ydhl.smartchildren;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.google.gson.JsonObject;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.utils.MyHttpUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetActivity extends BaseActivity
{
	private EditText editText1;
	private EditText editText2;
	private EditText editText3;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1)
			{
				Toast.makeText(ForgetActivity.this, "消息发送成功，请去邮箱检查", 1000).show();
				Intent intent = new Intent();
				intent.setClass(ForgetActivity.this, CheckActivity.class);
				ForgetActivity.this.startActivity(intent);
			}else if (msg.what == 2) {
				Toast.makeText(ForgetActivity.this, "验证失败", 1000).show();
			}else if (msg.what == 3) {
				Toast.makeText(ForgetActivity.this, "消息发送失败", 1000).show();
			}
		};
	};
	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_forget);
	}

	@Override
	public void initView()
	{
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
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
	public void onPost(View view){
		MyHttpUtils myHttpUtils = new MyHttpUtils("POST", editText1.getText().toString(),
				editText2.getText().toString(), editText3.getText().toString(),"http://zcs.svnt.ml/rzet/Retrieve_Password.php"
				, new MyHttpListener()
				{
					
					

					@Override
					public void onSuccess(String content)
					{
						
						
						
							if (content.length() >= 40)
							{
								handler.sendEmptyMessage(1);						
							}else {
								handler.sendEmptyMessage(2);
							}
					}
					
					@Override
					public void onFailed(String content)
					{
						handler.sendEmptyMessage(3);
						
					}
				});
		myHttpUtils.DoRequestByHttpUrlConnection();
	}

}
