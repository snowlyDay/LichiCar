package com.example.Dialog;

import com.example.mycar.ActivityUtils;
import com.example.mycar.R;
import com.example.mycar.R.id;
import com.example.mycar.R.layout;
import com.example.mycar.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ChongdianDialog extends Dialog {
  
	private static int default_width =160;
    private static int default_height =120;
    
	public ChongdianDialog(Context context,int layout ,int style) {
		
		
		
		this(context,default_width,default_height,layout,style);
	}

	public ChongdianDialog(Context context, int width,
			int height, int layout, int style) {
		// TODO Auto-generated constructor stub
		 super(context, style);
		 setContentView(layout);
		
		   
		 Window window =getWindow();
		 WindowManager.LayoutParams params =window.getAttributes();
		 float density =getDenstity(context);
		 params.width =(int )(width*density);
		 params.height =(int)(height*density);
		 params.gravity =Gravity.CENTER;
		 window.setAttributes(params);
		 
		 
	}

	private float getDenstity(Context context) {
		// TODO Auto-generated method stub
		Resources resources = context.getResources();  
        DisplayMetrics dm = resources.getDisplayMetrics();  
       return dm.density;  
		  
		
	}

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		
//		//ActivityUtils.requestNotTitleBar(this);
//		setContentView(R.layout.activity_chongdian_dialog);
//	     
//	
//	
//	
//	}


}
