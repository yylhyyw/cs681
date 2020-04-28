package edu.umb.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class ExitHandler implements Runnable {

	private AdmissionControl control;
	
	public ExitHandler(AdmissionControl control) {
		this.control = control;
	}
	@Override
	public void run() {
		control.exit();
	}

}
