package com.example.java_hw02;

import android.graphics.Canvas;

public abstract class Shape implements IShape{
	private float x;
	private float y;
	
	Shape(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	
	public abstract boolean isVisible(int w, int h);
	public abstract boolean isIn(float x, float y);
	public abstract void draw(Canvas c);
}
