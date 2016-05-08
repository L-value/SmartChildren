package com.ydhl.adapter;

import java.util.ArrayList;

import com.example.smartchildren.R;
import com.ydhl.bean.MyMenuItem;
import com.ydhl.mylog.MyLog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter
{
	private ArrayList<MyMenuItem> menuItems;
	private Context context;
    private LayoutInflater layoutInflater;

	public MyListAdapter(ArrayList<MyMenuItem> menuItems, Context context)
	{
		super();
		this.menuItems = menuItems;
		this.context = context;
		layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return menuItems.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return menuItems.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		MyMenuItem menuItem = menuItems.get(position);
		ViewHolder viewHolder;
		if (convertView == null)
		{
			viewHolder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.list, null);
			viewHolder.imageView = (ImageView) convertView.findViewById(R.id.Icon);
			viewHolder.textView = (TextView) convertView.findViewById(R.id.introduce);
			//convertView.setBackgroundColor(Color.argb(88, 00, 255, 255));
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.imageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), menuItem.Icon));
		viewHolder.textView.setText(menuItem.introduce);
		viewHolder.textView.setTextColor(Color.rgb(238, 87, 0));
		return convertView;
	}

	private class ViewHolder
	{
		ImageView imageView;
		TextView textView;
	}
}
