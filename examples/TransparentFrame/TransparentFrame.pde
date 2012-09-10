import com.shigeodayo.pframe.*;

TransparentApplet transparentApplet = null;
PFrame[] transparentFrames = null;

int frameNum = 0;
int mouseOveredCount = 0;

void setup() {
  size(200, 200);
  background(0, 0, 0);
  
  randomSeed(System.currentTimeMillis());
  frameNum = (int) random(2, 20);
  transparentFrames = new PFrame[frameNum];
  
  for (int i = 0; i < frameNum; i++) {
    int x = (int) random(0, screenWidth - 200);
    int y = (int) random(0, screenHeight - 200);
    float alpha = random(0.1f, 0.9f);
    // must hide title bar
    transparentFrames[i] = new PFrame(new TransparentApplet(), x, y, false);
    // true: transparent, false: no transparent
    // alpha: 0.0f - 1.0f
    transparentFrames[i].setTransparent(true, alpha);
  }
  
  noCursor();
  println(frameNum);
}

void draw() {
  background(0 ,0, 0);
  if (mouseOveredCount == frameNum) {
    text("all done.", 70, 100);
  }
  
  text(mouseOveredCount + " / " + frameNum, 80, 140);
}

private class TransparentApplet extends PApplet {
  
  color myColor;
  boolean isMouseOvered = false;
  
  void setup() {
    int wSize = (int) random(10, 200);
    size(wSize, wSize);
    background(255, 255, 255);
    
    createRandomColor();
    
    noCursor();
  }  
  
  void draw() {
  }
  
  void createRandomColor() {
    int r = (int) random(255);
    int g = (int) random(255);
    int b = (int) random(255);
    myColor = color(r, g, b);
  }
  
  void mouseMoved() {
    if (!isMouseOvered) {
      background(myColor);
      isMouseOvered = true;
      mouseOveredCount++;
    }
  }
}
