package com.example.mycar;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity {
 private TextView tv;
 private  DataInputStream dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActivityUtils.requestNotTitleBar(this);
       
        setContentView(R.layout.activity_main);
        
//        <TableLayout
//        android:layout_width="fill_parent"
//        android:layout_height="0dp"
//        android:layout_weight="1" >
//
//        <TableRow
//            android:layout_width="match_parent"
//            android:layout_height="match_parent"
//            android:gravity="top|center_horizontal"
//            android:weightSum="5" >
//
//            <TextView
//                android:id="@+id/zhuce"
//                android:layout_width="0dp"
//                android:layout_height="wrap_content"
//                android:layout_weight="1"
//                android:text="ÓÃ»§×¢²á"
//                android:textColor="@android:color/white" />
//        </TableRow>
//    </TableLayout>
        Button dengluBtn =(Button) findViewById(R.id.denglu);
        TextView zhuceBtn =(TextView) findViewById(R.id.zhuce);
//          
           dengluBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			  
				 Intent intent =new Intent(MainActivity.this,MenuActivity.class);
				 startActivity(intent);
				
				
			}
		});
          
          zhuceBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
	               Intent intent =new Intent(MainActivity.this,RegisterActivity.class);			
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
