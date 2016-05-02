package com.luzi82.codelog.pivottest;

import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.ApplicationContext;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.TreeView;
import org.apache.pivot.wtk.Window;
import org.apache.pivot.wtk.content.TreeBranch;
import org.apache.pivot.wtk.content.TreeNode;

public class TreeDemo implements Application {

	private Window window = null;

	@Override
	public void startup(Display arg0, Map<String, String> arg1) throws Exception {
		window = new Window();

		TreeBranch treeRoot0 = new TreeBranch("root0");
		TreeBranch treeRoot1 = new TreeBranch("root1");
		treeRoot0.add(treeRoot1);

		TreeView treeView = new TreeView(treeRoot0);

		window.setContent(treeView);
		window.setTitle("codelog.pivot Tree");
		window.setMaximized(true);

		new Thread() {
			public void run() {
				try {
					while (true) {
						ApplicationContext.queueCallback(new Runnable() {
							@Override
							public void run() {
								String t = "" + System.currentTimeMillis();
								TreeNode node = new TreeNode(t);
								treeRoot1.add(node);
								if (treeRoot1.getLength() > 10) {
									treeRoot1.remove(0, treeRoot1.getLength() - 10);
								}
								for (TreeNode tn : treeRoot1) {
									tn.setText(tn.getText() + ".");
								}
							}
						});
						Thread.sleep(1000);
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}.start();

		window.open(arg0);
	}

	@Override
	public void resume() throws Exception {
	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		if (window != null) {
			window.close();
		}
		return false;
	}

	@Override
	public void suspend() throws Exception {
	}

	public static void main(String[] args) {
		DesktopApplicationContext.main(TreeDemo.class, args);
	}

}
