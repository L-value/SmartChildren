package com.ydhl.myview;

import com.nineoldandroids.view.ViewHelper;

import android.R.integer;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlidingMenu extends HorizontalScrollView{

	private int widthPixels;
	private ViewGroup mMenu;
	private ViewGroup mMain;
	private int mMenuRightOffset = 100;
	private int mMenuWidth;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			int scrollDis = (Integer) msg.obj;
			SlidingMenu.this.smoothScrollTo(scrollDis, 0);
		};
	};
	public SlidingMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics displayMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(displayMetrics);
		widthPixels = displayMetrics.widthPixels;
		mMenuRightOffset = widthPixels/4;
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		//子控件的宽高可以在这里先设置
		LinearLayout wrapper = (LinearLayout) this.getChildAt(0);
		//获取menu
		mMenu = (ViewGroup) wrapper.getChildAt(0);
		//获取main
		mMain = (ViewGroup) wrapper.getChildAt(1);
		mMenuWidth = widthPixels - mMenuRightOffset;
		//设置menu宽度
		mMenu.getLayoutParams().width = mMenuWidth;
		//设置主界面宽度
		mMain.getLayoutParams().width = widthPixels;
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if(changed){
			//假设视图改变
			this.scrollTo(mMenuWidth, 0);
		}
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_UP:
			 //判断已经滑出去的距离，根据这个距离决定显示菜单或者主界面
			Message msg = handler.obtainMessage();
			int scrollX = this.getScrollX();
			int span = mMenuWidth - widthPixels/2;
			if(scrollX<span){
				//滑到x为0
				msg.obj = 0;
			}else{
				//滑到主界面
				msg.obj = mMenuWidth;
			}
			handler.sendMessage(msg);
			break;
			
		default:
			break;
		}
		return super.onTouchEvent(ev);
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		//滑动条滑动的监听事件
		//做动画
		float scale = (float)l/mMenuWidth;//从0增到1
		float leftScale =(float) (1.0f - 0.3*scale); //缩放从1缩小到0.7
		ViewHelper.setScaleX(mMenu, leftScale);//将menu从1倍缩小到0.7
		ViewHelper.setScaleY(mMenu, leftScale);
		ViewHelper.setAlpha(mMenu, (float)(1.0f-0.8*scale));//将menu透明度从1增加0.2
		ViewHelper.setTranslationX(mMenu, l*0.7f);//保持不被左边移出去
		
		//主界面的缩放
		float rightScale = 0.8f +scale*0.2f;
		ViewHelper.setScaleX(mMain, rightScale);//从0.8倍放大到1.0倍（从右滑到左）
		ViewHelper.setScaleY(mMain, rightScale);
		super.onScrollChanged(l, t, oldl, oldt);
	}
}

