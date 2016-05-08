package com.ydhl.smartchildren;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.example.smartchildren.R.menu;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.WordOnClickListener;
import com.ydhl.listener.WordRankListener;
import com.ydhl.utils.MyHttpUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class WordActivity extends BaseActivity
{
	private ImageButton imageButton01;
	private ImageButton imageButton02;
	private ImageButton imageButton03;
	private ImageButton imageButton04;
	private ImageButton imageButton05;
	private ImageButton imageButton06;
	private ImageButton imageButton07;
	private ImageButton imageButton08;
	private ImageButton imageButton09;
	private ImageButton imageButton10;
	private Button button01;
	private Button button02;
	private Button button03;
	private Button button04;
	private Button button05;
	private Button buttonGameing;
	private int rank = 1;

	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_word);
		setImageButton01((ImageButton) findViewById(R.id.imageButton1));
		setImageButton02((ImageButton) findViewById(R.id.imageButton2));
		setImageButton03((ImageButton) findViewById(R.id.imageButton3));
		setImageButton04((ImageButton) findViewById(R.id.imageButton4));
		setImageButton05((ImageButton) findViewById(R.id.imageButton5));
		setImageButton06((ImageButton) findViewById(R.id.imageButton6));
		setImageButton07((ImageButton) findViewById(R.id.imageButton7));
		setImageButton08((ImageButton) findViewById(R.id.imageButton8));
		setImageButton09((ImageButton) findViewById(R.id.imageButton9));
		setImageButton10((ImageButton) findViewById(R.id.imageButton10));
		setButton01((Button) findViewById(R.id.button1));
		setButton02((Button) findViewById(R.id.button2));
		setButton03((Button) findViewById(R.id.button3));
		setButton04((Button) findViewById(R.id.button4));
		setButton05((Button) findViewById(R.id.button5));
		buttonGameing = (Button) findViewById(R.id.gaming);
		
	}
	@Override
	public void initView()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initListeners()
	{
		button01.setOnClickListener(new WordRankListener(this));
		button02.setOnClickListener(new WordRankListener(this));
		button03.setOnClickListener(new WordRankListener(this));
		button04.setOnClickListener(new WordRankListener(this));
		button05.setOnClickListener(new WordRankListener(this));
		imageButton01.setOnClickListener(new WordOnClickListener(this,this));
		imageButton02.setOnClickListener(new WordOnClickListener(this,this));
		imageButton03.setOnClickListener(new WordOnClickListener(this,this));
		imageButton04.setOnClickListener(new WordOnClickListener(this,this));
		imageButton05.setOnClickListener(new WordOnClickListener(this,this));
		imageButton06.setOnClickListener(new WordOnClickListener(this,this));
		imageButton07.setOnClickListener(new WordOnClickListener(this,this));
		imageButton08.setOnClickListener(new WordOnClickListener(this,this));
		imageButton09.setOnClickListener(new WordOnClickListener(this,this));
		imageButton10.setOnClickListener(new WordOnClickListener(this,this));
		buttonGameing.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(WordActivity.this, WordGameActivity.class);
				WordActivity.this.startActivity(intent);
			}
		});
	}
	@Override
	public void initData()
	{
	
		
	}
	public ImageButton getImageButton01()
	{
		return imageButton01;
	}
	public void setImageButton01(ImageButton imageButton01)
	{
		this.imageButton01 = imageButton01;
	}
	public ImageButton getImageButton02()
	{
		return imageButton02;
	}
	public void setImageButton02(ImageButton imageButton02)
	{
		this.imageButton02 = imageButton02;
	}
	public ImageButton getImageButton03()
	{
		return imageButton03;
	}
	public void setImageButton03(ImageButton imageButton03)
	{
		this.imageButton03 = imageButton03;
	}
	public ImageButton getImageButton04()
	{
		return imageButton04;
	}
	public void setImageButton04(ImageButton imageButton04)
	{
		this.imageButton04 = imageButton04;
	}
	public ImageButton getImageButton05()
	{
		return imageButton05;
	}
	public void setImageButton05(ImageButton imageButton05)
	{
		this.imageButton05 = imageButton05;
	}
	public ImageButton getImageButton06()
	{
		return imageButton06;
	}
	public void setImageButton06(ImageButton imageButton06)
	{
		this.imageButton06 = imageButton06;
	}
	public ImageButton getImageButton07()
	{
		return imageButton07;
	}
	public void setImageButton07(ImageButton imageButton07)
	{
		this.imageButton07 = imageButton07;
	}
	public ImageButton getImageButton08()
	{
		return imageButton08;
	}
	public void setImageButton08(ImageButton imageButton08)
	{
		this.imageButton08 = imageButton08;
	}
	public ImageButton getImageButton09()
	{
		return imageButton09;
	}
	public void setImageButton09(ImageButton imageButton09)
	{
		this.imageButton09 = imageButton09;
	}
	public ImageButton getImageButton10()
	{
		return imageButton10;
	}
	public void setImageButton10(ImageButton imageButton10)
	{
		this.imageButton10 = imageButton10;
	}
	public Button getButton01()
	{
		return button01;
	}
	public void setButton01(Button button01)
	{
		this.button01 = button01;
	}
	public Button getButton02()
	{
		return button02;
	}
	public void setButton02(Button button02)
	{
		this.button02 = button02;
	}
	public Button getButton03()
	{
		return button03;
	}
	public void setButton03(Button button03)
	{
		this.button03 = button03;
	}
	public Button getButton04()
	{
		return button04;
	}
	public void setButton04(Button button04)
	{
		this.button04 = button04;
	}
	public Button getButton05()
	{
		return button05;
	}
	public void setButton05(Button button05)
	{
		this.button05 = button05;
	}
	public int getRank()
	{
		return rank;
	}
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
	
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			finish();
			overridePendingTransition(R.anim.game_back, R.anim.game_go);
		}
		return false;
	}
	
}
