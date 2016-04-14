/***********************************ViewScore.java***********************************/
package com.example.java_hw02;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ViewScore extends TextView implements IModelListener{

	private Model model;
	private ControllerScore controller;
	public ViewScore(Context ct, AttributeSet at) {
		super(ct, at);
	}

	
	public void setMVC(Model m, ControllerScore c){
		this.model = m;
		this.controller = c;
		this.model.addListener(this);
	}
	
	public void notifyModelListener() {
		this.setText("Score: " + model.getScore());
	}
	
	
}
