import com.shigeodayo.pframe.*;

PFrame[][] frames;

// dot colors
color[][] colors = {
  {color(98, 98, 60), color(117, 114, 69), color(124,116,69), color(135, 128, 102), color(152, 148, 100), color(164, 156, 109), color(188, 171, 115), color(186, 169, 117), color(180, 177, 124), color(186, 177, 144)},
  {color(118, 119, 77), color(148, 134, 85), color(160, 144, 93), color(167, 146, 89), color(105, 86, 53), color(60, 41, 24), color(152, 135, 91), color(206, 190, 139), color(201, 195, 137), color(204, 196, 131)},
  {color(134, 130, 83), color(168, 154, 105), color(189, 169, 116), color(154, 129, 75), color(228, 171, 104), color(119, 79, 27), color(42, 33, 26), color(184, 172, 120), color(216, 209, 141), color(217, 212, 146)},
  {color(78, 75, 40), color(103, 94, 51), color(141, 135, 85), color(115, 82, 47), color(204, 150, 78), color(156, 115, 59), color(30, 21, 22), color(92, 99, 58), color(176, 185, 118), color(214, 203, 139)},
  {color(29, 34, 28), color(45, 49, 26), color(24, 30, 16), color(75, 48, 27), color(203, 154, 85), color(142, 97, 56), color(13, 13, 13), color(56, 60, 37), color(105, 127, 78), color(111, 125, 74)},
  {color(11, 11, 13), color(37, 39, 26), color(65, 67, 46), color(15, 14, 9), color(77, 56, 27), color(69, 49, 25), color(12, 12, 10), color(50, 52, 31), color(76, 86, 51), color(86, 91, 61)},
  {color(27, 29, 28), color(45, 42, 23), color(32, 33, 17), color(20, 18, 19), color(111, 89, 48), color(197, 140, 69), color(75, 54, 25), color(34, 34, 26), color(115, 101, 64), color(138, 121, 65)},
  {color(24, 23, 19), color(67, 58, 27), color(24, 25, 19), color(91, 68, 36), color(243, 208, 116), color(237, 198, 105), color(127, 94, 43), color(52, 37, 16), color(66, 55, 37), color(118, 111, 57)},
  {color(44, 36, 25), color(66, 51, 20), color(20, 20, 18), color(79, 64, 35), color(160, 144, 67), color(148, 127, 60), color(49, 38, 20), color(24, 26, 15), color(19, 17, 18), color(56, 38, 28)},
  {color(44, 34, 24), color(40, 27, 19), color(14, 12, 13), color(18, 16, 17), color(15, 15, 13), color(14, 12, 13), color(7, 7, 7), color(34, 35, 21), color(14, 14, 14), color(27, 22, 16)},
  {color(15, 20, 23), color(25, 25, 27), color(20, 28, 23), color(10, 10, 10), color(19, 19, 19), color(13, 13, 13), color(17, 17, 17), color(16, 16, 18), color(22, 22, 24), color(12, 19, 25)},
  {color(19, 19, 21), color(21, 21, 21), color(34, 33, 28), color(23, 19, 7), color(7, 7, 7), color(12, 12, 12), color(17, 17, 17), color(18, 18, 18), color(15, 15, 17), color(15, 26, 28)},
  {color(14, 14, 16), color(15, 19, 22), color(55, 42, 26), color(154, 100, 40), color(114, 77, 25), color(34, 26, 13), color(17, 24, 17), color(28, 30, 29), color(17, 16, 21), color(9, 20, 24)},  
  {color(6, 12, 12), color(20, 20, 22), color(54, 45, 36), color(96, 73, 31), color(113, 79, 33), color(75, 42, 25), color(33, 24, 15), color(14, 12, 13), color(27, 28, 30), color(15, 25, 26)}
};

// new screen location
int[] newX = {
  70, 90, 190, 210, 70, 100, 180, 210, 70, 110, 170, 210, 70, 120, 160, 210, 70, 130, 150, 210, 70, 140, 210,
  300, 320, 340, 280, 360, 280, 360, 280, 360, 280, 360, 300, 320, 340,
  430, 450, 500, 430, 460, 500, 430, 470, 500, 430, 480, 500, 430, 490, 500, 430, 500, 500,
  640, 630, 650, 620, 660, 610, 670, 600, 620, 640, 660, 680, 590, 690,
  610, 610, 610, 610, 610, 610, 630, 650, 670,
  620, 640, 660, 640, 640, 640, 640, 620, 640, 660, 
  630, 650, 610, 670, 630, 650, 610, 670, 630, 650,  
  790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790, 790,
  70, 110, 150, 190, 230, 270, 310, 350, 390, 430, 470, 510, 550, 590, 630, 670, 710, 750, 
  50, 50, 70, 790, 810, 810
};
int[] newY = {
  520, 520, 520, 520, 540, 540, 540, 540, 560, 560, 560, 560, 580, 580, 580, 580, 600, 600, 600, 600, 620, 620, 620, 
  520, 520, 520, 540, 540, 560, 560, 580, 580, 600, 600, 620, 620, 620,
  520, 520, 520, 540, 540, 540, 560, 560, 560, 580, 580, 580, 600, 600, 600, 620, 620, 620,
  520, 540, 540, 560, 560, 580, 580, 600, 600, 600, 600, 600, 620, 620,
  40, 60, 80, 100, 120, 140, 140, 140, 140,
  200, 200, 200, 220, 240, 260, 280, 300, 300, 300,  
  360, 360, 380, 380, 400, 420, 440, 440, 460, 460,  
  30, 70, 110, 150, 190, 230, 270, 310, 350, 390, 430, 470, 510, 550, 590, 630, 670, 710,
  710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710, 710,
  710, 730, 730, 10, 10, 30
};

int mouseOveredCount = 0;

void setup() {
  size(200, 150);
  background(0, 0, 0); 
  
  frames = new PFrame[14][10];
  for (int y = 0; y < frames.length; y++) {
    for (int x = 0; x < frames[0].length; x++) {
      MyApplet myApp = new MyApplet();
      myApp.setColor(colors[y][x]);
      frames[y][x] = new PFrame(myApp, 22 * x + 30, 22 * y + 30, false);
    }
  }
}

void draw() {
  background(0, 0, 0);
  if (mouseOveredCount == frames.length * frames[0].length) {
    text("Who is she?", 20, 40);
    text("She is ...", 60, 80);
    text("(mouse over me)", 60, 100);
    if (mouseX > 0 && mouseY > 0) {
      for (int y = 0; y < frames.length; y++) {
        for (int x = 0; x < frames[0].length; x++) {
          delay(100);
          int index = frames[0].length * y + x;
          frames[y][x].setLocation(newX[index], newY[index]);
        }
      }
      delay(200);
      for (int y = 0; y < frames.length; y++) {
        for (int x = 0; x < frames[0].length; x++) {
          final int x_ = x;
          final int y_ = y;
          new Thread() {
            public void run() {
              int posX = (int) random(0, screen.width);
              int posY = (int) random(0, screen.height);
              frames[y_][x_].setLocation(posX, posY);      
            }
          }.start();
        }
      }
      delay(2000);   
      exit();
    }
  }
}


private class MyApplet extends PApplet {
  color myColor;
  boolean isMouseOvered = false;
  
  void setup() {
    size(20, 20);
    background(255, 255, 255);
  }
  void draw() {
  }
  
  void setColor(color myColor) {
    this.myColor = myColor;
  }  

  void mouseMoved() {
    if (!isMouseOvered) {
      background(myColor);
      isMouseOvered = true;
      mouseOveredCount++;
    }
  }    
}
