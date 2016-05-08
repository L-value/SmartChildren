package com.ydhl.smartchildren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import cn.jpush.android.api.JPushInterface;

import com.example.smartchildren.R;
import com.ydhl.adapter.MyListAdapter;
import com.ydhl.adapter.MyPagerAdapter;
import com.ydhl.bean.MyMenuItem;
import com.ydhl.common.BaseActivity;
import com.ydhl.listener.ImageClickListener;
import com.ydhl.listener.ListMenuListener;
import com.ydhl.listener.MusicPlayListener;
import com.ydhl.listener.MyRbCheckChangeListener;
import com.ydhl.listener.PagerMainListener;
import com.ydhl.listener.PopClickListener;
import com.ydhl.utils.DBManager;

public class MainActivity extends BaseActivity
{
	private ListView listView;
	private MediaPlayer mediaPlayer;
	private RadioGroup radioGroup01;
	private RadioButton radioButton01;
	private RadioButton radioButton02;
	private RadioButton radioButton03;
	private ImageButton imageButton01;
	private ImageButton imageButton02;
	private ImageButton imageButton03;
	private ImageButton imageButton04;
	private ImageButton imageButton05;
	private ArrayList<View> views;
	private ViewPager viewPager;
	private View viewPager1;
	private View viewpager2;
	private View viewpager3;
	private DBManager dbManager;
	private PopupWindow popupWindow;
	private boolean isPop;
	private int[] images = new int[] { R.drawable.menu_self,
			R.drawable.menu_set, R.drawable.menu_more, R.drawable.menu_feedback };
	private String[] introduces = new String[] { "个人中心", "主题", "更多游戏", "反馈" };
	private ArrayList<MyMenuItem> menuItems = new ArrayList<>();
	private View root;
	private Button popButton01;
	private Button popButton02;
	private Button popButton03;
	public static LinearLayout linearLayout;
	private Button everyButton;
	private Button historyButton;
	private Button downButton;
	private Button anyButton;
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	private ListView listView2;
	private Map<String, String> dataMap = new HashMap<>();
	private static final String SD_ROOT_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath().toString();
	private static final String URL_PATH = "http://zcs.svnt.ml/rzet/Download.php";
	private Animation animationCome;
	private Animation animationCome1;
	private Animation animationCome2;
	private Animation animationCome3;

	@Override
	public void setContentView()
	{
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		JPushInterface.setDebugMode(true); // 设置开启日志,发布时请关闭日志
		JPushInterface.init(this); // 初始化 JPush
		sharedPreferences = this.getSharedPreferences("autoandremember",
				Context.MODE_WORLD_READABLE);
		editor = sharedPreferences.edit();
		int check = 0;
		
		dbManager = new DBManager(this, application.getUserName());
		check = sharedPreferences.getInt(application.getUserName(), 1);
		System.out.println(check);
		
		if (check == 0)
		{
			dbManager.createTable(application.getUserName());
			ContentValues contentValues1 = new ContentValues();
			contentValues1.put("_id", "ThinkGame");
			contentValues1.put("high", 0);
			contentValues1.put("low", 0);
			dbManager.insert(application.getUserName(), null, contentValues1);
			ContentValues contentValues2 = new ContentValues();
			contentValues2.put("_id", "RememberGame");
			contentValues2.put("high", 0);
			contentValues2.put("low", 0);
			dbManager.insert(application.getUserName(), null, contentValues2);
			ContentValues contentValues3 = new ContentValues();
			contentValues3.put("_id", "WordGame");
			contentValues3.put("high", 0);
			contentValues3.put("low", 0);
			dbManager.insert(application.getUserName(), null, contentValues3);
			ContentValues contentValues4 = new ContentValues();
			contentValues4.put("_id", "CalculateGame");
			contentValues4.put("high", 0);
			contentValues4.put("low", 0);
			dbManager.insert(application.getUserName(), null, contentValues4);
			ContentValues contentValues5 = new ContentValues();
			contentValues5.put("_id", "WayGame");
			contentValues5.put("high", 0);
			contentValues5.put("low", 0);
			dbManager.insert(application.getUserName(), null, contentValues5);
			editor.putInt(application.getUserName(), 1);
		}	
		editor.commit();
		setRadioGroup01((RadioGroup) findViewById(R.id.radioGroup01));
		setRadioButton01((RadioButton) findViewById(R.id.radiobutton1));
		setRadioButton02((RadioButton) findViewById(R.id.radiobutton2));
		setRadioButton03((RadioButton) findViewById(R.id.radiobutton3));
		linearLayout = (LinearLayout) findViewById(R.id.linearmain);
		viewPager = (ViewPager) findViewById(R.id.vp);
		viewPager1 = LayoutInflater.from(this).inflate(R.layout.pager_main,
				null);
		viewpager2 = LayoutInflater.from(this).inflate(R.layout.pager_test,
				null);
		viewpager3 = LayoutInflater.from(this).inflate(R.layout.pager_train,
				null);
		imageButton01 = (ImageButton) viewpager2
				.findViewById(R.id.imagecalculate);
		imageButton02 = (ImageButton) viewpager2
				.findViewById(R.id.imageconsider);
		imageButton03 = (ImageButton) viewpager2.findViewById(R.id.imagememory);
		imageButton04 = (ImageButton) viewpager2.findViewById(R.id.imageword);
		imageButton05 = (ImageButton) viewpager2.findViewById(R.id.imageway);
		listView = (ListView) findViewById(R.id.include01).findViewById(
				R.id.menulist01);
		listView2 = (ListView) viewpager3.findViewById(R.id.listView1);
		everyButton = (Button) viewPager1.findViewById(R.id.everyday);
		historyButton = (Button) viewPager1.findViewById(R.id.historybutton);
		downButton = (Button) viewPager1.findViewById(R.id.downbutton);
		anyButton = (Button) viewPager1.findViewById(R.id.anybutton);
		root = LayoutInflater.from(this).inflate(R.layout.pop_title, null);
		popButton01 = (Button) root.findViewById(R.id.button1);
		popButton02 = (Button) root.findViewById(R.id.button2);
		popButton03 = (Button) root.findViewById(R.id.button3);
		mediaPlayer = MediaPlayer.create(this, R.raw.background);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener()
		{

			@Override
			public void onCompletion(MediaPlayer mp)
			{
				mp.start();
			}
		});
	}

	@Override
	public void initView()
	{
		views = new ArrayList<>();
		views.add(viewPager1);
		views.add(viewpager2);
		views.add(viewpager3);
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		int screenWidth = screenWidth = display.getWidth();
		int screenHeight = screenHeight = display.getHeight();
		popupWindow = new PopupWindow(root, screenWidth / 4, screenHeight / 4);
		popupWindow.setTouchable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(),
				(Bitmap) null));
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item,
				new String[] { "  01狼和七只小羊", "  02神笔马良", "  03小壁虎借尾巴",
						"  04小红帽", "  05小蝌蚪找妈妈", " 06猪八戒吃西瓜", " 07白雪公主",
						" 08灰姑娘", "  09青蛙骑手", "  10三只小猪" });
		listView2.setAdapter(adapter);
	}

	@Override
	public void initListeners()
	{
		getRadioGroup01().setOnCheckedChangeListener(
				new MyRbCheckChangeListener(viewPager, this));
		listView2.setOnItemClickListener(new MusicPlayListener(this,
				mediaPlayer));
		imageButton01.setOnClickListener(new ImageClickListener(this, this));
		imageButton02.setOnClickListener(new ImageClickListener(this, this));
		imageButton03.setOnClickListener(new ImageClickListener(this, this));
		imageButton04.setOnClickListener(new ImageClickListener(this, this));
		imageButton05.setOnClickListener(new ImageClickListener(this, this));
		listView.setOnItemClickListener(new ListMenuListener(this));
		popButton01.setOnClickListener(new PopClickListener(this));
		popButton02.setOnClickListener(new PopClickListener(this));
		popButton03.setOnClickListener(new PopClickListener(this));
		anyButton.setOnClickListener(new PagerMainListener(this));
		everyButton.setOnClickListener(new PagerMainListener(this));
		downButton.setOnClickListener(new PagerMainListener(this));
		historyButton.setOnClickListener(new PagerMainListener(this));
		animationCome = AnimationUtils.loadAnimation(this,
				R.anim.mainbutton_come);
		animationCome1 = AnimationUtils.loadAnimation(this,
				R.anim.mainbutton_come1);
		animationCome2 = AnimationUtils.loadAnimation(this,
				R.anim.mainbutton_come2);
		animationCome3 = AnimationUtils.loadAnimation(this,
				R.anim.mainbutton_come3);
	}

	@Override
	public void initData()
	{

		for (int i = 0; i < images.length; i++)
		{
			MyMenuItem menuItem = new MyMenuItem();
			menuItem.Icon = images[i];
			menuItem.introduce = introduces[i];
			menuItems.add(menuItem);
		}
		listView.setAdapter(new MyListAdapter(menuItems, this));
		viewPager.setAdapter(new MyPagerAdapter(this, views));
		application.addActivities(this);
		everyButton.startAnimation(animationCome);
		downButton.startAnimation(animationCome1);
		anyButton.startAnimation(animationCome2);
		historyButton.startAnimation(animationCome3);
	}

	public RadioButton getRadioButton01()
	{
		return radioButton01;
	}

	public void setRadioButton01(RadioButton radioButton01)
	{
		this.radioButton01 = radioButton01;
	}

	public RadioButton getRadioButton02()
	{
		return radioButton02;
	}

	public void setRadioButton02(RadioButton radioButton02)
	{
		this.radioButton02 = radioButton02;
	}

	public RadioButton getRadioButton03()
	{
		return radioButton03;
	}

	public void setRadioButton03(RadioButton radioButton03)
	{
		this.radioButton03 = radioButton03;
	}

	public RadioGroup getRadioGroup01()
	{
		return radioGroup01;
	}

	public void setRadioGroup01(RadioGroup radioGroup01)
	{
		this.radioGroup01 = radioGroup01;
	}

	public void onPopupButtonClick(View view)
	{
		if (!isPop)
		{
			isPop = true;
			popupWindow.setAnimationStyle(R.style.AnimationPreview);
			popupWindow.showAsDropDown(view);
			popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
		} else
		{
			isPop = false;
			popupWindow.setAnimationStyle(R.style.AnimationPreview);
			popupWindow.dismiss();
		}
	}

	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_BACK:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setIcon(R.drawable.ic_launcher);
			builder.setMessage("亲，再玩一会嘛");
			builder.setTitle("  退出");
			builder.setPositiveButton("好的", new OnClickListener()
			{

				@Override
				public void onClick(DialogInterface dialog, int which)
				{

				}
			});
			builder.setNegativeButton("不了", new OnClickListener()
			{

				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					System.exit(0);

				}
			});

			AlertDialog alertDialog = builder.create();

			alertDialog.show();
			break;

		default:
			break;
		}
		return true;
	}

}
