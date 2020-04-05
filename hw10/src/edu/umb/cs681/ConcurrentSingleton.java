package edu.umb.cs681;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingleton implements Runnable{
	private ConcurrentSingleton() {};
	private static AtomicReference<ConcurrentSingleton> atomicInstance = new AtomicReference<ConcurrentSingleton>();
	
	public static AtomicReference<ConcurrentSingleton> getInstance() {
			if(atomicInstance.get() == null) {
				atomicInstance.set(new ConcurrentSingleton());
				System.out.println("ConcurrentSingleton instance created!");
			}
		return atomicInstance;
	}

	@Override
	public void run() {
		System.out.println("Thread starts");
		AtomicReference<ConcurrentSingleton> csi = ConcurrentSingleton.getInstance();
		System.out.println("current instance: " + csi);
		System.out.println("Thread ends");
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
