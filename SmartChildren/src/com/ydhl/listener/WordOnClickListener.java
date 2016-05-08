package com.ydhl.listener;

import java.io.IOException;
import java.util.HashMap;

import com.example.smartchildren.R;
import com.ydhl.smartchildren.MainActivity;
import com.ydhl.smartchildren.WordActivity;

import android.R.integer;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.SoundPool;
import android.view.View;
import android.view.View.OnClickListener;

public class WordOnClickListener implements OnClickListener
{
	public static boolean image1click;
	public static  boolean image2click;
	public static  boolean image3click;
	public static  boolean image4click;
	public static  boolean image5click;
	public static  boolean image6click;
	public static  boolean image7click;
	public static  boolean image8click;
	public static  boolean image9click;
	public static  boolean image10click;
	private WordActivity wordActivity;
	private Context context;
	private static AssetManager manager ;
	private AssetFileDescriptor afd;
	private static SoundPool soundPool;
	private static HashMap<Integer, Integer> soundMap;
	
	public WordOnClickListener(WordActivity wordActivity,
			Context context)
	{
		this.wordActivity = wordActivity;
		this.context = context;
		manager = context.getAssets();
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 5);
		soundMap = new HashMap<>();
		initSound();
	}
	private void initSound()
	{
		try
		{
			soundMap.put(1, soundPool.load(manager.openFd("ch1_1.ogg"), 1));
			soundMap.put(2, soundPool.load(manager.openFd("ch1_2.ogg"), 1));
			soundMap.put(3, soundPool.load(manager.openFd("ch1_3.ogg"), 1));
			soundMap.put(4, soundPool.load(manager.openFd("ch1_4.ogg"), 1));
			soundMap.put(5, soundPool.load(manager.openFd("ch1_5.ogg"), 1));
			soundMap.put(6, soundPool.load(manager.openFd("ch1_6.ogg"), 1));
			soundMap.put(7, soundPool.load(manager.openFd("ch1_7.ogg"), 1));
			soundMap.put(8, soundPool.load(manager.openFd("ch1_8.ogg"), 1));
			soundMap.put(9, soundPool.load(manager.openFd("ch1_9.ogg"), 1));
			soundMap.put(10, soundPool.load(manager.openFd("ch1_10.ogg"), 1));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.imageButton1:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_1,R.drawable.ch1_card_z_1,1);
				break;
			case 2:
				reserve(R.drawable.ch2_t_black,R.drawable.ch2_z_black,1);
				break;
			case 3:
				reserve(R.drawable.ch3_g_dian, R.drawable.ch3_z_dian, 1);
				break;
			case 4:
				reserve(R.drawable.ch4_t_bing, R.drawable.ch4_z_bing, 1);
				break;
			case 5:
				reserve(R.drawable.ch5_g_ban, R.drawable.ch5_z_ban, 1);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(1), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton2:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_2,R.drawable.ch1_card_z_2,2);
				break;
			case 2:
				reserve(R.drawable.ch2_t_blue,R.drawable.ch2_z_blue,2);
				break;
			case 3:
				reserve(R.drawable.ch3_g_feng, R.drawable.ch3_z_feng, 2);
				break;
			case 4:
				reserve(R.drawable.ch4_t_guang, R.drawable.ch4_z_guang, 2);
				break;
			case 5:
				reserve(R.drawable.ch5_g_bao, R.drawable.ch5_z_bao, 2);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(2), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton3:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_3,R.drawable.ch1_card_z_3,3);
				break;
			case 2:
				reserve(R.drawable.ch2_t_green,R.drawable.ch2_z_green,3);
				break;
			case 3:
				reserve(R.drawable.ch3_g_huo, R.drawable.ch3_z_huo, 3);
				break;
			case 4:
				reserve(R.drawable.ch4_t_nan, R.drawable.ch4_z_nan, 3);
				break;
			case 5:
				reserve(R.drawable.ch5_g_ben, R.drawable.ch5_z_ben, 3);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(3), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton4:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_4,R.drawable.ch1_card_z_4,4);
				break;
			case 2:
				reserve(R.drawable.ch2_t_hui,R.drawable.ch2_z_hui,4);
				break;
			case 3:
				reserve(R.drawable.ch3_g_mu, R.drawable.ch3_z_mu, 4);
				break;
			case 4:
				reserve(R.drawable.ch4_t_nv, R.drawable.ch4_z_nv, 4);
				break;
			case 5:
				reserve(R.drawable.ch5_g_bi, R.drawable.ch5_z_bi, 4);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(4), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton5:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_5,R.drawable.ch1_card_z_5,5);
				break;
			case 2:
				reserve(R.drawable.ch2_t_orange,R.drawable.ch2_z_orange,5);
				break;
			case 3:
				reserve(R.drawable.ch3_g_ri, R.drawable.ch3_z_ri, 5);
				break;
			case 4:
				reserve(R.drawable.ch4_t_sha, R.drawable.ch4_z_sha, 5);
				break;
			case 5:
				reserve(R.drawable.ch5_g_dao, R.drawable.ch5_z_dao, 5);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(5), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton6:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_6,R.drawable.ch1_card_z_6,6);
				break;
			case 2:
				reserve(R.drawable.ch2_t_red,R.drawable.ch2_z_red,6);
				break;
			case 3:
				reserve(R.drawable.ch3_g_shi, R.drawable.ch3_z_shi, 6);
				break;
			case 4:
				reserve(R.drawable.ch4_t_shan, R.drawable.ch4_z_shan, 6);
				break;
			case 5:
				reserve(R.drawable.ch5_g_hua, R.drawable.ch5_z_hua, 6);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(6), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton7:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_7,R.drawable.ch1_card_z_7,7);
				break;
			case 2:
				reserve(R.drawable.ch2_t_white,R.drawable.ch2_z_white,7);
				break;
			case 3:
				reserve(R.drawable.ch3_g_shui, R.drawable.ch3_z_shui, 7);
				break;
			case 4:
				reserve(R.drawable.ch4_t_tian, R.drawable.ch4_z_tian, 7);
				break;
			case 5:
				reserve(R.drawable.ch5_g_shu, R.drawable.ch5_z_shu, 7);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(7), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton8:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_8,R.drawable.ch1_card_z_8,8);
				break;
			case 2:
				reserve(R.drawable.ch2_t_yellow,R.drawable.ch2_z_yellow,8);
				break;
			case 3:
				reserve(R.drawable.ch3_g_yu, R.drawable.ch3_z_yu, 8);
				break;
			case 4:
				reserve(R.drawable.ch4_t_tiandi, R.drawable.ch4_z_tiandi, 8);
				break;
			case 5:
				reserve(R.drawable.ch5_g_zhi, R.drawable.ch5_z_zhi, 8);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(8), 1, 1, 0, 0, 1);
			break;
		case R.id.imageButton9:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_9,R.drawable.ch1_card_z_9,9);
				break;
			case 2:
				reserve(R.drawable.ch2_t_zi,R.drawable.ch2_z_zi,9);
				break;
			case 3:
				reserve(R.drawable.ch3_g_yue, R.drawable.ch3_z_yue, 9);
				break;
			case 4:
				reserve(R.drawable.ch4_t_tu, R.drawable.ch4_z_tu, 9);
				break;
			case 5:
				reserve(R.drawable.ch5_g_zhuo, R.drawable.ch5_z_zhuo, 9);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(9), 1, 1, 0, 0, 1);
			
			break;
		case R.id.imageButton10:
			switch (wordActivity.getRank())
			{
			case 1:
				reserve(R.drawable.ch1_card_t_10,R.drawable.ch1_card_z_10,10);
				break;
			case 2:
				reserve(R.drawable.ch2_t_zong,R.drawable.ch2_z_zong,10);
				break;
			case 3:
				reserve(R.drawable.ch3_g_yun, R.drawable.ch3_z_yun, 10);
				break;
			case 4:
				reserve(R.drawable.ch4_t_xing, R.drawable.ch4_z_xing, 10);
				break;
			case 5:
				reserve(R.drawable.ch5_g_zi, R.drawable.ch5_z_zi, 10);
				break;
			default:
				break;
			}
			soundPool.play(soundMap.get(10), 1, 1, 0, 0, 1);
			break;
		default:
			break;
		}
		
	}
	private void reserve(int id1,int id2, int buttonId)
	{
		switch (buttonId)
		{
		case 1:
			if (!image1click)
			{
				image1click = true;
				wordActivity.getImageButton01().setBackgroundResource(id2);
			}else {
				image1click = false;
				wordActivity.getImageButton01().setBackgroundResource(id1);
			}
			break;
		case 2:
			if (!image2click)
			{
				image2click = true;
				wordActivity.getImageButton02().setBackgroundResource(id2);
			}else {
				image2click = false;
				wordActivity.getImageButton02().setBackgroundResource(id1);
			}
			break;
		case 3:
			if (!image3click)
			{
				image3click = true;
				wordActivity.getImageButton03().setBackgroundResource(id2);
			}else {
				image3click = false;
				wordActivity.getImageButton03().setBackgroundResource(id1);
			}
			break;
		case 4:
			if (!image4click)
			{
				image4click = true;
				wordActivity.getImageButton04().setBackgroundResource(id2);
			}else {
				image4click = false;
				wordActivity.getImageButton04().setBackgroundResource(id1);
			}
			break;
		case 5:
			if (!image5click)
			{
				image5click = true;
				wordActivity.getImageButton05().setBackgroundResource(id2);
			}else {
				image5click = false;
				wordActivity.getImageButton05().setBackgroundResource(id1);
			}
			break;
		case 6:
			if (!image6click)
			{
				image6click = true;
				wordActivity.getImageButton06().setBackgroundResource(id2);
			}else {
				image6click = false;
				wordActivity.getImageButton06().setBackgroundResource(id1);
			}
			break;
		case 7:
			if (!image7click)
			{
				image7click = true;
				wordActivity.getImageButton07().setBackgroundResource(id2);
			}else {
				image7click = false;
				wordActivity.getImageButton07().setBackgroundResource(id1);
			}
			break;
		case 8:
			if (!image8click)
			{
				image8click = true;
				wordActivity.getImageButton08().setBackgroundResource(id2);
			}else {
				image8click = false;
				wordActivity.getImageButton08().setBackgroundResource(id1);
			}
			break;
		case 9:
			if (!image9click)
			{
				image9click = true;
				wordActivity.getImageButton09().setBackgroundResource(id2);
			}else {
				image9click = false;
				wordActivity.getImageButton09().setBackgroundResource(id1);
			}
			break;
		case 10:
			if (!image10click)
			{
				image10click = true;
				wordActivity.getImageButton10().setBackgroundResource(id2);
			}else {
				image10click = false;
				wordActivity.getImageButton10().setBackgroundResource(id1);
			}
			break;
		default:
			break;
		}
		
	}
	public static void changeSounds(int rank){
		switch (rank)
		{
		case 1:
			try
			{
				soundMap.put(1, soundPool.load(manager.openFd("ch1_1.ogg"), 1));
				soundMap.put(2, soundPool.load(manager.openFd("ch1_2.ogg"), 1));
				soundMap.put(3, soundPool.load(manager.openFd("ch1_3.ogg"), 1));
				soundMap.put(4, soundPool.load(manager.openFd("ch1_4.ogg"), 1));
				soundMap.put(5, soundPool.load(manager.openFd("ch1_5.ogg"), 1));
				soundMap.put(6, soundPool.load(manager.openFd("ch1_6.ogg"), 1));
				soundMap.put(7, soundPool.load(manager.openFd("ch1_7.ogg"), 1));
				soundMap.put(8, soundPool.load(manager.openFd("ch1_8.ogg"), 1));
				soundMap.put(9, soundPool.load(manager.openFd("ch1_9.ogg"), 1));
				soundMap.put(10, soundPool.load(manager.openFd("ch1_10.ogg"), 1));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try
			{
				soundMap.put(1, soundPool.load(manager.openFd("ch2_black.ogg"), 1));
				soundMap.put(2, soundPool.load(manager.openFd("ch2_blue.ogg"), 1));
				soundMap.put(3, soundPool.load(manager.openFd("ch2_green.ogg"), 1));
				soundMap.put(4, soundPool.load(manager.openFd("ch2_hui.ogg"), 1));
				soundMap.put(5, soundPool.load(manager.openFd("ch2_orange.ogg"), 1));
				soundMap.put(6, soundPool.load(manager.openFd("ch2_red.ogg"), 1));
				soundMap.put(7, soundPool.load(manager.openFd("ch2_white.ogg"), 1));
				soundMap.put(8, soundPool.load(manager.openFd("ch2_yellow.ogg"), 1));
				soundMap.put(9, soundPool.load(manager.openFd("ch2_zi.ogg"), 1));
				soundMap.put(10, soundPool.load(manager.openFd("ch2_zong.ogg"), 1));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try
			{
				soundMap.put(1, soundPool.load(manager.openFd("ch3_y_dian.ogg"), 1));
				soundMap.put(2, soundPool.load(manager.openFd("ch3_y_feng.ogg"), 1));
				soundMap.put(3, soundPool.load(manager.openFd("ch3_y_huo.ogg"), 1));
				soundMap.put(4, soundPool.load(manager.openFd("ch3_y_mu.ogg"), 1));
				soundMap.put(5, soundPool.load(manager.openFd("ch3_y_ri.ogg"), 1));
				soundMap.put(6, soundPool.load(manager.openFd("ch3_y_shi.ogg"), 1));
				soundMap.put(7, soundPool.load(manager.openFd("ch3_y_shui.ogg"), 1));
				soundMap.put(8, soundPool.load(manager.openFd("ch3_y_yu.ogg"), 1));
				soundMap.put(9, soundPool.load(manager.openFd("ch3_y_yue.ogg"), 1));
				soundMap.put(10, soundPool.load(manager.openFd("ch3_y_yun.ogg"), 1));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			try
			{
				soundMap.put(1, soundPool.load(manager.openFd("ch4_y_bing.ogg"), 1));
				soundMap.put(2, soundPool.load(manager.openFd("ch4_y_guang.ogg"), 1));
				soundMap.put(3, soundPool.load(manager.openFd("ch4_y_nan.ogg"), 1));
				soundMap.put(4, soundPool.load(manager.openFd("ch4_y_nv.ogg"), 1));
				soundMap.put(5, soundPool.load(manager.openFd("ch4_y_sha.ogg"), 1));
				soundMap.put(6, soundPool.load(manager.openFd("ch4_y_shan.ogg"), 1));
				soundMap.put(7, soundPool.load(manager.openFd("ch4_y_tian.ogg"), 1));
				soundMap.put(8, soundPool.load(manager.openFd("ch4_y_tiandi.ogg"), 1));
				soundMap.put(9, soundPool.load(manager.openFd("ch4_y_tu.ogg"), 1));
				soundMap.put(10, soundPool.load(manager.openFd("ch4_y_xing.ogg"), 1));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			try
			{
				soundMap.put(1, soundPool.load(manager.openFd("ch5_y_ban.ogg"), 1));
				soundMap.put(2, soundPool.load(manager.openFd("ch5_y_bao.ogg"), 1));
				soundMap.put(3, soundPool.load(manager.openFd("ch5_y_ben.ogg"), 1));
				soundMap.put(4, soundPool.load(manager.openFd("ch5_y_bi.ogg"), 1));
				soundMap.put(5, soundPool.load(manager.openFd("ch5_y_dao.ogg"), 1));
				soundMap.put(6, soundPool.load(manager.openFd("ch5_y_hua.ogg"), 1));
				soundMap.put(7, soundPool.load(manager.openFd("ch5_y_shu.ogg"), 1));
				soundMap.put(8, soundPool.load(manager.openFd("ch5_y_zhi.ogg"), 1));
				soundMap.put(9, soundPool.load(manager.openFd("ch5_y_zhuo.ogg"), 1));
				soundMap.put(10, soundPool.load(manager.openFd("ch5_y_zi.ogg"), 1));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

}
