package com.example.Dialog;

import com.example.mycar.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class YinshenFragment extends Fragment{
	
	public void onCreate(Bundle saveBundle){
		
		 super.onCreate(saveBundle);
		
	}
	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		
		System.out.println("ContactsFragment onCreateView :: ");
		
		 View view3=inflater.inflate(R.layout.activity_control_yinshen_tab, container, false);
			
			
			
			return view3;
		
	}

}
