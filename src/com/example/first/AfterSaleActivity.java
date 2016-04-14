package com.example.first;

import com.example.mycar.ActivityUtils;
import com.example.mycar.MenuActivity;
import com.example.mycar.R;
import com.example.mycar.R.id;
import com.example.mycar.R.layout;
import com.example.mycar.R.menu;
import com.example.mycar.ShezhiActivity;
import com.example.second.JiumianActivity;
import com.example.second.JiuyuanActivity;
import com.example.second.SisActivity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class AfterSaleActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityUtils.requestNotTitleBar(this);
		setContentView(R.layout.activity_after_sale);
	
	
	   findViewById(R.id.jiumian).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			  Intent intent =new Intent(AfterSaleActivity.this,JiumianActivity.class);
			  startActivity(intent);
		}
	});
	   
	   
	   findViewById(R.id.jiuyuan).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent intent =new Intent(AfterSaleActivity.this,JiuyuanActivity.class);
				  startActivity(intent);
			}
		});
	   
	   findViewById(R.id.sis).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent intent =new Intent(AfterSaleActivity.this,SisActivity.class);
				  startActivity(intent);
			}
		});
	   
	   
	   
	   findViewById(R.id.fanhui).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent intent =new Intent(AfterSaleActivity.this,MenuActivity.class);
				  startActivity(intent);
			}
		});

    findViewById(R.id.btn_settings).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent intent =new Intent(AfterSaleActivity.this,ShezhiActivity.class);
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
