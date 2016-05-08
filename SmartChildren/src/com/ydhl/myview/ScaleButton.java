package com.ydhl.myview;

import com.example.smartchildren.R;

import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

public class ScaleButton extends FrameLayout implements OnClickListener, AnimationListener 
{
	private Button button;
	private Animation animationTouch;
	private Animation animationUp;
	private int replace;
	private int primary;
	private boolean click;
	private boolean enable = true;
	private int flag;
	private ScaleButton[][] buttons = new ScaleButton[4][4];
	public ScaleButton(Context context)
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
				if (ReGameView.frontal.size() == 2 && ReGameView.frontal.get(0).getReplace()
						!= ReGameView.frontal.get(1).getReplace())
				{
					ReGameView.frontal.get(0).startAnim();
					ReGameView.frontal.get(1).startAnim();
					ReGameView.frontal.remove(0);
					ReGameView.frontal.remove(0);
				}
				else if (ReGameView.frontal.size() == 2) {
					ReGameView.frontal.remove(0);
					ReGameView.frontal.remove(0);
					ReGameView.count+=2;
				}
				if (ReGameView.count == 16)
				{
					Toast.makeText(getContext(), "success", 1000).show();
				}
				System.out.println(ReGameView.count+"count");
			}
		});
		button = new Button(context);
		button.setGravity(Gravity.CENTER);
		button.setOnClickListener(this);
		LayoutParams lp = new LayoutParams(-1, -1);// 填充满整个父级容器
		lp.setMargins(10, 10, 0, 0);
		addView(button, lp);
	}

	@Override
	public void onClick(View v)
	{
		if (isEnable())
		{
			ReGameView.frontal.add(this);
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					buttons[i][j].setEnable(false);
				}
			}
			ReGameView.step++;
			ReGameView.textView.setText("当前步数："+ReGameView.step);
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

	public ScaleButton[][] getButtons()
	{
		return buttons;
	}

	public void setButtons(ScaleButton[][] buttons)
	{
		this.buttons = buttons;
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

	public int getFlag()
	{
		return flag;
	}

	public void setFlag(int flag)
	{
		this.flag = flag;
	}
}
