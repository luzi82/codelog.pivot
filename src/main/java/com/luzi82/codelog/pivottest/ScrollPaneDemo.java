package com.luzi82.codelog.pivottest;

import org.apache.pivot.collections.LinkedList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ScrollPane;
import org.apache.pivot.wtk.ScrollPane.ScrollBarPolicy;
import org.apache.pivot.wtk.Window;

public class ScrollPaneDemo implements Application {

	private Window window = null;

	public void startup(Display display, Map<String, String> arg1) throws Exception {
		window = new Window();

		ScrollPane sp = new ScrollPane(ScrollBarPolicy.NEVER, ScrollBarPolicy.AUTO);

		LinkedList<String> list = new LinkedList<>();
		for (int i = 0; i < 1000; ++i) {
			list.add("" + i);
		}

		ListView lv = new ListView(list);
		lv.setPreferredWidth(-1);
		lv.setPreferredHeight(-1);

		sp.setView(lv);

		// window.setContent(lv);
		window.setContent(sp);
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
		DesktopApplicationContext.main(ScrollPaneDemo.class, args);
	}

}
