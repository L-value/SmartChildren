package com.ydhl.listener;

import java.io.IOException;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.smartchildren.R;
import com.ydhl.smartchildren.GameLoadActivity;
import com.ydhl.smartchildren.HistoryActivity;
import com.ydhl.utils.MyHttpUtils;

public class PagerMainListener implements OnClickListener
{
	private Context context;
	private Random random = new Random();
	private String[] activities = new String[]{
			"com.ydhl.smartchildren.RememberActivity",
			"com.ydhl.smartchildren.WordActivity",
			"com.ydhl.smartchildren.ThinkActivity"
	};
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private boolean isPlay;
	public PagerMainListener(Context context)
	{
		super();
		this.context = context;
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.everyday:
			try
			{
				mediaPlayer.setDataSource("http://zcs.svnt.ml/rzet/RZET_(1).mp3");
				mediaPlayer.prepare();
				if (!isPlay)
				{
					mediaPlayer.start();
					isPlay = true;
				}else {
					mediaPlayer.pause();
					isPlay = false;
				}
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			break;
		case R.id.historybutton:
			Intent intent2 = new Intent();
			intent2.setClass(context, HistoryActivity.class);
			context.startActivity(intent2);
			break;
		case R.id.downbutton:
			Intent intent3 = new Intent();
			try
			{
				intent3.setAction("com.example.helloandroid.GameView");
				context.startActivity(intent3);
				
			} catch (Exception e)
			{
				Toast.makeText(context, "ªπŒ¥œ¬‘ÿ”Œœ∑", 1000).show();
			}
			break;
		case R.id.anybutton:
			Intent intent = new Intent();
			intent.setClassName(context, activities[random.nextInt(3)]);
			context.startActivity(intent);
			break;
		default:
			break;
		}

	}

}
