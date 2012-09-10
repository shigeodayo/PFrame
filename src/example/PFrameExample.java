/*
 *
 Copyright (c) <2012>, <Shigeo Yoshida>
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
The names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
		thirdFrame = new PFrame(thirdApplet, 420, 0, false);
		thirdFrame.setTitle("Third Frame");
		noCursor();
	}

	public void draw() {
	}

	public void mouseClicked() {
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