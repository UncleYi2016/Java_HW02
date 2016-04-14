package com.example.java_hw02;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewClear extends Button implements IModelListener{
	
	private Model model;
	private ControllerClear controller;
	
	public ViewClear(Context ct, AttributeSet at) {
		super(ct, at);
	}
	
	public void setMVC(Model m, ControllerClear c){
		this.model = m;
		this.controller = c;
		this.model.addListener(this);
		
		this.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				controller.clearAll();
			}
		});
		notifyModelListener();
	}

	public void notifyModelListener() {
		
	}
	
	
}
