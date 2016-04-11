package com.example.java_hw02;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	private int score;
	private ArrayList<IShape> bubbles;
	private ArrayList<IModelListener> listeners;
	
	Model(){
		this.score = 0;
		bubbles = new ArrayList<IShape>();
		listeners = new ArrayList<IModelListener>();
	}
	
	public void addBubble(int w, int h){
		Random r = new Random();
		float x = r.nextInt(w);
		float y = r.nextInt(h);
		IShape b = new Bubble(x,y);
		bubbles.add(b);
	}
	public void addListener(IModelListener listener){
		listeners.add(listener);
	}
	public void moveAll(float dx, float dy){
		
	}
}
