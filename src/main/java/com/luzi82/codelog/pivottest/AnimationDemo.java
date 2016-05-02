package com.luzi82.codelog.pivottest;

import java.awt.Color;
import java.awt.Graphics2D;

import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.ApplicationContext;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Panel;
import org.apache.pivot.wtk.Window;

// https://pivot.apache.org/tutorials/hello-world.html

public class AnimationDemo implements Application {

	private Window window = null;

	class C extends Panel {

		@Override
		public void paint(Graphics2D graphics) {
			System.err.println("YJNDJMRR paint");
			super.paint(graphics);
			int width = getWidth();
			int height = getHeight();
			int t = (int) (System.currentTimeMillis() % 500);
			graphics.setBackground(Color.WHITE);
			graphics.setColor(Color.BLACK);
			graphics.clearRect(0, 0, width, height);
			graphics.fillRect(t, 0, 100, 100);
		}

	}

	public void startup(Display display, Map<String, String> arg1) throws Exception {
		window = new Window();

		C c = new C();

		window.setContent(c);
		window.setTitle("Hello World!");
		window.setMaximized(true);

		window.open(display);

		
		ApplicationContext.scheduleRecurringCallback(new Runnable() {
			@Override
			public void run() {
				System.err.println("GTVUDJER run start");
				c.repaint(false);
				System.err.println("AZSQAEWR run end");
			}
		}, 10);

	}

	public void resume() throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean shutdown(boolean arg0) throws Exception {
		if (window != null) {
			window.close();
		}

		return false;
	}

	public void suspend() throws Exception {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		DesktopApplicationContext.main(AnimationDemo.class, args);
	}

}
