package com.example.java_hw02;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ViewBubbles extends View {
	private Model model;
	private ControllerBubbles controller;
	private Handler h;
	private long delay;
	
	ViewBubbles(Context ct, AttributeSet at) {
		super(ct, at);
		delay = 500l;
	}
	
	public void setMVC(Model m, ControllerBubbles c){
		this.model = m;
		this.controller = c;
		h = new Handler(new Callback(){
			public boolean handleMessage(Message msg) {
				float height = getHeight();
				float width = getWidth();
				c.moveUp(width, height);
				Message m = h.obtainMessage(0);
				h.sendMessageDelayed(m, delay);
				return false;
			}
		});
		this.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v, MotionEvent e) {
				if(e.getAction() == MotionEvent.ACTION_UP){
					
				}
			}
		});
	}
	public void startTicker(){
		Message m = h.obtainMessage(0);
		h.sendMessageDelayed(m, delay);
	}
	public void stopTicker(){
		h.removeMessages(0);
	}
	
}
