package example;

import com.shigeodayo.pframe.PFrame;

import processing.core.PApplet;

public class PFrameExample extends PApplet {

	SecondApplet secondApplet = null;
	PFrame secondFrame = null;
	
	ThirdApplet thirdApplet = null;
	PFrame thirdFrame = null;
	
	public void setup() {
		size(200, 200);
		background(255, 0, 0);

		secondApplet = new SecondApplet();
		secondFrame = new PFrame(secondApplet, 210, 0);
		secondFrame.setTitle("Second Frame");
		
		thirdApplet = new ThirdApplet();
		thirdFrame = new PFrame(thirdApplet, 420, 0);
		thirdFrame.setTitle("Third Frame");
		noCursor();
	}
	
	public void draw() {
		
	}
}

class SecondApplet extends PApplet {

	public void setup() {
		size(200, 200);
		background(0, 255, 0);
	}
	
	public void draw() {
	}
}

class ThirdApplet extends PApplet {
	
	public void setup() {
		size(200, 200);
		background(0, 0, 255);
		noCursor();
	}
	
	public void draw() {
	}
}