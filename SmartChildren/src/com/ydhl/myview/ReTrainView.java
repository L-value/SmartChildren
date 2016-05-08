package com.ydhl.myview;

import java.util.Random;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import com.example.smartchildren.R;

public class ReTrainView extends GridLayout
{
	private TrainButton[][] buttons = new TrainButton[4][4];
	public static int step = 0;
	private Random random = new Random();
	
	private int background[] = new int[] { R.drawable.re_banana2,
			R.drawable.re_banana2, R.drawable.re_kiwi2, R.drawable.re_kiwi2,
			R.drawable.re_lemon2, R.drawable.re_lemon2, R.drawable.re_orange2,
			R.drawable.re_orange2, R.drawable.re_peach2, R.drawable.re_peach2,
			R.drawable.re_strawberry2, R.drawable.re_strawberry2,
			R.drawable.re_melon2, R.drawable.re_melon2,
			R.drawable.re_watermelon2, R.drawable.re_watermelon2 };
	private int[] localtion = new int[16];
	public ReTrainView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initGameView();
	}

	private void initGameView()
	{
		
		setColumnCount(4);

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)// 该方法只会在程序创建的时候
	{
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		rand();
		int card_Width = (Math.min(w, h) - 10) / 4;
		addcards(card_Width, card_Width);
	
	}
	
	@Override
	protected void onMeasure(int widthSpec, int heightSpec)
	{
		
		super.onMeasure(widthSpec, heightSpec-500);
	}
	private void addcards(int card_Width, int card_Width2)
	{
		TrainButton card;
		int k = 0;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				card = new TrainButton(getContext());
				buttons[i][j] = card;
				card.mySetBackground(R.drawable.re_blank2);
				card.setReplace(background[localtion[k++]]);
				addView(card, card_Width, card_Width2);
			}
		}
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				buttons[i][j].setButtons(buttons);
			}
		}
	}

	private void rand()
	{
		int a;
		for (int i = 0; i < 16; i++)
		{
			a = random.nextInt(16);
			localtion[i] = a;
			check(i);
		}

	}

	private void check(int i)
	{
		for (int j = 0; j < i; j++)
		{
			if (localtion[i] == localtion[j])
			{
				localtion[i] = random.nextInt(16);
				check(i);
			}
		}

	}


	
	
}
