package com.example.Dialog;

import com.example.mycar.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ShefangFragment extends Fragment{
	
	private int pro =0;
	public void onCreate(Bundle save){
		 super.onCreate(save);
		 
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("MessageFragment :: onCreateView");
		View  view =inflater.inflate(R.layout.activity_control_shefang_tab, container, false);
		
		
		final ChongdianDialog dialog1= new ChongdianDialog(this.getActivity(), 280, 240, R.layout.activity_jingbao_dialog, R.style.Theme_dialog);  
		 view.findViewById(R.id.shezhi).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 
				dialog1.show();
			}
		});
		 
		 dialog1.findViewById(R.id.queding).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog1.cancel();
					
				}
			});
		 
			final ChongdianDialog dialog2= new ChongdianDialog(this.getActivity(), 280, 240, R.layout.activity_fanwei_dialog, R.style.Theme_dialog);  
			 view.findViewById(R.id.weilan).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					 
					dialog2.show();
				}
			});
			 
			 
			 SeekBar seekBar2 =(SeekBar) dialog2.findViewById(R.id.seekBar1);
			    
			    seekBar2.setSecondaryProgress(0);
			   
				
				final TextView textView =(TextView) dialog2.findViewById(R.id.shijian);
					textView.setText(pro+"米");
			    seekBar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
			    
			    	
					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						textView.setText(pro+"米");
					}
					
					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						textView.setText("正在调整");
					}
					
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						
						pro=progress*4+100;
						textView.setText(pro+"米");
						
					}
				});
			 dialog2.findViewById(R.id.queding).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog2.cancel();
						
					}
				});
		return view;
	}


}
