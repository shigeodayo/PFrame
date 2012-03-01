import com.shigeodayo.pframe.*;


SecondApplet secondApplet = null;
PFrame secondFrame = null;

ThirdApplet thirdApplet = null;
PFrame thirdFrame = null;

void setup() {
  size(200, 200);
  background(0, 0, 0);
  
  secondApplet = new SecondApplet();
  secondFrame = new PFrame(secondApplet, 210, 0);
  secondFrame.setTitle("Second Frame");
  
  thirdApplet = new ThirdApplet();
  thirdFrame = new PFrame(thirdApplet, 420, 0);
  thirdFrame.setTitle("Third Frame");
  
  noCursor();
}

void draw() {
}

void mouseMoved() {
  background(255, 0, 0);
}

// second Processing applet
private class SecondApplet extends PApplet {
  
  void setup() {
    size(200, 200);
    background(0, 0, 0);
    
    noCursor();
  }  
  
  void draw() {
  }
  
  void mouseMoved() {
    background(0, 255, 0);
  }
}

// third Processing applet
private class ThirdApplet extends PApplet {
  
  void setup() {
    size(200, 200);
    background(0, 0, 0);
    
    noCursor();
  }
  
  void draw() {
  }
  
  void mouseMoved() {
    background(0, 0, 255);
  }
}
