package com.example.java_hw02;

import android.graphics.Canvas;

public interface IShape {
	public float getX();
	public float getY();
	public void setX(float x);
	public void setY(float y);
	public boolean isVisible(int w, int h);
	public boolean isIn(float x, float y);
	public void draw(Canvas c);
}
