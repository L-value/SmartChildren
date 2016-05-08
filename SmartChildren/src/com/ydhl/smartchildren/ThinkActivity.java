package com.ydhl.smartchildren;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartchildren.R;
import com.ydhl.bean.PlayTime;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.MyHttpListener;
import com.ydhl.utils.DBManager;
import com.ydhl.utils.MyHttpUtils;

public class ThinkActivity extends BaseActivity implements OnClickListener
{
	private Button considerb1;
	private Button considerb2;
	private Button considerb3;
	private Button considerb4;
	private Button considerb5;
	private Button consider11;
	private Button consider22;
	private Button consider33;
	private Button consider44;
	private TextView textView;
	private FrameLayout ro1;
	private FrameLayout ro2;
	private FrameLayout ro3;
	private FrameLayout ro4;
	private AnimationDrawable animationDrawable1;
	private AnimationDrawable animationDrawable2;
	private AnimationDrawable animationDrawable3;
	private AnimationDrawable animationDrawable4;
	private Animation buttonAnimationto;
	private Animation buttonAnimationcome;
	private boolean isFirst1;
	private boolean isFirst2;
	private boolean isFirst3;
	private boolean isFirst4;
	private boolean f1;
	private boolean f2;
	private boolean f3;
	private boolean f4;
	private int i1 = 2;
	private int i2 = 2;
	private int i3 = 2;
	private int i4 = 2;
	private int choose;
	private Random random = new Random();
	private int[] images1 = new int[] { R.drawable.consider_cat_01,
			R.drawable.consider_cheetah_01, R.drawable.consider_chicken_01,
			R.drawable.consider_cow_01 };
	private int[] images2 = new int[] { R.drawable.consider_cat_02,
			R.drawable.consider_cheetah_02, R.drawable.consider_chicken_02,
			R.drawable.consider_cow_02 };
	private int[] images3 = new int[] { R.drawable.consider_cat_03,
			R.drawable.consider_cheetah_03, R.drawable.consider_chicken_03,
			R.drawable.consider_cow_03 };
	private int[] images4 = new int[] { R.drawable.consider_cat_04,
			R.drawable.consider_cheetah_04, R.drawable.consider_chicken_04,
			R.drawable.consider_cow_04 };
	private int[] images5 = new int[] { R.drawable.consider_cat,
			R.drawable.consider_cheetah, R.drawable.consider_chicken,
			R.drawable.consider_cow };
	private int[] animalSound = new int[] { R.raw.cat, R.raw.cheetah,
			R.raw.chicken, R.raw.cow };
	private int location[] = new int[4];
	private int[] imageGet1;
	private int[] imageGet2;
	private int[] imageGet3;
	private int[] imageGet4;
	private boolean flag1;
	private boolean flag2;
	private boolean flag3;
	private boolean flag4;
	private MediaPlayer mediaPlayer1;
	private MediaPlayer mediaPlayer2;
	private MediaPlayer mediaPlayer3;
	private int which = 0;
	private int score = 0;
	private float currentX;
	private float currentY;
	private float nextX;
	private float nextY;
	private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	private boolean seeable;
	private DBManager dbManager;
	private boolean isFirstPlay = true;
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	private Handler handler = new Handler()
	{
		public void handleMessage(android.os.Message msg)
		{
			if (msg.what == 1)
			{
				if (!seeable)
				{
					imageView1.setVisibility(View.VISIBLE);
					imageView2.setVisibility(View.VISIBLE);
					imageView3.setVisibility(View.VISIBLE);
				}
				if (nextX >= 1000)
				{
					currentX = nextX = 0;
					imageView1.setVisibility(View.GONE);
					imageView2.setVisibility(View.GONE);
					imageView3.setVisibility(View.GONE);
					seeable = false;
				} else
				{
					nextX += 12;
				}
				if (nextX >= 900)
				{
					imageView1.setVisibility(View.GONE);
					imageView2.setVisibility(View.GONE);
					imageView3.setVisibility(View.GONE);
					seeable = true;
				}
				nextY = currentY + (float) (Math.random() * 10 - 5);
				TranslateAnimation animation = new TranslateAnimation(currentX,
						nextX, currentY, nextY);
				currentX = nextX;
				currentY = nextY;
				animation.setDuration(200);
				imageView1.startAnimation(animation);
				imageView2.startAnimation(animation);
				imageView3.startAnimation(animation);
			}
		};
	};
	private String end_time;
	private String begin_time;

	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_think);
		dbManager = new DBManager(this,application.getUserName());
		SimpleDateFormat df = new SimpleDateFormat("HH.mm");// 设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		begin_time = df.format(new Date());
		considerb1 = (Button) findViewById(R.id.considerb1);
		considerb2 = (Button) findViewById(R.id.considerb2);
		considerb3 = (Button) findViewById(R.id.considerb3);
		considerb4 = (Button) findViewById(R.id.considerb4);
		consider11 = (Button) findViewById(R.id.considerb11);
		consider22 = (Button) findViewById(R.id.considerb22);
		consider33 = (Button) findViewById(R.id.considerb33);
		consider44 = (Button) findViewById(R.id.considerb44);
		considerb5 = (Button) findViewById(R.id.button1);
		textView = (TextView) findViewById(R.id.textView1);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView3 = (ImageView) findViewById(R.id.imageView3);
		ro1 = (FrameLayout) findViewById(R.id.ro1);
		ro2 = (FrameLayout) findViewById(R.id.ro2);
		ro3 = (FrameLayout) findViewById(R.id.ro3);
		ro4 = (FrameLayout) findViewById(R.id.ro4);
		animationDrawable1 = (AnimationDrawable) ro1.getBackground();
		animationDrawable2 = (AnimationDrawable) ro2.getBackground();
		animationDrawable3 = (AnimationDrawable) ro3.getBackground();
		animationDrawable4 = (AnimationDrawable) ro4.getBackground();
		buttonAnimationto = AnimationUtils.loadAnimation(this,
				R.anim.rollanima_to);
		buttonAnimationcome = AnimationUtils.loadAnimation(this,
				R.anim.rollanim_come);
		mediaPlayer1 = MediaPlayer.create(this, animalSound[which]);
		mediaPlayer2 = MediaPlayer.create(this, R.raw.wood_click1);
		mediaPlayer3 = MediaPlayer.create(this, R.raw.aplauz_2sec);
		sharedPreferences = getSharedPreferences("isFirst", MODE_PRIVATE);
		isFirstPlay = sharedPreferences.getBoolean("isFirstt", true);
	}

	@Override
	public void initView()
	{
		for (int i = 0; i < 4; i++)
		{
			location[i] = random.nextInt(4);
			check(i);
		}
		imageGet1 = new int[] { images1[location[1]], images1[location[0]],
				images1[location[2]], images1[location[3]], };
		imageGet2 = new int[] { images2[location[2]], images2[location[0]],
				images2[location[1]], images2[location[3]], };
		imageGet3 = new int[] { images3[location[3]], images3[location[0]],
				images3[location[1]], images3[location[2]], };
		imageGet4 = new int[] { images4[location[2]], images4[location[1]],
				images4[location[0]], images4[location[3]], };
		considerb1.setBackgroundResource(imageGet1[0]);
		consider11.setBackgroundResource(imageGet1[1]);
		considerb2.setBackgroundResource(imageGet2[0]);
		consider22.setBackgroundResource(imageGet2[1]);
		considerb3.setBackgroundResource(imageGet3[0]);
		consider33.setBackgroundResource(imageGet3[1]);
		considerb4.setBackgroundResource(imageGet4[0]);
		consider44.setBackgroundResource(imageGet4[1]);
		if (imageGet1[0] == images1[which])
		{
			flag1 = true;
		} else
		{
			flag1 = false;
		}
		if (imageGet2[0] == images2[which])
		{
			flag2 = true;
		} else
		{
			flag2 = false;
		}
		if (imageGet3[0] == images3[which])
		{
			flag3 = true;
		} else
		{
			flag3 = false;
		}
		if (imageGet4[0] == images4[which])
		{
			flag4 = true;
		}
	}

	private void check(int i)
	{
		for (int j = 0; j < i; j++)
		{
			if (location[i] == location[j])
			{
				location[i] = random.nextInt(4);
				check(i);
			}
		}

	}

	@Override
	public void initListeners()
	{
		buttonAnimationto.setAnimationListener(new AnimationListener()
		{

			@Override
			public void onAnimationStart(Animation animation)
			{

			}

			@Override
			public void onAnimationRepeat(Animation animation)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation)
			{
				switch (choose)
				{
				case 1:
					if (!f1)
					{
						considerb1.setVisibility(View.GONE);
						considerb1.setBackgroundResource(imageGet1[i1++ % 4]);
						f1 = true;
					} else
					{
						f1 = false;
						consider11.setVisibility(View.GONE);
						consider11.setBackgroundResource(imageGet1[i1++ % 4]);

					}
					System.out.println(imageGet1[(i1 - 1) % 4]);
					System.out.println(images1[0]);
					if (imageGet1[(i1 - 2) % 4] == images1[which])
					{
						flag1 = true;
					} else
					{
						flag1 = false;
					}
					break;
				case 2:
					if (!f2)
					{
						considerb2.setVisibility(View.GONE);
						considerb2.setBackgroundResource(imageGet2[i2++ % 4]);
						f2 = true;
					} else
					{
						f2 = false;
						consider22.setVisibility(View.GONE);
						consider22.setBackgroundResource(imageGet2[i2++ % 4]);
					}
					if (imageGet2[(i2 - 2) % 4] == images2[which])
					{
						flag2 = true;
					} else
					{
						flag2 = false;
					}

					break;
				case 3:
					if (!f3)
					{
						considerb3.setVisibility(View.GONE);
						considerb3.setBackgroundResource(imageGet3[i3++ % 4]);
						f3 = true;
					} else
					{
						f3 = false;
						consider33.setVisibility(View.GONE);
						consider33.setBackgroundResource(imageGet3[i3++ % 4]);
					}
					if (imageGet3[(i3 - 2) % 4] == images3[which])
					{
						flag3 = true;
					} else
					{
						flag3 = false;
					}

					break;
				case 4:
					if (!f4)
					{
						considerb4.setVisibility(View.GONE);
						considerb4.setBackgroundResource(imageGet4[i4++ % 4]);
						f4 = true;
					} else
					{
						f4 = false;
						consider44.setVisibility(View.GONE);
						consider44.setBackgroundResource(imageGet4[i4++ % 4]);
					}
					if (imageGet4[(i4 - 2) % 4] == images4[which])
					{
						flag4 = true;
					} else
					{
						flag4 = false;
					}

					break;
				default:
					break;
				}
				checkSuccee();

			}

			private void checkSuccee()
			{
				System.out.println(flag1);
				System.out.println(flag2);
				System.out.println(flag3);
				System.out.println(flag4);
				if (flag1 && flag2 && flag3 && flag4)
				{
					Toast.makeText(ThinkActivity.this, "succee", 1000).show();
					score++;
					mediaPlayer3.start();
					int old = which;
					which = random.nextInt(4);
					which = which == old ? random.nextInt(4) : which;
					considerb5.setBackgroundResource(images5[which]);
					mediaPlayer1 = MediaPlayer.create(ThinkActivity.this,
							animalSound[which]);
					flag1 = false;
					flag2 = false;
					flag3 = false;
					flag4 = false;
					textView.setText("分数为:" + score);

					Thread thread = new Thread()
					{
						@Override
						public void run()
						{
							while (nextX < 1000)
							{
								try
								{
									Thread.sleep(20);
								} catch (InterruptedException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								handler.sendEmptyMessage(1);
							}
							// super.run();
						}
					};
					thread.start();
				}
			}
		});

		considerb1.setOnClickListener(this);
		considerb2.setOnClickListener(this);
		considerb3.setOnClickListener(this);
		considerb4.setOnClickListener(this);
		consider11.setOnClickListener(this);
		consider22.setOnClickListener(this);
		consider33.setOnClickListener(this);
		consider44.setOnClickListener(this);
		considerb5.setOnClickListener(this);
		// considerb5.setOnClickListener(this);
	}

	@Override
	public void initData()
	{
		
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.considerb1:
			if (!isFirst1)
			{
				isFirst1 = true;
				animationDrawable1.start();
			} else
			{
				animationDrawable1.stop();
				animationDrawable1.start();
			}
			choose = 1;
			considerb1.startAnimation(buttonAnimationto);
			consider11.setVisibility(View.VISIBLE);
			consider11.startAnimation(buttonAnimationcome);
			// considerb1.startAnimation(buttonAnimationto);
			break;
		case R.id.considerb11:
			animationDrawable1.stop();
			animationDrawable1.start();
			choose = 1;
			consider11.startAnimation(buttonAnimationto);
			considerb1.setVisibility(View.VISIBLE);
			considerb1.startAnimation(buttonAnimationcome);
			break;
		case R.id.considerb2:
			if (!isFirst2)
			{
				isFirst2 = true;
				animationDrawable2.start();
			} else
			{
				animationDrawable2.stop();
				animationDrawable2.start();
			}
			choose = 2;
			considerb2.startAnimation(buttonAnimationto);
			consider22.setVisibility(View.VISIBLE);
			consider22.startAnimation(buttonAnimationcome);
			// considerb1.startAnimation(buttonAnimationto);
			break;
		case R.id.considerb22:
			animationDrawable2.stop();
			animationDrawable2.start();
			choose = 2;
			consider22.startAnimation(buttonAnimationto);
			considerb2.setVisibility(View.VISIBLE);
			considerb2.startAnimation(buttonAnimationcome);
			break;
		case R.id.considerb3:
			if (!isFirst3)
			{
				isFirst3 = true;
				animationDrawable3.start();
			} else
			{
				animationDrawable3.stop();
				animationDrawable3.start();
			}
			choose = 3;
			considerb3.startAnimation(buttonAnimationto);
			consider33.setVisibility(View.VISIBLE);
			consider33.startAnimation(buttonAnimationcome);
			// considerb1.startAnimation(buttonAnimationto);
			break;
		case R.id.considerb33:
			animationDrawable3.stop();
			animationDrawable3.start();
			choose = 3;
			consider33.startAnimation(buttonAnimationto);
			considerb3.setVisibility(View.VISIBLE);
			considerb3.startAnimation(buttonAnimationcome);
			break;
		case R.id.considerb4:
			if (!isFirst4)
			{
				isFirst4 = true;
				animationDrawable4.start();
			} else
			{
				animationDrawable4.stop();
				animationDrawable4.start();
			}
			choose = 4;
			considerb4.startAnimation(buttonAnimationto);
			consider44.setVisibility(View.VISIBLE);
			consider44.startAnimation(buttonAnimationcome);

			break;
		case R.id.considerb44:
			animationDrawable4.stop();
			animationDrawable4.start();
			choose = 4;
			consider44.startAnimation(buttonAnimationto);
			considerb4.setVisibility(View.VISIBLE);
			considerb4.startAnimation(buttonAnimationcome);
			break;
		case R.id.button1:
			mediaPlayer1.start();
			break;
		default:
			break;
		}
		mediaPlayer2.start();
	}

	@Override
	protected void onDestroy()
	{
		SimpleDateFormat df = new SimpleDateFormat("HH.mm");// 设置日期格式
		System.out.println(df.format(new Date()) + "aa");// new Date()为获取当前系统时间
		end_time = df.format(new Date());
		MyHttpUtils myHttpUtils = new MyHttpUtils("POST",
				new PlayTime(begin_time + "~" + end_time, null, null, score
						+ "", null, null),
				"http://zcs.svnt.ml/rzet/Client_Interface.php",
				new MyHttpListener()
				{

					@Override
					public void onSuccess(String content)
					{
						System.out.println(content);

					}

					@Override
					public void onFailed(String content)
					{
						System.exit(0);
					}
				});
		myHttpUtils.DoRequestByHttpUrlConnection();
		if (isFirstPlay)
		{
			ContentValues contentValues = new ContentValues();
			contentValues.put("high", score);
			contentValues.put("low", score);
			dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"ThinkGame"});
			editor = sharedPreferences.edit();
			editor.putBoolean("isFirstt", false);
			editor.commit();
		}else {
			int oldHighscore = 0;
			int oldLowscore = 0;
			Cursor cursor = dbManager.query(application.getUserName(), null, "_id = 'ThinkGame'", null, null,
					null, null, null);
			while (cursor.moveToNext())
			{
				oldHighscore = cursor.getInt(cursor.getColumnIndex("high"));
				oldLowscore = cursor.getInt(cursor.getColumnIndex("low"));
			}
			if (oldHighscore <= score)
			{
				ContentValues contentValues = new ContentValues();
				contentValues.put("high", score);
				contentValues.put("low", oldLowscore);
				dbManager.upData(application.getUserName(), contentValues, "_id = ?",new String[]{"ThinkGame"});
			} else if (oldLowscore >= score)
			{
				ContentValues contentValues = new ContentValues();
				contentValues.put("high", oldHighscore);
				contentValues.put("low", score);
				dbManager.upData(application.getUserName(), contentValues, "_id = ?", new String[]{"ThinkGame"});
			}
		}
	
		super.onDestroy();
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
