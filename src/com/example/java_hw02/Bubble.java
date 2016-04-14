/***********************************Bubble.java***********************************/
package com.example.java_hw02;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bubble extends Shape{
	private float radius;
	private Paint p;
	
	Bubble(float x, float y) {
		super(x, y);
		int colorNum = 0;
		this.radius = 10.0f;
		this.p = new Paint();
		Random r = new Random();
		colorNum = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		p.setColor(colorNum);
		p.setStyle(Paint.Style.FILL);
	}

	 // Find the point (wx, wy) inside the window which is closest to the
	 // center (x, y) of the circle. In other words, find the wx in the
	 // interval [0, w] which is closest to x, and find the wy in the
	 // interval [0, h] which is closest to y.
	 // If the distance between (wx, wy) and (x, y) is less than the radius
	 // of the circle (using Pythagoras¡¯s theorem) then at least part of
	 // the circle is visible in the window.
	 // Note: if the center of the circle is inside the window, then (wx, wy)
	 // is the same as (x, y), and the distance is 0.
	 public boolean isVisible(int w, int h) {
		 float x = getX();
		 float y = getY();
		 float wx = (x < 0 ? 0 : (x > w ? w : x));
		 float wy = (y < 0 ? 0 : (y > h ? h : y));
		 float dx = wx - x;
		 float dy = wy - y;
		 return dx * dx + dy * dy <= radius * radius;
	 }

	public boolean isIn(float x, float y) {
		float dx = getX() - x;
		float dy = getY() - y;
		return dx*dx + dy*dy <= radius * radius;
	}
	public void draw(Canvas c) {
		c.drawCircle(getX(), getY(), radius, p);
	}

	
}
