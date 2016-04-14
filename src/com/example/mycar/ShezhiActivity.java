package com.example.mycar;

import com.example.first.ManageActivity;
import com.example.shezhi.GongnengshezhiActivity;
import com.example.shezhi.GuanyuwomenActivity;
import com.example.shezhi.JibenxinxiActivity;
import com.example.shezhi.TishiyinshezhiActivity;
import com.example.shezhi.XiugaimimaActivity;
import com.example.shezhi.YijianfenxiangActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ShezhiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityUtils.requestNotTitleBar(this);
		setContentView(R.layout.activity_shezhi);
		
		
		
		   findViewById(R.id.jibenxinxi).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ShezhiActivity.this,JibenxinxiActivity.class);			
						   startActivity(intent);
					
				}
			});
		   findViewById(R.id.xiugaimima).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ShezhiActivity.this,XiugaimimaActivity.class);			
						   startActivity(intent);
					
				}
			});
		   findViewById(R.id.gongnengshezhi).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ShezhiActivity.this,GongnengshezhiActivity.class);			
						   startActivity(intent);
					
				}
			});
		   findViewById(R.id.yijianfenxiang).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ShezhiActivity.this,YijianfenxiangActivity.class);			
						   startActivity(intent);
					
				}
			});
		   findViewById(R.id.tishiyinliang).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ShezhiActivity.this,TishiyinshezhiActivity.class);			
						   startActivity(intent);
					
				}
			});
		   findViewById(R.id.guanyuweomen).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ShezhiActivity.this,GuanyuwomenActivity.class);			
						   startActivity(intent);
					
				}
			});
		   
		   findViewById(R.id.qiehuanyonghu).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
//					Intent intent =new Intent(ShezhiActivity.this,RegisterActivity.class);			
//						   startActivity(intent);
					
				}
			});
		   findViewById(R.id.tuichudenglu).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
//					Intent intent =new Intent(ShezhiActivity.this,RegisterActivity.class);			
//						   startActivity(intent);
					
				}
			});
		   
		   findViewById(R.id.fanhui).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ShezhiActivity.this,MenuActivity.class);			
						   startActivity(intent);
					
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shezhi, menu);
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
