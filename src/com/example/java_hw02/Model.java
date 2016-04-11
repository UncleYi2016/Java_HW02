package com.example.java_hw02;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Canvas;

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
		notifyAllModelListeners();
	}
	public void addListener(IModelListener listener){
		listeners.add(listener);
	}
	public void moveAll(float dx, float dy){
		for(IShape b : bubbles){
			b.setX(b.getX() + dx);
			b.setY(b.getY() + dy);
		}
		notifyAllModelListeners();
	}
	public void clearInvisibles(int w, int h){
		for(IShape b : bubbles){
			if(!b.isVisible(w, h)){
				bubbles.remove(b);
				score--;
				notifyAllModelListeners();
			}
		}
	}
	public void deleteBubblesAtPoint(float x, float y){
		for(IShape b : bubbles){
			if(b.getX() == x && b.getY() == y){
				bubbles.remove(b);
				score++;
				notifyAllModelListeners();
			}
		}
	}
	public void drawAll(Canvas c){
		for(IShape b : bubbles){
			b.draw(c);
		}
	}
	public void clearAll(){
		bubbles.clear();
		notifyAllModelListeners();
	}
	
	private void notifyAllModelListeners(){
		for(IModelListener l : listeners){
			l.notifyModelListener();
		}
	}
}
