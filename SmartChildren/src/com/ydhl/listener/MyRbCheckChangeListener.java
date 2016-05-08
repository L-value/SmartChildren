package com.ydhl.listener;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.smartchildren.R;
import com.ydhl.smartchildren.MainActivity;

public class MyRbCheckChangeListener implements OnCheckedChangeListener
{
	private ViewPager viewPager;
	private MainActivity mainActivity;
	public MyRbCheckChangeListener(View viewPager1,MainActivity mainActivity)
	{
		super();
		this.viewPager = (ViewPager) viewPager1;
		this.mainActivity = mainActivity;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		int current = 0;
		switch (checkedId)
		{
		case R.id.radiobutton1:
			current = 0;
			clearColor(current);
			break;
		case R.id.radiobutton2:
			current = 1;
			clearColor(current);
			break;
		case R.id.radiobutton3:
			current = 2;
			clearColor(current);
			break;
		
		default:
			break;
		}
		viewPager.setCurrentItem(current);
		
	}
	public void clearColor(int current){
		if (current == 0)
		{
			mainActivity.getRadioButton02().setTextColor(Color.BLACK);
			mainActivity.getRadioButton03().setTextColor(Color.BLACK);
			mainActivity.getRadioButton01().setTextColor(Color.YELLOW);
		}else if (current == 1) {
			mainActivity.getRadioButton01().setTextColor(Color.BLACK);
			mainActivity.getRadioButton03().setTextColor(Color.BLACK);
			mainActivity.getRadioButton02().setTextColor(Color.YELLOW);
		}else {
			mainActivity.getRadioButton01().setTextColor(Color.BLACK);
			mainActivity.getRadioButton02().setTextColor(Color.BLACK);
			mainActivity.getRadioButton03().setTextColor(Color.YELLOW);
		}
	}



}
