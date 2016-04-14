package com.example.first;

import java.util.HashMap;
import java.util.Map;

import com.example.Dialog.ChongdianDialog;
import com.example.Dialog.KongzhiFragment;
import com.example.Dialog.ShefangFragment;
import com.example.Dialog.YinshenFragment;
import com.example.mycar.ActivityUtils;
import com.example.mycar.MainActivity;
import com.example.mycar.MenuActivity;
import com.example.mycar.R;
import com.example.mycar.RegisterActivity;
import com.example.mycar.R.id;
import com.example.mycar.R.layout;
import com.example.mycar.R.menu;


import android.support.v4.app.FragmentManager ;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class ControlActivity extends ActionBarActivity {
 
	private TabHost mTabHost;
	private TabManager mTabManager;
	private LinearLayout mMainLinearLayout;
	public static String urlstring="";
	public static String  duanString ="";
	private EditText editText;
	private EditText editText2;
	private  AlertDialog  alertDialog;
	private   android.app.AlertDialog.Builder builder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityUtils.requestNotTitleBar(this);
		setContentView(R.layout.activity_control);

		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();

		mTabManager = new TabManager(this, mTabHost, R.id.containertabcontent);
		
		 urlstring ="218.56.108.178";
//		 urlstring ="192.168.191.1";
		 duanString ="1976";
	
		RelativeLayout kongzhiLayout =(RelativeLayout)getLayoutInflater().inflate(R.layout.app_tab_layout, null);
		
		   mTabManager.addTab(mTabHost.newTabSpec("kongzhi").setIndicator(kongzhiLayout),KongzhiFragment.class , null);  
		
		   RelativeLayout yinshenLayout =(RelativeLayout)getLayoutInflater().inflate(R.layout.cloak_tab_layout,null);
		  mTabManager.addTab(mTabHost.newTabSpec("yinshen").setIndicator(yinshenLayout), YinshenFragment.class, null);
	
		  RelativeLayout shefangLayout =(RelativeLayout)getLayoutInflater().inflate(R.layout.control_tab_layout, null);
				
				mTabManager.addTab(mTabHost.newTabSpec("shefang").setIndicator(shefangLayout), ShefangFragment.class, null);
		
				mMainLinearLayout =(LinearLayout)findViewById(R.id.main);
				 
				
				
				

	
		findViewById(R.id.fanhui).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

	               Intent intent =new Intent(ControlActivity.this,MenuActivity.class);			
				   startActivity(intent);
			}
		});
		
		 builder=new AlertDialog.Builder(this);
		 
		 
		 findViewById(R.id.chepai).setOnClickListener(new OnClickListener() {
				
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
					builder.setIcon(R.drawable.abc_ab_solid_dark_holo);
					builder.setTitle("设置IP地址及端口号");
					
					LinearLayout layout = (LinearLayout)getLayoutInflater().inflate(R.layout.ipandduankou, null);
					
					builder.setView(layout);
				  
					
					editText =(EditText)layout.findViewById(R.id.editText1);
				     
				   
				     editText2 =(EditText)layout.findViewById(R.id.editText2);
				    
				        
					
					Button nButton =(Button) layout.findViewById(R.id.button1);
					
					   nButton.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							
							clickButton();
						}
					});
					
					   
					
					   alertDialog = builder.create();
					   alertDialog.show();
				}
			});
	
		 
		 
		}
  public  void  clickButton() {
	  urlstring = editText.getText().toString();
	  duanString =editText2.getText().toString();
	  alertDialog.cancel();
}
	
	
	
	
	 public  static  class TabManager implements TabHost.OnTabChangeListener{
		 
		 private final ControlActivity mActivity;
		 private final Map<String , TabInfo> mTabs = new HashMap<String, TabInfo>();
		 private final TabHost mTabHost;
		 private final  int mContainerID;
		 private TabInfo mLasTab;
		 
		 
		 public TabManager (ControlActivity activity,TabHost tabHost,int containerID){
			  mActivity =activity;
			  mTabHost = tabHost;
			  mContainerID =containerID;
			  
			  mTabHost.setOnTabChangedListener(this);
	
		 }
		 static final class  TabInfo{
			 private final String tagString;
			 private final Class< ?>class1;
			 private final Bundle args;
			 private  Fragment fragment;
			  
			  TabInfo(String _tag,Class <?> _class,Bundle _aBundle) {
				// TODO Auto-generated constructor stub
				   tagString =_tag;
				   class1 =_class;
				   args =_aBundle;
			} 
			 
		 }
		 static class TabFactory implements TabHost.TabContentFactory{
			 
			   private Context mContext;
			    TabFactory(Context context) {
				// TODO Auto-generated constructor stub
				   mContext =context;
			}
			   
			   public View createTabContent(String tag){
				    View view = new View( mContext);
				    view.setMinimumHeight(0);
				    view.setMinimumWidth(0);
				    
				   return view;
				   
				   
			   }
			 
		 }
		 public void addTab(TabHost.TabSpec tabSpec,Class<?>class1,Bundle args){
			  tabSpec.setContent(new TabFactory(mActivity));
			  String tag =tabSpec.getTag();
			  TabInfo info =new TabInfo(tag, class1, args);
			  final FragmentManager fm =mActivity.getSupportFragmentManager();
			   info.fragment =fm.findFragmentByTag(tag);
			   if(info.fragment != null && !info.fragment.isDetached()){
				    FragmentTransaction fTransaction =fm.beginTransaction();
				    fTransaction.detach(info.fragment);
				    fTransaction.commit();
				   
			   }
			   mTabs.put(tag, info);
			   mTabHost.addTab(tabSpec);
			 
			 
		 }
		 public void onTabChanged (String tabid){
			     TabInfo newtab =mTabs.get(tabid);
			     if(mLasTab!=newtab){
			    	 
			    	 FragmentManager fragmentManager =mActivity.getSupportFragmentManager();
			    	 FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
			    	 
			    	 if(mLasTab !=null&&mLasTab.fragment!=null){
			    	 
			    		   fragmentTransaction.detach(mLasTab.fragment);
			    		   
			     }
			    	 if(newtab!= null){
			    		  if(newtab.fragment ==null){
			    			    newtab.fragment =Fragment.instantiate(mActivity	, newtab.class1.getName(),newtab.args);
			    		        
			    			    fragmentTransaction.add(mContainerID, newtab.fragment,newtab.tagString);
			    		        
			    		  }else {
							fragmentTransaction.attach(newtab.fragment);
						}
			    		  
			    		  
			    	 }
			       mLasTab = newtab;
			       fragmentTransaction.commit();
			       fragmentManager.executePendingTransactions();
			     }
		    }
	 }
				 
 }
	
	

