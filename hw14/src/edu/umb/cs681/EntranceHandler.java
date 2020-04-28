package edu.umb.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class EntranceHandler implements Runnable {
	
	private AdmissionControl control;
	
	public EntranceHandler(AdmissionControl control) {
		this.control = control;
	}
	@Override
	public void run() {
		control.enter();
	}
}
