package com.shigeodayo.pframe;

import java.awt.Insets;

import javax.swing.JFrame;

import processing.core.PApplet;

public class PFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private PApplet target = null;
	
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
		this.target = target;
		
		add(target);
		target.init();
		setVisible(true);
		Insets insets = getInsets();
		setLocation(x, y);
		setSize(target.width + insets.right + insets.left, target.height
				+ insets.top + insets.bottom);
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
		this.target = target;

		if (!showTitleBar) {
			removeNotify();
			setUndecorated(true);
			addNotify();
		}
		add(target);
		target.init();
		setVisible(true);
		Insets insets = getInsets();
		setLocation(x, y);
		setSize(target.width + insets.right + insets.left, target.height
				+ insets.top + insets.bottom);
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
	 * 
	 */
	public PFrame(PApplet target, int x, int y, int width, int height) {
		this.target = target;

		add(target);
		target.init();
		setVisible(true);
		Insets insets = getInsets();
		setLocation(x, y);
		setSize(width + insets.right + insets.left, height + insets.top
				+ insets.bottom);

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
	 * @param showTitleBar
	 *            showing title bar or not
	 * 
	 */
	public PFrame(PApplet target, int x, int y, int width, int height,
			boolean showTitleBar) {
		this.target = target;

		if (!showTitleBar) {
			removeNotify();
			setUndecorated(true);
			addNotify();
		}
		add(target);
		target.init();
		setVisible(true);
		Insets insets = getInsets();
		setLocation(x, y);
		setSize(width + insets.right + insets.left, height + insets.top
				+ insets.bottom);

	}
	
	public PApplet getApplet() {
		return target;
	}	
}