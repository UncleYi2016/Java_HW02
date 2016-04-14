package com.example.java_hw02;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class ViewBubbles extends View implements IModelListener{

	private Model model;
	private ControllerBubbles controller;
	private Handler h;
	private long delay;
	
	public ViewBubbles(Context ct, AttributeSet at) {
		super(ct, at);
		delay = 500l;
	}
	
	public void setMVC(Model m, ControllerBubbles c){
		this.model = m;
		this.controller = c;
		this.model.addListener(this);
		h = new Handler(new Callback(){
			public boolean handleMessage(Message msg) {
				int height = (int) getHeight();
				int width = (int) getWidth();
				controller.moveUp(width, height);
				Message m = h.obtainMessage(0);
				h.sendMessageDelayed(m, delay);
				return false;
			}
		});
		this.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v, MotionEvent e) {
				controller.clickBubbles(e.getX(), e.getY());
				if(e.getAction() == MotionEvent.ACTION_UP){
					Toast.makeText(v.getContext(), "x: " + e.getX() + " y: " + e.getY(), Toast.LENGTH_SHORT).show();
					controller.clickBubbles(e.getX(), e.getY());
				}
			return false;
			}
		});
		
		notifyModelListener();
	}
	public void startTicker(){
		Message m = h.obtainMessage(0);
		h.sendMessageDelayed(m, delay);
	}
	public void stopTicker(){
		h.removeMessages(0);
	}
	
	public void notifyModelListener(){
		this.invalidate();
	}
	
	public void onDraw(Canvas c){
		this.model.drawAll(c);
	}
	
}
