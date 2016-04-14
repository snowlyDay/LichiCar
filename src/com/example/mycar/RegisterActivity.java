package com.example.mycar;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


public class RegisterActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActivityUtils.requestNotTitleBar(this);
        setContentView(R.layout.activity_register);
   
        
        Button zhuceBtn =(Button) findViewById(R.id.zhuce);
          
          zhuceBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				   Intent intent =new Intent(RegisterActivity.this,MainActivity.class);			
				   startActivity(intent);
				
			}
		});
          
          ImageButton fanhuiButton =(ImageButton)findViewById( R.id.fanhui);
          
          fanhuiButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent intent =new Intent(RegisterActivity.this,MainActivity.class);			
				   startActivity(intent);
			}
		});
          
           
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
