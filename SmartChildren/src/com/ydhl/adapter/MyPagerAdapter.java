package com.ydhl.adapter;

import java.util.ArrayList;

import com.example.smartchildren.R;
import com.ydhl.mylog.MyLog;
import com.ydhl.smartchildren.MainActivity;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MyPagerAdapter extends PagerAdapter
{

	private ArrayList<View> views;
	private Context context;
	public MyPagerAdapter(Context context, ArrayList<View> views)
	{
		super();
		this.context = context;
		this.views = views;
	}

	@Override
	public int getCount()
	{
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1)
	{
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object)
	{
		container.removeView(views.get(position));
		//super.destroyItem(container, position, object);
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		
		container.addView(views.get(position));
		return views.get(position);
	}
	

}
