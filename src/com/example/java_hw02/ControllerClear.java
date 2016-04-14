package com.example.java_hw02;

public class ControllerClear {
	private Model model;
	
	public ControllerClear(Model m){
		this.model = m;
	}
	
	public void clearAll(){
		model.clearAll();
	}
}
