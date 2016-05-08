package com.ydhl.smartchildren;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartchildren.R;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.utils.MyHttpUtils;

public class FacadeActivity extends BaseActivity
{
	private EditText editText;
	private Button button;
	private String facadeback;
	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_facade);
		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);
	}

	@Override
	public void initView()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initListeners()
	{
		button.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				facadeback = editText.getText().toString();
				if (facadeback.length() < 20)
				{
					Toast.makeText(FacadeActivity.this, "输入信息必须大于20字", 1000).show();
				}else {
					MyHttpUtils myHttpUtils = new MyHttpUtils("POST", facadeback, 
							"http://zcs.svnt.ml/rzet/Client_Interface.php", new MyHttpListener()
							{
								
								@Override
								public void onSuccess(String content)
								{
									Toast.makeText(FacadeActivity.this, "您的反馈信息已收到", 1000).show();
									
								}
								
								@Override
								public void onFailed(String content)
								{
									// TODO Auto-generated method stub
									
								}
							});
					myHttpUtils.DoRequestByHttpUrlConnection();
				}
			
			}
		});
		
	}

	@Override
	public void initData()
	{
		
		
	}

	
}
