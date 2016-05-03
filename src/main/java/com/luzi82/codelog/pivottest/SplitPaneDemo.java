package com.luzi82.codelog.pivottest;

import java.awt.Color;
import java.awt.Font;

import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.HorizontalAlignment;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.Orientation;
import org.apache.pivot.wtk.SplitPane;
import org.apache.pivot.wtk.VerticalAlignment;
import org.apache.pivot.wtk.Window;

// https://pivot.apache.org/tutorials/hello-world.html

public class SplitPaneDemo implements Application {

	private Window window = null;

	public void startup(Display display, Map<String, String> arg1) throws Exception {
		window = new Window();

		SplitPane splitPane = new SplitPane(Orientation.HORIZONTAL);

		Label labelLeft = new Label();
		labelLeft.setText("Hello World!");
		labelLeft.getStyles().put("font", new Font("Arial", Font.BOLD, 24));
		labelLeft.getStyles().put("color", Color.RED);
		labelLeft.getStyles().put("horizontalAlignment", HorizontalAlignment.CENTER);
		labelLeft.getStyles().put("verticalAlignment", VerticalAlignment.CENTER);

		Label labelRight = new Label();
		labelRight.setText("Hello World!");
		labelRight.getStyles().put("font", new Font("Arial", Font.BOLD, 24));
		labelRight.getStyles().put("color", Color.GREEN);
		labelRight.getStyles().put("horizontalAlignment", HorizontalAlignment.CENTER);
		labelRight.getStyles().put("verticalAlignment", VerticalAlignment.CENTER);

		splitPane.setLeft(labelLeft);
		splitPane.setRight(labelRight);
		splitPane.setSplitRatio(0.3333f);

		window.setContent(splitPane);
		window.setTitle("Hello World!");
		window.setMaximized(true);

		window.open(display);
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
		DesktopApplicationContext.main(SplitPaneDemo.class, args);
	}

}
