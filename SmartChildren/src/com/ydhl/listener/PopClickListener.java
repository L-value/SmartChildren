package com.ydhl.listener;

import org.apache.http.impl.client.TunnelRefusedException;

import com.example.smartchildren.R;
import com.ydhl.mylog.MyLog;
import com.ydhl.smartchildren.LoginActivity;
import com.ydhl.smartchildren.RegisterActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class PopClickListener implements OnClickListener
{
	private Context context;
	
	public PopClickListener(Context context)
	{
		super();
		this.context = context;
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.button1:
			Intent intent1 = new Intent();
			intent1.setClass(context, RegisterActivity.class);
			intent1.putExtra("fromMain", true);
			context.startActivity(intent1);
			break;
		case R.id.button2:
			Intent intent2 = new Intent();
			intent2.putExtra("fromMain", true);
			intent2.setClass(context, LoginActivity.class);
			context.startActivity(intent2);
			break;
		case R.id.button3:
			MyLog.i("ex");
			System.exit(0);
			break;
		default:
			break;
		}
		
	}

}
