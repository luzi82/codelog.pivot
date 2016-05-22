package com.luzi82.codelog.pivottest;

import org.apache.pivot.collections.LinkedList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Bounds;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseWheelListener;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Dimensions;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.FlowPane;
import org.apache.pivot.wtk.Keyboard;
import org.apache.pivot.wtk.Keyboard.Modifier;
import org.apache.pivot.wtk.Mouse.ScrollType;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.ScrollPane;
import org.apache.pivot.wtk.ScrollPane.ScrollBarPolicy;
import org.apache.pivot.wtk.Window;

// https://pivot.apache.org/tutorials/hello-world.html

public class FlowPaneDemo implements Application {

	private Window window = null;
	private int level = 0;

	LinkedList<PushButton> buttonList = new LinkedList<>();

	public void startup(Display display, Map<String, String> arg1) throws Exception {
		Component c = null;

		for (int i = 0; i < 101; ++i) {
			PushButton pb = new PushButton();
			pb.setButtonData("asdf");
			buttonList.add(pb);
		}
		updateButtonSize(level);

		FlowPane fp = new FlowPane();
		for (PushButton pb : buttonList) {
			fp.add(pb);
		}
		fp.getStyles().put("backgroundColor", "yellow");
		c = fp;

		ScrollPane sp = new ScrollPane(ScrollBarPolicy.FILL, ScrollBarPolicy.FILL_TO_CAPACITY);
		sp.setView(c);
		c = sp;

		window = new Window();
		window.setContent(c);
		window.setTitle("Hello World!");
		window.setMaximized(true);

		window.open(display);

		fp.getComponentMouseWheelListeners().add(new ComponentMouseWheelListener() {
			@Override
			public boolean mouseWheel(Component component, ScrollType scrollType, int scrollAmount, int wheelRotation,
					int x, int y) {
				if (Keyboard.isPressed(Modifier.CTRL)) {
					Bounds b = fp.getVisibleArea();
					Dimensions d = fp.getSize();
					float yRatio = ((float) b.y) / d.height;
					updateButtonSize(level - scrollAmount * wheelRotation);
					d = fp.getSize();
					sp.setScrollTop((int) (yRatio * d.height));
					return true;
				}
				return false;
			}
		});
	}

	static final float PHI = 1.61803398875f;

	private void updateButtonSize(int newLevel) {
		level = newLevel;
		int size = (int) Math.round(256 * Math.pow(PHI, ((float) level) / 20));
		size = Math.max(1, size);
		for (PushButton pb : buttonList) {
			pb.setWidthLimits(size, size);
			pb.setHeightLimits(size, size);
		}
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
		DesktopApplicationContext.main(FlowPaneDemo.class, args);
	}

}
