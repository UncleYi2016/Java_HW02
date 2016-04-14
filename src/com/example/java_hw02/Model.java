/***********************************Model.java***********************************/

package com.example.java_hw02;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Canvas;

public class Model{
	private int score;
	private ArrayList<IShape> bubbles;
	private ArrayList<IModelListener> listeners;
	
	Model(){
		this.score = 0;
		bubbles = new ArrayList<IShape>();
		listeners = new ArrayList<IModelListener>();
	}
	
	public int getScore(){
		return this.score;
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
		for(int i = 0; i <  bubbles.size();){
			if(!bubbles.get(i).isVisible(w, h)){
				bubbles.remove(i);
				score--;
				notifyAllModelListeners();
			}else{
				i++;
			}
		}
	}
	public void deleteBubblesAtPoint(float x, float y){
		for(int i = 0; i <  bubbles.size();){
			if(bubbles.get(i).isIn(x, y)){
				bubbles.remove(i);
				score++;
				notifyAllModelListeners();
			}else{
				i++;
			}
		}
	}
	public void drawAll(Canvas c){
		for(int i = 0; i < bubbles.size(); i++){
			bubbles.get(i).draw(c);
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
