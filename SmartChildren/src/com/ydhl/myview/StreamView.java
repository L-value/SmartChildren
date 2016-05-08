package com.ydhl.myview;

import java.util.HashMap;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import com.example.smartchildren.R;
import com.ydhl.mylog.MyLog;

public class StreamView extends View
{
	Paint paint = new Paint();
	private Bitmap fixedMapBitmap;
	private Bitmap streamBitmap1;
	private Bitmap streamBitmap2;
	private Bitmap streamBitmap3;	
	private SoundPool soundPool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
	private HashMap<Integer, Integer> soundMap = new HashMap<>();
	private int y = 0;
	private float touchX;
	private float touchY;
	private Context context;
	private int fix;
	private int answer;
	private int score = 0;
	private long speed = 20;
	private boolean threadStop;
	private int[] zImages = new int[] { R.drawable.ch1_card_z_1,
			R.drawable.ch1_card_z_2, R.drawable.ch1_card_z_3,
			R.drawable.ch1_card_z_4, R.drawable.ch1_card_z_5,
			R.drawable.ch1_card_z_6, R.drawable.ch1_card_z_7,
			R.drawable.ch1_card_z_8, R.drawable.ch1_card_z_9,
			R.drawable.ch1_card_z_10, R.drawable.ch2_z_black,
			R.drawable.ch2_z_blue, R.drawable.ch2_z_green,
			R.drawable.ch2_z_hui, R.drawable.ch2_z_orange,
			R.drawable.ch2_z_red, R.drawable.ch2_z_white,
			R.drawable.ch2_z_yellow, R.drawable.ch2_z_zi,
			R.drawable.ch2_z_zong, R.drawable.ch3_z_dian,
			R.drawable.ch3_z_feng, R.drawable.ch3_z_huo, R.drawable.ch3_z_mu,
			R.drawable.ch3_z_ri, R.drawable.ch3_z_shi, R.drawable.ch3_z_shui,
			R.drawable.ch3_z_yu, R.drawable.ch3_z_yue, R.drawable.ch3_z_yun,
			R.drawable.ch4_z_bing, R.drawable.ch4_z_guang,
			R.drawable.ch4_z_nan, R.drawable.ch4_z_nv, R.drawable.ch4_z_sha,
			R.drawable.ch4_z_shan, R.drawable.ch4_z_tian,
			R.drawable.ch4_z_tiandi, R.drawable.ch4_z_tu,
			R.drawable.ch4_z_xing, R.drawable.ch5_z_ban, R.drawable.ch5_z_bao,
			R.drawable.ch5_z_ben, R.drawable.ch5_z_bi, R.drawable.ch5_z_dao,
			R.drawable.ch5_z_hua, R.drawable.ch5_z_shu, R.drawable.ch5_z_zhi,
			R.drawable.ch5_z_zhuo, R.drawable.ch5_z_zi, };
	private int[] tImages = new int[] { R.drawable.ch1_card_t_1,
			R.drawable.ch1_card_t_2, R.drawable.ch1_card_t_3,
			R.drawable.ch1_card_t_4, R.drawable.ch1_card_t_5,
			R.drawable.ch1_card_t_6, R.drawable.ch1_card_t_7,
			R.drawable.ch1_card_t_8, R.drawable.ch1_card_t_9,
			R.drawable.ch1_card_t_10, R.drawable.ch2_t_black,
			R.drawable.ch2_t_blue, R.drawable.ch2_t_green,
			R.drawable.ch2_t_hui, R.drawable.ch2_t_orange,
			R.drawable.ch2_t_red, R.drawable.ch2_t_white,
			R.drawable.ch2_t_yellow, R.drawable.ch2_t_zi,
			R.drawable.ch2_t_zong, R.drawable.ch3_g_dian,
			R.drawable.ch3_g_feng, R.drawable.ch3_g_huo, R.drawable.ch3_g_mu,
			R.drawable.ch3_g_ri, R.drawable.ch3_g_shi, R.drawable.ch3_g_shui,
			R.drawable.ch3_g_yu, R.drawable.ch3_g_yue, R.drawable.ch3_g_yun,
			R.drawable.ch4_t_bing, R.drawable.ch4_t_guang,
			R.drawable.ch4_t_nan, R.drawable.ch4_t_nv, R.drawable.ch4_t_sha,
			R.drawable.ch4_t_shan, R.drawable.ch4_t_tian,
			R.drawable.ch4_t_tiandi, R.drawable.ch4_t_tu,
			R.drawable.ch4_t_xing, R.drawable.ch5_g_ban, R.drawable.ch5_g_bao,
			R.drawable.ch5_g_ben, R.drawable.ch5_g_bi, R.drawable.ch5_g_dao,
			R.drawable.ch5_g_hua, R.drawable.ch5_g_shu, R.drawable.ch5_g_zhi,
			R.drawable.ch5_g_zhuo, R.drawable.ch5_g_zi, };
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if (y == 1000)
			{
				MyLog.i("1000 begin");
				y = 0;
				answer = new Random().nextInt(3) + 1;
				fix = new Random().nextInt(50);
				speed = 20;
				fixedMapBitmap = BitmapFactory.decodeResource(
						context.getResources(), tImages[fix]);
				switch (answer)
				{
				case 1:
					streamBitmap1 = BitmapFactory.decodeResource(
							context.getResources(), zImages[fix]);
					streamBitmap2 = BitmapFactory.decodeResource(
							context.getResources(),
							zImages[new Random().nextInt(50)]);
					streamBitmap3 = BitmapFactory.decodeResource(
							context.getResources(),
							zImages[new Random().nextInt(50)]);
					break;
				case 2:
					streamBitmap1 = BitmapFactory.decodeResource(
							context.getResources(),
							zImages[new Random().nextInt(50)]);
					streamBitmap2 = BitmapFactory.decodeResource(
							context.getResources(), zImages[fix]);
					streamBitmap3 = BitmapFactory.decodeResource(
							context.getResources(),
							zImages[new Random().nextInt(50)]);
					break;
				case 3:
					streamBitmap1 = BitmapFactory.decodeResource(
							context.getResources(),
							zImages[new Random().nextInt(50)]);
					streamBitmap2 = BitmapFactory.decodeResource(
							context.getResources(),
							zImages[new Random().nextInt(50)]);
					streamBitmap3 = BitmapFactory.decodeResource(
							context.getResources(), zImages[fix]);
					break;
				default:
					break;
				}
				if (threadStop)
				{
					setFlowThread(new FlowThread());
					getFlowThread().start();
				}
			}
			MyLog.t(y);
			invalidate();
		};
	};
	private FlowThread flowThread;
	private int sizeWidth;
	private int sizeHeight;

	public StreamView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	
		answer = new Random().nextInt(3) + 1;
		fix = new Random().nextInt(50);
		this.context = context;
		fixedMapBitmap = BitmapFactory.decodeResource(context.getResources(),
				tImages[fix]);
		switch (answer)
		{
		case 1:
			streamBitmap1 = BitmapFactory.decodeResource(
					context.getResources(), zImages[fix]);
			streamBitmap2 = BitmapFactory.decodeResource(
					context.getResources(), zImages[new Random().nextInt(50)]);
			streamBitmap3 = BitmapFactory.decodeResource(
					context.getResources(), zImages[new Random().nextInt(50)]);
			break;
		case 2:
			streamBitmap1 = BitmapFactory.decodeResource(
					context.getResources(), zImages[new Random().nextInt(50)]);
			streamBitmap2 = BitmapFactory.decodeResource(
					context.getResources(), zImages[fix]);
			streamBitmap3 = BitmapFactory.decodeResource(
					context.getResources(), zImages[new Random().nextInt(50)]);
			break;
		case 3:
			streamBitmap1 = BitmapFactory.decodeResource(
					context.getResources(), zImages[new Random().nextInt(50)]);
			streamBitmap2 = BitmapFactory.decodeResource(
					context.getResources(), zImages[new Random().nextInt(50)]);
			streamBitmap3 = BitmapFactory.decodeResource(
					context.getResources(), zImages[fix]);
			break;
		default:
			break;
		}

		setFlowThread(new FlowThread());
		getFlowThread().start();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
		sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
		int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
		int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
		System.out.println(sizeHeight);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		paint.setTextSize(80);
		canvas.drawText("·ÖÊý£º", 1300, 60, paint);
		canvas.drawText(Integer.toString(getScore()), 1550, 60, paint);
		canvas.drawBitmap(fixedMapBitmap, 0, 200, paint);
		canvas.drawBitmap(streamBitmap1, sizeWidth - 1200, y + 20, paint);
		canvas.drawBitmap(streamBitmap2, sizeWidth - 800, y, paint);
		canvas.drawBitmap(streamBitmap3, sizeWidth - 400, y + 60, paint);
	}

	public class FlowThread extends Thread
	{

		@Override
		public void run()
		{
			while (y < 1000)
			{
				y++;
				try
				{
					Thread.sleep(speed);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Message message = Message.obtain();
				handler.sendMessage(message);
			}
			threadStop = true;
			setFlowThread(null);
			// super.run();
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		switch (event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			touchX = event.getX();
			touchY = event.getY();
			if (sizeWidth - 1200 <= touchX && touchX <= sizeWidth - 1200 + streamBitmap1.getWidth()
					&& y + 20 <= touchY
					&& touchY <= y + 20 + streamBitmap1.getHeight()
					&& answer == 1)
			{
				streamBitmap1 = BitmapFactory.decodeResource(
						context.getResources(), R.drawable.success);
				setScore(getScore() + 1);
				speed = 2;
			} else if (sizeWidth - 800 <= touchX
					&& touchX <= sizeWidth - 800 + streamBitmap2.getWidth() && y <= touchY
					&& touchY <= y + streamBitmap2.getHeight() && answer == 2)
			{
				streamBitmap2 = BitmapFactory.decodeResource(
						context.getResources(), R.drawable.success);
				setScore(getScore() + 1);
				speed = 2;
			} else if (sizeWidth - 400 <= touchX
					&& touchX <= sizeWidth - 400 + streamBitmap3.getWidth()
					&& y + 60 <= touchY
					&& touchY <= y + 60 + streamBitmap3.getHeight()
					&& answer == 3)
			{
				streamBitmap3 = BitmapFactory.decodeResource(
						context.getResources(), R.drawable.success);
				setScore(getScore() + 1);
				speed = 2;
			}
			if (0 <= touchX && touchX <= fixedMapBitmap.getWidth() && 200 <= y
					&& y >= 200 + fixedMapBitmap.getHeight())
			{

			}
			System.out.println(answer);
			break;
		default:
			break;
		}
		return true;
	}

	public FlowThread getFlowThread()
	{
		return flowThread;
	}

	public void setFlowThread(FlowThread flowThread)
	{
		this.flowThread = flowThread;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_BACK:
			flowThread = null;
			break;

		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

}
