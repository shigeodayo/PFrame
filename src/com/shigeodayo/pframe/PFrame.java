package com.shigeodayo.pframe;

import java.awt.Insets;

import javax.swing.JFrame;

import processing.core.PApplet;

public class PFrame extends JFrame {

	private static final long serialVersionUID = 1L;

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
		setVisible(true);
		add(target);
		target.init();
		Insets insets = getInsets();
		setSize(target.width, target.height + insets.top);
		setBounds(x, y, target.width, target.height + insets.top);
	}

	/**
	 * constructor
	 * 
	 * @param traget
	 *            target PApplet
	 * @param x
	 *            window location
	 * @param y
	 *            window location
	 * @param width
	 *            window width
	 * @param height
	 *            window height
	 */
	public PFrame(PApplet target, int x, int y, int width, int height) {
		setVisible(true);
		add(target);
		target.init();
		Insets insets = getInsets();
		setBounds(x, y, width, height + insets.top);
	}
}