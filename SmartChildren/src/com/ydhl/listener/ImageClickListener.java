package com.ydhl.listener;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.AvoidXfermode.Mode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.smartchildren.R;
import com.ydhl.smartchildren.MainActivity;
import com.ydhl.smartchildren.RememberActivity;
import com.ydhl.smartchildren.ThinkActivity;
import com.ydhl.smartchildren.WordActivity;

public class ImageClickListener implements OnClickListener
{
	private Context context;
	private MainActivity mainActivity;
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	public ImageClickListener(Context context,MainActivity mainActivity)
	{
		this.context = context;
		this.mainActivity = mainActivity;
		sharedPreferences = context.getSharedPreferences("info",context.MODE_WORLD_READABLE);
		editor = sharedPreferences.edit();
	}
	@Override
	public void onClick(View v)
	{
		Toast.makeText(context, "游戏正在启动", 200).show();
		switch (v.getId())
		{
		case R.id.imageword:
			Intent intent = new Intent();
			intent.setClass(context, WordActivity.class);
			context.startActivity(intent);
			mainActivity.overridePendingTransition(R.anim.activity_come, R.anim.activity_go);
			break;
		case R.id.imagememory:
			Intent intent2 = new Intent();
			intent2.setClass(context, RememberActivity.class);
			context.startActivity(intent2);
			mainActivity.overridePendingTransition(R.anim.activity_come, R.anim.activity_go);
			break;
		case R.id.imageconsider:
			Intent intent3 = new Intent();
			intent3.setClass(context, ThinkActivity.class);
			context.startActivity(intent3);
			mainActivity.overridePendingTransition(R.anim.activity_come, R.anim.activity_go);
			break;
		case R.id.imagecalculate:
			Intent intent4 = new Intent();
			editor.putInt("num",1);
			editor.putString("username",mainActivity.application.getUserName());
			editor.commit();
			intent4.setComponent(new ComponentName("com.zcs.txsb", "com.zcs.txsb.MainActivity"));
			context.startActivity(intent4);
			mainActivity.overridePendingTransition(R.anim.activity_come, R.anim.activity_go);
			break;
		case R.id.imageway:
			Intent intent5 = new Intent();
			editor.putInt("num", 0);
			editor.putString("username",mainActivity.application.getUserName());
			editor.commit();
			intent5.setComponent(new ComponentName("com.zcs.txsb", "com.zcs.txsb.MainActivity"));
			context.startActivity(intent5);
			mainActivity.overridePendingTransition(R.anim.activity_come, R.anim.activity_go);
			break;
		default:
			break;
		}
	}

}
