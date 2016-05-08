package com.ydhl.listener;

import com.example.smartchildren.R;
import com.example.smartchildren.R.id;
import com.ydhl.smartchildren.WordActivity;

import android.R.integer;
import android.view.View;
import android.view.View.OnClickListener;

public class WordRankListener implements OnClickListener
{
	private WordActivity wordActivity;
	private int rank;
	public WordRankListener(WordActivity wordActivity)
	{
		this.wordActivity = wordActivity;
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.button1:
			rank = 1;
			break;
		case R.id.button2:
			rank = 2;
			break;
		case R.id.button3:
			rank = 3;
			break;
		case R.id.button4:
			rank = 4;
			break;
		case R.id.button5:
			rank = 5;
			break;
		default:
			break;
		}
		wordActivity.setRank(rank);
		changeActivity();
		
	}

	private void changeActivity()
	{
		switch (rank)
		{
		case 1:
			changeActivity1();
			break;
		case 2:
			changeActivity2();
			break;
		case 3:
			changeActivity3();
			break;
		case 4:
			changeActivity4();
			break;
		case 5:
			changeActivity5();
			break;
		default:
			break;
		}
		clear();
		WordOnClickListener.changeSounds(rank);
	}

	private void clear()
	{
		WordOnClickListener.image1click = false;
		WordOnClickListener.image2click = false;
		WordOnClickListener.image3click = false;
		WordOnClickListener.image4click = false;
		WordOnClickListener.image5click = false;
		WordOnClickListener.image6click = false;
		WordOnClickListener.image7click = false;
		WordOnClickListener.image8click = false;
		WordOnClickListener.image9click = false;
		WordOnClickListener.image10click = false;
	}

	private void changeActivity5()
	{
		wordActivity.getImageButton01().setBackgroundResource(R.drawable.ch5_g_ban);
		wordActivity.getImageButton02().setBackgroundResource(R.drawable.ch5_g_bao);
		wordActivity.getImageButton03().setBackgroundResource(R.drawable.ch5_g_ben);
		wordActivity.getImageButton04().setBackgroundResource(R.drawable.ch5_g_bi);
		wordActivity.getImageButton05().setBackgroundResource(R.drawable.ch5_g_dao);
		wordActivity.getImageButton06().setBackgroundResource(R.drawable.ch5_g_hua);
		wordActivity.getImageButton07().setBackgroundResource(R.drawable.ch5_g_shu);
		wordActivity.getImageButton08().setBackgroundResource(R.drawable.ch5_g_zhi);
		wordActivity.getImageButton09().setBackgroundResource(R.drawable.ch5_g_zhuo);
		wordActivity.getImageButton10().setBackgroundResource(R.drawable.ch5_g_zi);
		
	}

	private void changeActivity4()
	{
		wordActivity.getImageButton01().setBackgroundResource(R.drawable.ch4_t_bing);
		wordActivity.getImageButton02().setBackgroundResource(R.drawable.ch4_t_guang);
		wordActivity.getImageButton03().setBackgroundResource(R.drawable.ch4_t_nan);
		wordActivity.getImageButton04().setBackgroundResource(R.drawable.ch4_t_nv);
		wordActivity.getImageButton05().setBackgroundResource(R.drawable.ch4_t_sha);
		wordActivity.getImageButton06().setBackgroundResource(R.drawable.ch4_t_shan);
		wordActivity.getImageButton07().setBackgroundResource(R.drawable.ch4_t_tian);
		wordActivity.getImageButton08().setBackgroundResource(R.drawable.ch4_t_tiandi);
		wordActivity.getImageButton09().setBackgroundResource(R.drawable.ch4_t_tu);
		wordActivity.getImageButton10().setBackgroundResource(R.drawable.ch4_t_xing);
		
	}

	private void changeActivity3()
	{
		wordActivity.getImageButton01().setBackgroundResource(R.drawable.ch3_g_dian);
		wordActivity.getImageButton02().setBackgroundResource(R.drawable.ch3_g_feng);
		wordActivity.getImageButton03().setBackgroundResource(R.drawable.ch3_g_huo);
		wordActivity.getImageButton04().setBackgroundResource(R.drawable.ch3_g_mu);
		wordActivity.getImageButton05().setBackgroundResource(R.drawable.ch3_g_ri);
		wordActivity.getImageButton06().setBackgroundResource(R.drawable.ch3_g_shi);
		wordActivity.getImageButton07().setBackgroundResource(R.drawable.ch3_g_shui);
		wordActivity.getImageButton08().setBackgroundResource(R.drawable.ch3_g_yu);
		wordActivity.getImageButton09().setBackgroundResource(R.drawable.ch3_g_yue);
		wordActivity.getImageButton10().setBackgroundResource(R.drawable.ch3_g_yun);
		
	}

	private void changeActivity2()
	{
		wordActivity.getImageButton01().setBackgroundResource(R.drawable.ch2_t_black);
		wordActivity.getImageButton02().setBackgroundResource(R.drawable.ch2_t_blue);
		wordActivity.getImageButton03().setBackgroundResource(R.drawable.ch2_t_green);
		wordActivity.getImageButton04().setBackgroundResource(R.drawable.ch2_t_hui);
		wordActivity.getImageButton05().setBackgroundResource(R.drawable.ch2_t_orange);
		wordActivity.getImageButton06().setBackgroundResource(R.drawable.ch2_t_red);
		wordActivity.getImageButton07().setBackgroundResource(R.drawable.ch2_t_white);
		wordActivity.getImageButton08().setBackgroundResource(R.drawable.ch2_t_yellow);
		wordActivity.getImageButton09().setBackgroundResource(R.drawable.ch2_t_zi);
		wordActivity.getImageButton10().setBackgroundResource(R.drawable.ch2_t_zong);
	}

	private void changeActivity1()
	{
		wordActivity.getImageButton01().setBackgroundResource(R.drawable.ch1_card_t_1);
		wordActivity.getImageButton02().setBackgroundResource(R.drawable.ch1_card_t_2);
		wordActivity.getImageButton03().setBackgroundResource(R.drawable.ch1_card_t_3);
		wordActivity.getImageButton04().setBackgroundResource(R.drawable.ch1_card_t_4);
		wordActivity.getImageButton05().setBackgroundResource(R.drawable.ch1_card_t_5);
		wordActivity.getImageButton06().setBackgroundResource(R.drawable.ch1_card_t_6);
		wordActivity.getImageButton07().setBackgroundResource(R.drawable.ch1_card_t_7);
		wordActivity.getImageButton08().setBackgroundResource(R.drawable.ch1_card_t_8);
		wordActivity.getImageButton09().setBackgroundResource(R.drawable.ch1_card_t_9);
		wordActivity.getImageButton10().setBackgroundResource(R.drawable.ch1_card_t_10);
	}

}
