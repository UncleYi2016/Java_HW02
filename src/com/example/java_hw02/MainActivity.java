package com.example.java_hw02;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Model m = new Model();
		ControllerBubbles cb = new ControllerBubbles(m);
		ControllerScore cs = new ControllerScore(m);
		ControllerClear cc = new ControllerClear(m);
		ViewBubbles vb = (ViewBubbles) findViewById(R.id.ViewBubbles_Canvas);
		vb.setMVC(m, cb);
		ViewScore vs = (ViewScore) findViewById(R.id.ViewScores);
		vs.setMVC(m, cs);
		ViewClear vc = (ViewClear) findViewById(R.id.clear);
		vc.setMVC(m, cc);
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
