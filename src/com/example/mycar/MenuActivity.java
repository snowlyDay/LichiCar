package com.example.mycar;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;

import com.example.first.AfterSaleActivity;
import com.example.first.ControlActivity;
import com.example.first.MaintainActivity;
import com.example.first.ManageActivity;
import com.example.first.MessageActivity;
import com.example.first.PoliceActivity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;

public class MenuActivity extends FragmentActivity {

	
	private final static int TRANSLATE_ANIMATION_WIDTH = 150;
	private final static int ANIMATION_DURATION_FAST = 150;
	private final static int ANIMATION_DURATION_SLOW = 250;
	private final static int MOVE_DISTANCE = 50;
	

	private TabHost mTabHost;

	private LinearLayout mSettingLinearLayout;
	private LinearLayout mMainLinearLayout;
	private int mWidth;
	private float mPositionX;
	private boolean mSlided =false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		ActivityUtils.requestNotTitleBar(this);
		setContentView(R.layout.fragment_tabs);
		 mWidth =getResources().getDisplayMetrics().widthPixels;
		 mTabHost =(TabHost )findViewById(android.R.id.tabhost);
		 mTabHost.setup();
		 
		 RelativeLayout controLayout  = (RelativeLayout )getLayoutInflater().inflate(R.layout.control_tab_layout, null);
		 
		 RelativeLayout protectLayout =(RelativeLayout)getLayoutInflater().inflate(R.layout.protect_tab_layout, null);
		 
		 
		 RelativeLayout cloakLayout =(RelativeLayout)getLayoutInflater().inflate(R.layout.cloak_tab_layout, null);
		 
		 //通过点击按键进入侧面的菜单
		 mSettingLinearLayout =(LinearLayout)findViewById(R.id.setting);
		  
		 
		 //通过滑动进入侧栏的菜单
		 mMainLinearLayout=(LinearLayout)findViewById(R.id.main);
		 
		 mMainLinearLayout.setOnTouchListener(mOnTouchListener);
		 
		 ListView listView =(ListView )findViewById(R.id.list);
		 listView.setOnTouchListener(mOnTouchListener);
		
		 
        
		 
		 
		 findViewById(R.id.btn_settings).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					  Intent intent =new Intent(MenuActivity.this,ShezhiActivity.class);
					  startActivity(intent);
				}
			});
		
		 
         findViewById(R.id.jiance).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!mSlided){
					

		               Intent intent =new Intent(MenuActivity.this,JianceActivity.class);			
					   startActivity(intent);
				}
			}
		});
         
         
         
		
		 findViewById(R.id.guanli).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				if(!mSlided){
		               Intent intent =new Intent(MenuActivity.this,ManageActivity.class);			
					   startActivity(intent);
				}
			}
		});
		 
		 findViewById(R.id.kongzhi).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(!mSlided){
						
			               Intent intent =new Intent(MenuActivity.this,ControlActivity.class);			
						   startActivity(intent);
					}
				}
			});
		 
		 findViewById(R.id.shouhou).setOnClickListener(new OnClickListener(
				 ) {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!mSlided){
					

		               Intent intent =new Intent(MenuActivity.this,AfterSaleActivity.class);			
					   startActivity(intent);
				}
			}
		});
		 
		 findViewById(R.id.baoyang).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!mSlided){
//		               Intent intent =new Intent(MenuActivity.this,MaintainActivity.class);			
//					   startActivity(intent);
				}
			}
		});
		 
		 findViewById(R.id.xinxi).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!mSlided){
		               Intent intent =new Intent(MenuActivity.this,MessageActivity.class);			
					   startActivity(intent);
				}
			}
		});
		 
		 findViewById(R.id.baojing).setOnClickListener(new OnClickListener(	) {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!mSlided){
		               Intent intent =new Intent(MenuActivity.this,PoliceActivity.class);			
					   startActivity(intent);
				}
			}
		});
	
	    
	}
	


	
	private OnTouchListener mOnTouchListener = new OnTouchListener() {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if (v.getId() == R.id.main) {
				int action = event.getAction();
				switch (action) {
					case MotionEvent.ACTION_DOWN :
						mPositionX = event.getX();
						break;
					case MotionEvent.ACTION_MOVE :
						final float currentX = event.getX();
						// 向左边滑动
						if (currentX - mPositionX >= MOVE_DISTANCE && !mSlided) {
							slideOut();
						} else if (currentX - mPositionX <= MOVE_DISTANCE && mSlided) {
							slideIn();
						}
						break;
				}
				return true;
			} 
			return false;
		}
	};

	private void slideOut(){
		
		TranslateAnimation translateAnimation =new TranslateAnimation(0, 
				mWidth/3,0,0);
		translateAnimation.setDuration(ANIMATION_DURATION_SLOW);
	    translateAnimation.setFillAfter(true);
	    mSettingLinearLayout.startAnimation(translateAnimation);
	    TranslateAnimation animation =new TranslateAnimation(0, mWidth/3,0,0);
		animation.setDuration(ANIMATION_DURATION_FAST);
		animation.setFillAfter(true);
		mMainLinearLayout.startAnimation(animation);
     	mSlided =true;
	    mSettingLinearLayout.getAnimation().setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
		
	}
	//划近菜单栏木
	private void slideIn(){
		
		TranslateAnimation translateAnimation =new TranslateAnimation(mWidth/3, 0,0,0);
		translateAnimation.setDuration(ANIMATION_DURATION_FAST);
		translateAnimation.setFillAfter(true);
		mSettingLinearLayout.startAnimation(translateAnimation);
		mSettingLinearLayout.getAnimation().setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				TranslateAnimation mainAnimation = new TranslateAnimation(
						mWidth/3, 0, 0, 0);
				mainAnimation.setDuration(ANIMATION_DURATION_SLOW);
				mainAnimation.setFillAfter(true);
				mMainLinearLayout.startAnimation(mainAnimation);
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				mSlided =false;
				
			}
		});
		
		
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && mSlided) {
			slideIn();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		
		
		return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}