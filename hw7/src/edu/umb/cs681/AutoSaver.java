package edu.umb.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class AutoSaver extends File implements Runnable {

	private boolean done = false;
	private File file;
	private ReentrantLock lock = new ReentrantLock();
	
	public AutoSaver(File file) {
		this.file = file;
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}finally {
			lock.unlock();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			if(done) {
				System.out.println("Auto Saver exits");
				break;
			}
			try {
				System.out.println("Auto Saver called save()");
				save();
				Thread.sleep(2000);
			}catch (InterruptedException e) {}
		}
	}
}
