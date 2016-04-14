package com.example.second;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import com.example.first.ControlActivity;
import com.example.mycar.ActivityUtils;
import com.example.mycar.MenuActivity;
import com.example.mycar.R;
import com.example.mycar.R.id;
import com.example.mycar.R.layout;
import com.example.mycar.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChekuangActivity extends Activity {
	  private DataInputStream dis;
	  private Handler handler;
	   private ListView listView;
	   private  String string;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityUtils.requestNotTitleBar(this);
		setContentView(R.layout.activity_chekuang);
		
		
		  new Thread(runnable4).start();
		
	findViewById(R.id.fanhui).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

	               Intent intent =new Intent(ChekuangActivity.this,MenuActivity.class);			
				   startActivity(intent);
			}
		});
		
		
	   
		
		 handler = new Handler(){
		    @Override
		    public void handleMessage(Message msg) {
		        super.handleMessage(msg);
		        Bundle data = msg.getData();
		        string = data.getString("value");
		      
		        Log.i("ddd",string);
		        wuname();
		     
		    }
		};
		
		 

	}
  public  void  wuname() {
      
    
	  
	  if(string !=null){
		  String arr []  = string.split(",");
		   int i =0;
		  String strings[]  = new String[37] ;
		  String  tempStrings[]  =null;
		  for (String str :arr){
			     
			      tempStrings =str.split("=");
			      
			     
			    
			      if(tempStrings[0]!=null&&tempStrings[1]!=null)
			    	  strings[i] =tempStrings[0]+"->检测中->:"+tempStrings[1];
			   
			      i++;
			      String dString = ""+i;
			      Log.i(dString,tempStrings[0]+"正在检测中。。。。结果:"+tempStrings[1]);
		  }
//		  
//		  int k =0;
//		  for (String str :strings){
//			      if(str!=null){
//			    	  k++;
//			      }
//			   
//		  }
//		  
		
		  ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,strings);
	 
		  listView =(ListView )findViewById(R.id.list);
	 
		  listView.setAdapter(arrayAdapter);
	  }
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chekuang, menu);
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
	 
	
	Runnable  runnable4 = new Runnable(){
		  

			@Override
		    public void run() {
		       
		    	 String string = null;
		    	 try {
		    			
		    		  String  dString ="http://"+ControlActivity.urlstring+":"+ControlActivity.duanString+"/"+"query.do";
		    		    Log.i("urlstri", dString);
		    			URL url = new URL(dString);
	    		  
					 URLConnection urlConnect=url.openConnection();
					
					dis =  new DataInputStream(urlConnect.getInputStream());
					
					 int temp = 0;
					 
						ByteArrayBuffer baff = new ByteArrayBuffer(1000);
						while ((temp = dis.read()) != -1) {
							baff.append(temp);
						}
						
						string =EncodingUtils.getString(baff.toByteArray(), "UFT-8");
				
		    	 } catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (dis != null)
							dis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		    	
		        Message msg = new Message();
		        Bundle data = new Bundle();
		        data.putString("value",string);
		        msg.setData(data);
		        handler.sendMessage(msg);
		       
		    }
		    };
}
