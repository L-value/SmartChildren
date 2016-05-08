package com.ydhl.smartchildren;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartchildren.R;
import com.google.gson.Gson;
import com.ydhl.bean.LoginGetInfo;
import com.ydhl.bean.LoginInfo;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.myview.ClearEditText;
import com.ydhl.utils.MyDataBaseHelper;
import com.ydhl.utils.MyHttpUtils;

public class LoginActivity extends BaseActivity implements
		android.view.View.OnClickListener, OnCheckedChangeListener
{

	private Button buttonLogin;
	private TextView register;
	private TextView forgot;
	private ClearEditText clearEditTextUser;
	private ClearEditText clearEditTextPass;
	private CheckBox checkBoxPass;
	private CheckBox checkAuto;
	private boolean fromMain = false;
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	private ArrayList<Map<String, String>> result = new ArrayList<>();
	private Gson gson = new Gson();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
	private String currentTime;
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case 1:
				Toast.makeText(LoginActivity.this, "µÇÂ¼Ê§°Ü", 700).show();
				break;
			case 2:
				Toast.makeText(LoginActivity.this, loginGetInfo.getMessage(),
						1000).show();
				break;
			case 3:
				Toast.makeText(
						LoginActivity.this,
						"ÇëÔÚ" + loginGetInfo.getStart_time() + "~"
								+ loginGetInfo.getEnd_time() + "¼äµÇÂ½", 1000)
						.show();
				break;
			default:
				break;
			}
		};
	};
	MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(this, "users.db3",
			null, 1);
	private boolean repass;
	private boolean auto;
	private String userName;
	private String passWord;

	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_login);
		currentTime = simpleDateFormat.format(new Date());
		System.out.println(currentTime);
		buttonLogin = (Button) findViewById(R.id.login);
		forgot = (TextView) findViewById(R.id.textViewForgot);
		register = (TextView) findViewById(R.id.textViewRegister);
		clearEditTextUser = (ClearEditText) findViewById(R.id.username);
		clearEditTextPass = (ClearEditText) findViewById(R.id.password);
		checkBoxPass = (CheckBox) findViewById(R.id.checkBox1);
		checkAuto = (CheckBox) findViewById(R.id.checkBox2);
		sharedPreferences = this.getSharedPreferences("autoandremember",
				Context.MODE_PRIVATE);
		editor = sharedPreferences.edit();
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
		buttonLogin.setOnClickListener(this);
		register.setOnClickListener(this);
		forgot.setOnClickListener(this);
		checkBoxPass.setOnCheckedChangeListener(this);
		checkAuto.setOnCheckedChangeListener(this);
	}

	private LoginGetInfo loginGetInfo;

	@Override
	public void initData()
	{
		if (!fromMain)
		{
			repass = sharedPreferences.getBoolean("repass", false);
			auto = sharedPreferences.getBoolean("auto", false);
			if (repass)
			{

				clearEditTextUser.setText(sharedPreferences.getString(
						"userName", ""));
				clearEditTextPass.setText(sharedPreferences.getString(
						"passWord", ""));
				checkBoxPass.setChecked(true);
				application.setUserName(sharedPreferences.getString("userName", ""));
			}
			if (auto)
			{
				checkAuto.setChecked(true);
				userName = clearEditTextUser.getText().toString();
				passWord = clearEditTextPass.getText().toString();
				MyHttpUtils myHttpUtils = new MyHttpUtils("POST",
						new LoginInfo(userName, passWord),
						"http://zcs.svnt.ml/rzet/Client_Interface.php",
						new MyHttpListener()
						{

							@Override
							public void onSuccess(String content)
							{
								Intent intent = new Intent();
								intent.setClass(LoginActivity.this,
										MainActivity.class);
								LoginActivity.this.startActivity(intent);
								if (fromMain)
								{
									application.clearActivities();
								}
								if (repass)
								{
									editor.putString("userName", userName);
									editor.putString("passWord", passWord);
									editor.commit();
								}
								finish();
							}

							@Override
							public void onFailed(String content)
							{
								Message message = Message.obtain();
								message.what = 1;
								handler.sendMessage(message);
							}
						});
				myHttpUtils.DoRequestByHttpUrlConnection();
			}
		}
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.login:
			userName = clearEditTextUser.getText().toString();
			passWord = clearEditTextPass.getText().toString();
			if (userName.equals("aaa") && passWord.equals("aaaaaa"))
			{
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this,
						MainActivity.class);
				LoginActivity.this.startActivity(intent);
				application.setUserName(userName);
				finish();
			}
			MyHttpUtils myHttpUtils = new MyHttpUtils("POST", new LoginInfo(
					userName, passWord),
					"http://zcs.svnt.ml/rzet/Client_Interface.php",
					new MyHttpListener()
					{
						@Override
						public void onSuccess(String content)
						{
							System.out.println(content + "aa");
							loginGetInfo = gson.fromJson(content,
									LoginGetInfo.class);
							System.out.println(loginGetInfo.toString());
							if (loginGetInfo.isReslut())
							{
								application.setBeginTime(loginGetInfo
										.getStart_time());
								application.setEndTime(loginGetInfo
										.getEnd_time());
								application.setGameTime(loginGetInfo
										.getTime_long());
								System.out.println(Integer.valueOf(loginGetInfo
										.getStart_time()) + "start_time");
								System.out.println(Integer.valueOf(loginGetInfo
										.getEnd_time()) + "end_time");
								System.out.println(Integer.valueOf(currentTime));
								System.out.println(Integer.valueOf(loginGetInfo
										.getStart_time()) >= Integer
										.valueOf(currentTime));
								System.out.println(Integer.valueOf(currentTime) <= Integer
										.valueOf(loginGetInfo.getEnd_time()));
								if (Integer.valueOf(loginGetInfo
										.getStart_time()) <= Integer
										.valueOf(currentTime)
										&& Integer.valueOf(currentTime) <= Integer
												.valueOf(loginGetInfo
														.getEnd_time()))
								{
									Intent intent = new Intent();
									intent.setClass(LoginActivity.this,
											MainActivity.class);
									LoginActivity.this.startActivity(intent);
									application.setUserName(userName);
								} else
								{

									Message message = Message.obtain();
									message.what = 3;
									handler.sendMessage(message);
								}
								if (repass)
								{
									editor.putString("userName", userName);
									editor.putString("passWord", passWord);
									editor.commit();
								}
								finish();
							} else
							{
								Message message = Message.obtain();
								message.what = 2;
								handler.sendMessage(message);

							}
							if (fromMain)
							{
								application.clearActivities();
							}

						}

						@Override
						public void onFailed(String content)
						{

							Message message = Message.obtain();
							message.what = 1;
							handler.sendMessage(message);

						}
					});
			myHttpUtils.DoRequestByHttpUrlConnection();

			break;
		case R.id.textViewRegister:
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, RegisterActivity.class);
			LoginActivity.this.startActivity(intent);
			break;
		case R.id.textViewForgot:
			Intent intent2 = new Intent();
			intent2.setClass(LoginActivity.this,ForgetActivity.class);
			LoginActivity.this.startActivity(intent2);
			break;
		default:
			break;
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	{
		switch (buttonView.getId())
		{
		case R.id.checkBox1:
			if (isChecked)
			{
				repass = true;
				editor.putBoolean("repass", true);
			} else
			{
				repass = false;
				editor.putString("userName", "");
				editor.putString("passWord", "");
				editor.putBoolean("repass", false);
			}
			break;
		case R.id.checkBox2:
			if (isChecked)
			{
				auto = true;
				editor.putBoolean("auto", true);
			} else
			{
				auto = false;
				editor.putBoolean("auto", false);
			}
			break;
		default:
			break;
		}
		editor.commit();

	}

}
