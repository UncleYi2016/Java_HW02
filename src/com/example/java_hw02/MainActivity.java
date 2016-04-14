package com.example.java_hw02;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Model m = new Model();
		ControllerBubbles c = new ControllerBubbles(m);
		ViewBubbles vb = (ViewBubbles) findViewById(R.id.ViewBubbles_Canvas);
		vb.setMVC(m, c);
	}
	
	// Call the startTicker()
	protected void onResume(){
		super.onResume();
		ViewBubbles vb = (ViewBubbles) findViewById(R.id.ViewBubbles_Canvas);
		vb.startTicker();
	}
	
	// Call the stopTicker()
	protected void onPause(){
		super.onPause();
		ViewBubbles vb = (ViewBubbles) findViewById(R.id.ViewBubbles_Canvas);
		vb.stopTicker();
	}
}
