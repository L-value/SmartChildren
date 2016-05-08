package com.ydhl.smartchildren;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.example.smartchildren.R.menu;
import com.google.gson.Gson;
import com.ydhl.bean.RegisterInfo;
import com.ydhl.bean.UserInfo;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.mylog.MyLog;
import com.ydhl.utils.MyHttpUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;

public class RegisterActivity extends BaseActivity implements MyHttpListener
{
	private Button buttonRegister;
	private EditText editTextName;
	private EditText editTextPass;
	private EditText editTextRepass;
	private EditText editTextage;
	private EditText editTextTel;
	private EditText editTextLead;
	private boolean fromMain = false;
	private Switch switch1;
	private boolean ifLogin = true;
	private Gson gson = new Gson();
 	private UserInfo userInfo = new UserInfo();
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if (msg.arg1 == 1)
			{
				Toast.makeText(RegisterActivity.this, "注册成功", 1000).show();
				if (fromMain)
				{
					Intent intent = new Intent();
					intent.setClass(RegisterActivity.this,MainActivity.class);
					RegisterActivity.this.startActivity(intent);
				}else {
					Intent intent = new Intent();
					intent.setClass(RegisterActivity.this,LoginActivity.class);
					RegisterActivity.this.startActivity(intent);
				}
				finish();
			}else if(msg.arg1 == 2){
				Toast.makeText(RegisterActivity.this, "注册失败", 1000).show();
			}else if(msg.arg1 == 3){
				Toast.makeText(RegisterActivity.this, registerInfo.getMessage(), 1000).show();
			}
			
		};
	};
	private RegisterInfo registerInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public void setContentView()
	{
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_register);
		buttonRegister = (Button) findViewById(R.id.button1Register);
		editTextName = (EditText) findViewById(R.id.editText1);
		editTextPass = (EditText) findViewById(R.id.editText2);
		editTextRepass = (EditText) findViewById(R.id.editText3);
		editTextage = (EditText) findViewById(R.id.editText4);
		editTextTel = (EditText) findViewById(R.id.editText5);
		editTextLead = (EditText) findViewById(R.id.editText6);
		switch1 = (Switch) findViewById(R.id.switch1);
	}

	@Override
	public void initView()
	{
		Intent intent = getIntent();
		fromMain = intent.getBooleanExtra("fromMain", false);
		
	}

	@Override
	public void initListeners()
	{
		userInfo.setSex("woman");
		switch1.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if (isChecked)
				{
					userInfo.setSex("man");
				} else
				{
					userInfo.setSex("woman");
				}
				
			}
		});
		buttonRegister.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				ifLogin = true;
				if (editTextName.getText() != null && editTextName.getText().toString().trim().length() > 0
						&& checkUser(editTextName.getText().toString())
						&&isWord(editTextName.getText().toString()))
				{
					userInfo.setUserName(editTextName.getText().toString());
				}else {
					ifLogin = false;
					Toast.makeText(RegisterActivity.this, "账号不能有空格,且必须以字母开头", 1000).show();
				}
				if (editTextPass.getText() != null && editTextPass.getText().toString().trim().length() >= 6
						&& checkUser(editTextPass.getText().toString()))
				{
				
				} else
				{
					ifLogin = false;
					Toast.makeText(RegisterActivity.this, "密码不能小于6位且不能有空格", 1000).show();
				}
				if (editTextPass.getText() != null && editTextRepass.getText() != null
						&& editTextPass.getText().toString().equals(editTextRepass.getText().toString()))
				{
					userInfo.setPassWord(editTextPass.getText().toString());
				}else {
					ifLogin = false;
					Toast.makeText(RegisterActivity.this, "两次填写的密码不一致", 1000).show();
				}
				if (editTextage.getText() != null && editTextage.getText().toString().trim().length() > 0)
				{
					userInfo.setAge(Integer.parseInt(editTextage.getText().toString()));
				} else
				{
					ifLogin = false;
				}
				if (editTextTel.getText() != null && editTextTel.getText().toString().trim().length() > 0)
				{
					userInfo.setTel(editTextTel.getText().toString());
				}else {
					ifLogin = false;
				}
				if (editTextLead.getText() != null && editTextLead.getText().toString().trim().length() > 0)
				{
					userInfo.setLead(editTextLead.getText().toString());
				}else {
					ifLogin = false;
				}
				System.out.println(gson.toJson(userInfo,UserInfo.class));
				System.out.println(ifLogin);
			if (ifLogin)
			{
				MyHttpUtils myHttpUtils = new MyHttpUtils("POST",
						userInfo,
						"http://zcs.svnt.ml/rzet/Client_Interface.php",
						RegisterActivity.this);
				myHttpUtils.DoRequestByHttpUrlConnection();
			}else {
			    Toast.makeText(RegisterActivity.this, "请准确填写个人信息", 1000).show();
			}
			}

			private boolean isWord(String string)
			{
				if ((string.charAt(0)>='A'&&string.charAt(0)<='Z')
						|| (string.charAt(0)>='a'
						&&string.charAt(0)<='z'))
				{
					return true;
				}
				return false;
			}
		});
		
	}

	@Override
	public void initData()
	{
		
		
	}

	@Override
	public void onSuccess(String content)
	{
		
		MyLog.i(content);
		registerInfo = gson.fromJson(content, RegisterInfo.class);
		System.out.println(registerInfo.toString());
		Message message = Message.obtain();//{"result":"false","message":"Parents user does not exist"}
		if (registerInfo.isResult() == false)
		{
			message.arg1 = 3;
		}else {
			
			message.arg1 = 1;
		}
		handler.sendMessage(message);
	}

	@Override
	public void onFailed(String content)
	{   MyLog.i("failed");
	
		Message message = Message.obtain();
		message.arg1 = 2;
		handler.sendMessage(message);
		
	}
	private boolean checkUser(String checker)
	{
		for (int i = 0; i < checker.length(); i++)
		{
			if (checker.charAt(i) == ' ')
			{
				return false;
			}
		}
		return true;
	}


}
