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
		//�ӿؼ��Ŀ�߿���������������
		LinearLayout wrapper = (LinearLayout) this.getChildAt(0);
		//��ȡmenu
		mMenu = (ViewGroup) wrapper.getChildAt(0);
		//��ȡmain
		mMain = (ViewGroup) wrapper.getChildAt(1);
		mMenuWidth = widthPixels - mMenuRightOffset;
		//����menu���
		mMenu.getLayoutParams().width = mMenuWidth;
		//������������
		mMain.getLayoutParams().width = widthPixels;
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if(changed){
			//������ͼ�ı�
			this.scrollTo(mMenuWidth, 0);
		}
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_UP:
			 //�ж��Ѿ�����ȥ�ľ��룬����������������ʾ�˵�����������
			Message msg = handler.obtainMessage();
			int scrollX = this.getScrollX();
			int span = mMenuWidth - widthPixels/2;
			if(scrollX<span){
				//����xΪ0
				msg.obj = 0;
			}else{
				//����������
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
		//�����������ļ����¼�
		//������
		float scale = (float)l/mMenuWidth;//��0����1
		float leftScale =(float) (1.0f - 0.3*scale); //���Ŵ�1��С��0.7
		ViewHelper.setScaleX(mMenu, leftScale);//��menu��1����С��0.7
		ViewHelper.setScaleY(mMenu, leftScale);
		ViewHelper.setAlpha(mMenu, (float)(1.0f-0.8*scale));//��menu͸���ȴ�1����0.2
		ViewHelper.setTranslationX(mMenu, l*0.7f);//���ֲ�������Ƴ�ȥ
		
		//�����������
		float rightScale = 0.8f +scale*0.2f;
		ViewHelper.setScaleX(mMain, rightScale);//��0.8���Ŵ�1.0�������һ�����
		ViewHelper.setScaleY(mMain, rightScale);
		super.onScrollChanged(l, t, oldl, oldt);
	}
}

