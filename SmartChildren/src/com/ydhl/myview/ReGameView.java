package com.ydhl.myview;

import java.util.ArrayList;
import java.util.Random;

import android.R.string;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.smartchildren.R;

public class ReGameView extends GridLayout
{
	private ScaleButton[][] buttons = new ScaleButton[4][4];
	public static int step = 0;
	private Random random = new Random();
	public static ArrayList<ScaleButton> frontal = new ArrayList<>();
	private int background[] = new int[] { R.drawable.re_banana2,
			R.drawable.re_banana2, R.drawable.re_kiwi2, R.drawable.re_kiwi2,
			R.drawable.re_lemon2, R.drawable.re_lemon2, R.drawable.re_orange2,
			R.drawable.re_orange2, R.drawable.re_peach2, R.drawable.re_peach2,
			R.drawable.re_strawberry2, R.drawable.re_strawberry2,
			R.drawable.re_melon2, R.drawable.re_melon2,
			R.drawable.re_watermelon2, R.drawable.re_watermelon2 };
	private int[] localtion = new int[16];
	public static int count = 0;
	public static TextView textView;
	public ReGameView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initGameView();
	}

	private void initGameView()
	{
		textView = new TextView(getContext());
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
		//setBackgroundColor(Color.RED);
		// startGame();
	}
	
	@Override
	protected void onMeasure(int widthSpec, int heightSpec)
	{
		
		super.onMeasure(widthSpec, heightSpec-500);
	}
	private void addcards(int card_Width, int card_Width2)
	{
		ScaleButton card;
		int k = 0;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{ 
				card = new ScaleButton(getContext());
				buttons[i][j] = card;
				card.mySetBackground(R.drawable.re_blank2);
				card.setReplace(background[localtion[k++]]);
				addView(card, card_Width, card_Width2);
			}
		}
		addView(textView);
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
