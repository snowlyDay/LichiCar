package com.example.first;

import com.example.mycar.ActivityUtils;
import com.example.mycar.JianceActivity;
import com.example.mycar.MenuActivity;
import com.example.mycar.R;
import com.example.mycar.RegisterActivity;
import com.example.mycar.R.id;
import com.example.mycar.R.layout;
import com.example.mycar.R.menu;
import com.example.second.ChekuangActivity;
import com.example.second.GuijiActivity;
import com.example.second.MishuActivity;
import com.example.second.WeizhiActivity;
import com.example.second.XingchengActivity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ManageActivity extends ActionBarActivity {

	@Override

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityUtils.requestNotTitleBar(this);
		setContentView(R.layout.activity_manage);
	
		
		
		
		 findViewById(R.id.jiance).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
				
						

			               Intent intent =new Intent(ManageActivity.this,JianceActivity.class);			
						   startActivity(intent);
					}
			
			});
		   findViewById(R.id.weizhi).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ManageActivity.this,WeizhiActivity.class);			
						   startActivity(intent);
					
				}
			});
	
		   
		   
		   findViewById(R.id.xingcheng).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ManageActivity.this,XingchengActivity.class);			
						   startActivity(intent);
					
				}
			});
		   
		   findViewById(R.id.guiji).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ManageActivity.this,GuijiActivity.class);			
						   startActivity(intent);
					
				}
			});
		   
		   findViewById(R.id.chekuang).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ManageActivity.this,ChekuangActivity.class);			
						   startActivity(intent);
					
				}
			});
		   
		   findViewById(R.id.mishu).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
//					Intent intent =new Intent(ManageActivity.this,MishuActivity.class);			
//						   startActivity(intent);
					
				}
			});
		   
		   

		   findViewById(R.id.fanhui1).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent =new Intent(ManageActivity.this,MenuActivity.class);			
						   startActivity(intent);
					
				}
			});
		   
		   
		  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.after_sale, menu);
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