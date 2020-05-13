package edu.umb.cs681;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	
	// hashmap
	ConcurrentHashMap <java.nio.file.Path, Integer> hashMap = new ConcurrentHashMap <java.nio.file.Path, Integer>();
	// non-static lock
//	private ReentrantLock nonStaticLock = new ReentrantLock();
	// static lock
	private static ReentrantLock staticLock = new ReentrantLock();
	// instance
	private static AccessCounter instance = null;
	
	private AccessCounter(){}
	
	
	public static AccessCounter getInstance()
	{
		staticLock.lock();
		try {
			if(instance==null)
			{
				instance = new AccessCounter();
			}
		} finally {
			staticLock.unlock();
		}
		return instance;
	}

	public void increment(java.nio.file.Path path)
	{
//		nonStaticLock.lock();
//		try {
		if(hashMap.containsKey(path)) {
			System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + hashMap.get(path));
			hashMap.put(path, hashMap.get(path)+1);
		} else {
			System.out.println(Thread.currentThread().getName() + " set " + path + " to 0");
			hashMap.put(path, 1);
		}
//		}finally {
//			nonStaticLock.unlock();
//		}
	}
	
	public int getCount(java.nio.file.Path path)
	{
//		int tmp = 0;
//		nonStaticLock.lock();
//		try {
		if(hashMap.containsKey(path)) {
			System.out.println(Thread.currentThread().getName() + " get " + path + " count " + hashMap.get(path));
			return hashMap.get(path);
		} else {
			System.out.println(Thread.currentThread().getName() + " get " + path + " count " + 0);
			return 0;
		}
//		} finally {
//			nonStaticLock.unlock();
//		}
//		return tmp;
	}

	
}
