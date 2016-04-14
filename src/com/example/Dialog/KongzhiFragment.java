package com.example.Dialog;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;


import com.example.first.ControlActivity;
import com.example.mycar.HeiActivity;
import com.example.mycar.MenuActivity;
import com.example.mycar.R;
import com.example.mycar.ShezhiActivity;

import com.example.mycar.R;
import com.example.shezhi.GongnengshezhiActivity;

import android.R.bool;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class KongzhiFragment extends Fragment{
	private TextView textView;
	private int pro =0;
	private View view1;
	private boolean isSuoche =false;
	private boolean isKaiche =true;
	private boolean isShengguang =false;
	 private  DataInputStream dis;

	public void onCreate(Bundle saveBundle){
		
		 super.onCreate(saveBundle);
		
		

	}
	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		
	
		  view1=inflater.inflate(R.layout.activity_control_kongzhi_tab, container, false);
		  
		  
			view1.findViewById(R.id.kaichemen).setBackgroundResource(R.drawable.kaichemenpress);   
			view1.findViewById(R.id.suochemen).setBackgroundResource(R.drawable.suochemenupress);
		  
		 
			
			
			
			
			
		    view1.findViewById(R.id.suochemen).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    
				if(isSuoche){
					Toast toast =Toast.makeText(getActivity(),
							"车门已经关闭", 2);
					toast.show();
					
				}else {
				
					  new Thread(runnable).start();
					  isKaiche =false;
					  isSuoche =true;
					  
					     view1.findViewById(R.id.kaichemen).setBackgroundResource(R.drawable.kaichemenup);
					     view1.findViewById(R.id.suochemen).setBackgroundResource(R.drawable.suochemenup);
				}
				
			}
		});
		  
		 
		
		  
		    view1.findViewById(R.id.kaichemen).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(isKaiche){
						Toast toast =Toast.makeText(getActivity(),
								"车门已经打开", 2);
						toast.show();
						
					}else {
					    
						v.setBackgroundResource(R.drawable.kaichemenpress);   
						view1.findViewById(R.id.suochemen).setBackgroundResource(R.drawable.suochemenupress);
						
						new Thread(runnable1).start();
						
						isKaiche =true;
						isSuoche =false;
					}
					
				}
			});
		  
		    view1.findViewById(R.id.shengguang).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(isShengguang){
						Toast toast =Toast.makeText(getActivity(),
								"声光寻车并开启车门", 2);
						toast.show();
						isShengguang =false;
						new Thread(runnable4).start();
						
					}else {
						Toast toast =Toast.makeText(getActivity(),
								"声光寻车并锁定车门", 2);
						toast.show();
						
						new Thread(runnable3).start();
						
						isShengguang =true;
					}
				}
			});
		  
		  
		  
		  final ChongdianDialog dialog1= new ChongdianDialog(this.getActivity(),280, 240, R.layout.activity_chongdian_dialog, R.style.Theme_dialog);  
			 view1.findViewById(R.id.chongdian).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub	 
					//System.out.print("sfsdfsfsdfsdfsdfsd");
					dialog1.show();
				}
			});
			  
			 SeekBar seekBar1 =(SeekBar) dialog1.findViewById(R.id.seekBar1);
			    
			 final TextView textView1 =(TextView) dialog1.findViewById(R.id.shijian);
			    
			 	textView1.setText(pro+"小时");
			    seekBar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
			    	
			    	
					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						textView1.setText(pro+"小时");
					}
					
					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						textView1.setText("正在调整");
					}
					
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						pro=progress/5;
						textView1.setText(pro+"小时");
						
					}
				});
			   
			 
			
			  dialog1.findViewById(R.id.queding).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog1.cancel();
					
				}
			});
			 
			 
	   final ChongdianDialog dialog2 = new ChongdianDialog(this.getActivity(), 280, 240, R.layout.activity_kongtiao_dialog, R.style.Theme_dialog);  
			 view1.findViewById(R.id.kongtiao).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog2.show();
				}
			});
			 
			
			 
			 SeekBar seekBar2 =(SeekBar) dialog2.findViewById(R.id.seekBar1);
			    
			    seekBar2.setSecondaryProgress(0);
			   
			    final TextView textView2 =(TextView) dialog2.findViewById(R.id.shijian);
			      
			    textView2.setText(pro+"小时");
			    seekBar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
			    	
			    	
					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						textView2.setText(pro+"小时");
					}
					
					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						textView2.setText("正在调整");
					}
					
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						textView2.setText(progress/5+"小时");
						pro=progress/5;
					}
				});
			   
			
			    
			    SeekBar seekBar3 =(SeekBar) dialog2.findViewById(R.id.seekBar2);
				    
			    seekBar3.setSecondaryProgress(0);
				   
			    
			    final TextView textView3 =(TextView) dialog2.findViewById(R.id.shijian2);
			      
			    textView3.setText(pro+"度");
				      
			    seekBar3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
						
				    	
				    	
						@Override
						public void onStopTrackingTouch(SeekBar seekBar) {
							// TODO Auto-generated method stub
							textView3.setText(pro+"度");
						}
						
						@Override
						public void onStartTrackingTouch(SeekBar seekBar) {
							// TODO Auto-generated method stub
							textView3.setText("正在调整");
						}
						
						@Override
						public void onProgressChanged(SeekBar seekBar, int progress,
								boolean fromUser) {
							// TODO Auto-generated method stub
							
							progress =progress/5+16;
							textView3.setText(progress+"度");
							pro=progress;
						}
					});
			
			   dialog2.findViewById(R.id.queding).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog2.cancel();
					
				}
			});
	
       final ChongdianDialog dialog3= new ChongdianDialog(this.getActivity(), 280, 240, R.layout.activity_chesu_dialog, R.style.Theme_dialog);  
				 view1.findViewById(R.id.chesu).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						 
						dialog3.show();
					}
				});
			 
				 
				    SeekBar seekBar4 =(SeekBar) dialog3.findViewById(R.id.seekBar1);
				    
				    seekBar4.setSecondaryProgress(0);
				    final TextView textView4 =(TextView) dialog3.findViewById(R.id.shijian);
				      
				    textView4.setText(pro+"km/h时");  
						
					      
				    seekBar4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
							
					    
					    	
							@Override
							public void onStopTrackingTouch(SeekBar seekBar) {
								// TODO Auto-generated method stub
								textView4.setText("限制"+pro+"km/h");
							}
							
							@Override
							public void onStartTrackingTouch(SeekBar seekBar) {
								// TODO Auto-generated method stub
								textView4.setText("正在调整");
							}
							
							@Override
							public void onProgressChanged(SeekBar seekBar, int progress,
									boolean fromUser) {
								// TODO Auto-generated method stub
								
								progress =progress*3;
								textView4.setText("限制"+progress+"km/h");
								pro=progress;
							}
						});
				
				   dialog3.findViewById(R.id.queding).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog3.cancel();
						
					}
				});
				   
				   
	
		return view1;
		
	}
	
	
	
	Runnable  runnable = new Runnable(){
	    @Override
	    public void run() {
	       
	    	 String string = null;
	    	 try {
	    			
	    		    String  dString ="http://"+ControlActivity.urlstring+":"+ControlActivity.duanString+"/"+"lock.do";
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
	       
	    }
	    };
	
	    Runnable  runnable1 = new Runnable(){
		    @Override
		    public void run() {
		       
		    	 String string = null;
		    	 try {
		    			
		    		   String  dString ="http://"+ControlActivity.urlstring+":"+ControlActivity.duanString+"/"+"unlock.do";
		    		    Log.i("urlstri", dString);
		    			URL url = new URL(dString);
//		    		 
	    		  
					 URLConnection urlConnect=url.openConnection();
					 System.out.print("sdfsdfawerwqrwefasdcvzxc");
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
		       
		    }
		    };

		   

			    Runnable  runnable3 = new Runnable(){
				    @Override
				    public void run() {
				       
				    	 String string = null;
				    	 try {
				    			
				    		   String  dString ="http://"+ControlActivity.urlstring+":"+ControlActivity.duanString+"/"+"locatelock.do";
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
				       
				    }
				    };
				    Runnable  runnable4 = new Runnable(){
					    @Override
					    public void run() {
					       
					    	 String string = null;
					    	 try {
					    			
					    		  String  dString ="http://"+ControlActivity.urlstring+":"+ControlActivity.duanString+"/"+"locateunlock.do";
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
					       
					    }
					    };
}
