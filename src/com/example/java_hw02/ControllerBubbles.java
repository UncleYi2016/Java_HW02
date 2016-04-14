/***********************************ControllerBubbles.java***********************************/
package com.example.java_hw02;

public class ControllerBubbles {
	private Model model;
	
	ControllerBubbles(Model m){
		this.model = m;
	}
	
	public void moveUp(int w, int h){
		this.model.moveAll(0, -1);
		this.model.clearInvisibles(w, h);
		this.model.addBubble(w, h);
	}
	public void clickBubbles(float x, float y){
		this.model.deleteBubblesAtPoint(x, y);
	}
}
