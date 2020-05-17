package edu.umb.cs681;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class File {

	private boolean changed = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public void change() {
		lock.lock();
		try {
			System.out.println("File is being changing...");
			changed = true;
		}finally {
			lock.unlock();
			System.out.println("change is done");
		}
	}
	
	public void save() {
		lock.lock();
		try {
			if(changed == false) {
				System.out.println("cannot save because file is changing");
				return;
			} else {
				String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				System.out.println("saved on " + currentTimeStamp);
				changed = false;
				System.out.println("saved file");
			}
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		File file = new File();
		Editor editor = new Editor(file);
		AutoSaver autoSaver = new AutoSaver(file);
		
		Thread tEditor = new Thread(editor);
		Thread tAutoSaver = new Thread(autoSaver);
		
		tEditor.start();
		tAutoSaver.start();
		try {
			Thread.sleep(5000);
			System.out.println("Thread set to done in 5 seconds");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		editor.setDone();
		autoSaver.setDone();
		
		try {
			tEditor.join();
			tAutoSaver.join();
		} catch (InterruptedException e1) {}
		
		System.out.println("end");
	}
}
