package com.ydhl.smartchildren;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.utils.MyHttpUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends BaseActivity
{

	private EditText editText;
	private TextView textView;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1)
			{
				textView.setText((CharSequence)msg.obj);
			}else if (msg.what == 2) {
				Toast.makeText(CheckActivity.this, "ÑéÖ¤Âë´íÎó", 1000).show();
			}
		};
	};
	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_check);
		editText = (EditText) findViewById(R.id.editText1);
		textView = (TextView) findViewById(R.id.textView1);
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

	public void tocheck(View view){
		MyHttpUtils myHttpUtils = new MyHttpUtils("POST", "http://zcs.svnt.ml/rzet/verification_key.php",
				editText.getText().toString().trim(), 0, new MyHttpListener()
				{
					
					@Override
					public void onSuccess(String content)
					{
						Message message = Message.obtain();
						message.obj = content;
						message.what = 1;
						handler.sendMessage(message);
						
					}
					
					@Override
					public void onFailed(String content)
					{
						Message message = Message.obtain();
						message.obj = content;
						message.what = 2;
						handler.sendMessage(message);
						
					}
				});
		myHttpUtils.DoRequestByHttpUrlConnection();
	}

}
