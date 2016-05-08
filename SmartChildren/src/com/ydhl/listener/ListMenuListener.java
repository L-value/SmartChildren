package com.ydhl.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.ydhl.smartchildren.FacadeActivity;
import com.ydhl.smartchildren.GameLoadActivity;
import com.ydhl.smartchildren.ThemeActivity;

public class ListMenuListener implements OnItemClickListener
{
	private Context context;
	
	public ListMenuListener(Context context)
	{
		super();
		this.context = context;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{
		switch (position)
		{
		case 0:
			Intent intent = new Intent();
			break;
		case 1:
			Intent intent1 = new Intent();
			intent1.setClass(context, ThemeActivity.class);
			context.startActivity(intent1);
			break;
		case 2:
			Intent intent2 = new Intent();
			intent2.setClass(context, GameLoadActivity.class);
			context.startActivity(intent2);
			break;
		case 3:
			Intent intent3 = new Intent();
			intent3.setClass(context, FacadeActivity.class);
			context.startActivity(intent3);
			break;
		default:
			break;
		}
		
	}

	

}
