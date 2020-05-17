package edu.umb.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable{
	private ConcurrentSingleton() {};
	private static ConcurrentSingleton instance = null;
	private static ReentrantLock lock = new ReentrantLock();
	
	public static ConcurrentSingleton getInstance() {
		lock.lock();
		try {
			if(instance == null) {
				instance = new ConcurrentSingleton();
				System.out.println("ConcurrentSingleton instance created!");
			}
		}finally {
			lock.unlock();
		}
		return instance;
	}

	@Override
	public void run() {
		System.out.println("Thread starts");
		ConcurrentSingleton csi = ConcurrentSingleton.getInstance();
		System.out.println("current instance: " + ConcurrentSingleton.getInstance());
		System.out.println(Thread.currentThread().getId() + "Thread ends");
	}
	
	public static void main(String[] args) {
		Thread T1 = new Thread(new ConcurrentSingleton());
		Thread T2 = new Thread(new ConcurrentSingleton());
		Thread T3 = new Thread(new ConcurrentSingleton());
		Thread T4 = new Thread(new ConcurrentSingleton());
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		try {
			T1.join();
			T2.join();
			T3.join();
			T4.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
