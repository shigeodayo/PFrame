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
package com.shigeodayo.pframe;

import java.awt.Container;
import java.awt.Insets;

import javax.swing.JFrame;

import processing.core.PApplet;

public class PFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private PApplet target = null;

	private boolean showTitleBar = true;

	/**
	 * constructor
	 * 
	 * @param target
	 *            target PApplet
	 * @param x
	 *            window location
	 * @param y
	 *            window location
	 */
	public PFrame(PApplet target, int x, int y) {
		initialize(target, x, y, true);
	}

	/**
	 * constructor
	 * 
	 * @param target
	 *            target PApplet
	 * @param x
	 *            window location
	 * @param y
	 *            window location
	 * @param showTitleBar
	 *            showing title bar or not
	 * 
	 */
	public PFrame(PApplet target, int x, int y, boolean showTitleBar) {
		initialize(target, x, y, showTitleBar);
	}

	public PApplet getApplet() {
		return target;
	}

	public void setTransparent(boolean transparent, float alpha) {
		if (showTitleBar) {
			System.err.println("Can't transparentize this frame.\n"
					+ "Hide title bar when you call constructor.");
			return;
		}
		com.sun.awt.AWTUtilities.setWindowOpaque(this, !transparent);
		if (transparent) {
			com.sun.awt.AWTUtilities.setWindowOpacity(this, alpha);
		}
	}

	private void initialize(PApplet target, int x, int y, boolean showTitleBar) {
		this.target = target;

		showTitleBar(showTitleBar);

		Container contentPane = this.getContentPane();
		contentPane.add(target);

		target.init();

		setVisible(true);
		Insets insets = getInsets();
		setLocation(x, y);
		setSize(target.width + insets.right + insets.left, target.height
				+ insets.top + insets.bottom);
		target.resize(target.width + insets.right + insets.left, target.height
				+ insets.top + insets.bottom);

	}

	private void showTitleBar(boolean show) {
		this.showTitleBar = show;
		if (!show) {
			removeNotify();
			setUndecorated(!show);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setUndecorated(!show);
			addNotify();
		}
	}
}