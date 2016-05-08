package com.ydhl.myview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.smartchildren.R;

public class TrainButton extends FrameLayout implements OnClickListener, AnimationListener 
{

	private Button button;
	private Animation animationTouch;
	private Animation animationUp;
	private int replace;
	private int primary;
	private boolean click;
	private boolean enable = true;
	private int flag;
	private TrainButton[][] buttons = new TrainButton[4][4];
	public TrainButton(Context context)
	{
		super(context);
		animationTouch = AnimationUtils.loadAnimation(context, R.anim.flipfrom);
		animationTouch.setAnimationListener(this);
		animationUp = AnimationUtils.loadAnimation(context, R.anim.flipto);
		animationUp.setAnimationListener(new AnimationListener()
		{
			
			@Override
			public void onAnimationStart(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation)
			{
				for (int i = 0; i < 4; i++)
				{
					for (int j = 0; j < 4; j++)
					{
						buttons[i][j].setEnable(true);
					}
				}
				
			}
		});
		button = new Button(context);
		button.setGravity(Gravity.CENTER);
		button.setOnClickListener(this);
		LayoutParams lp = new LayoutParams(-1, -1);// Ìî³äÂúÕû¸ö¸¸¼¶ÈÝÆ÷
		lp.setMargins(10, 10, 0, 0);
		addView(button, lp);
	}

	@Override
	public void onClick(View v)
	{
		if (isEnable())
		{
			
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					buttons[i][j].setEnable(false);
				}
			}
			button.startAnimation(animationTouch);
		}
	}
	public void mySetBackground(int drawable){
		primary = drawable;
		button.setBackgroundResource(drawable);
	}

	public int getReplace()
	{
		return replace;
	}

	public void setReplace(int replace)
	{
		this.replace = replace;
	}

	@Override
	public void onAnimationStart(Animation animation)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationEnd(Animation animation)
	{
		if (!click)
		{
			button.setBackgroundResource(replace);
			click = true;
		}else {
			button.setBackgroundResource(primary);
			click = false;
		}
		button.startAnimation(animationUp);
		
	}

	@Override
	public void onAnimationRepeat(Animation animation)
	{
		// TODO Auto-generated method stub
		
	}

	public boolean isEnable()
	{
		return enable;
	}

	public void setEnable(boolean enable)
	{
		this.enable = enable;
	}

	public TrainButton[][] getButtons()
	{
		return buttons;
	}

	public void setButtons(TrainButton[][] buttons2)
	{
		this.buttons = buttons2;
	}
	public void startAnim(){
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				buttons[i][j].setEnable(false);
			}
		}
		button.startAnimation(animationTouch);
	}

	

}
