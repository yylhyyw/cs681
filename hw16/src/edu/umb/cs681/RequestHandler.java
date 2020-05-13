package edu.umb.cs681;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {

	private AccessCounter access = AccessCounter.getInstance();
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;
	
	public RequestHandler() {}
	
	public void setDone()
	{
		lock.lock();
		try {
			done = true;
			System.out.println(Thread.currentThread().getName() + " set to done");
		} finally {
			lock.unlock();
		}
		
	}
	
	
	@Override
	public void run() {
		Random random = new Random();
		int randomHtml = random.nextInt(5);
		while(true) {
			lock.lock();
			try {
				if(done) {
					break;
				}
			} finally {
				lock.unlock();
			}
			java.nio.file.Path path = null;
			switch(randomHtml){
			case 0:
				path = java.nio.file.Paths.get("a.html");
				break;
			case 1:
				path = java.nio.file.Paths.get("b.html");
				break;
			case 2:
				path = java.nio.file.Paths.get("c.html");
				break;
			case 3:
				path = java.nio.file.Paths.get("d.html");
				break;
			case 4:
				path = java.nio.file.Paths.get("e.html");
				break;
			default:
			}
			
			AccessCounter.getInstance().increment(path);
			AccessCounter.getInstance().getCount(path);
			
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " " + e);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Thread[] threads = new Thread[12];
		RequestHandler request = new RequestHandler();


		for (int i = 0; i < 12; i++) {
			System.out.println("Start Thread " + i);
			threads[i] = new Thread(request);
			threads[i].start();
		}

		request.setDone();
		for(int i = 0; i < 12; i++) {
			threads[i].interrupt();
			try {
				threads[i].join();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
