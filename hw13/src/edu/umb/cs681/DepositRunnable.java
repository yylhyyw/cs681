package edu.umb.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable {

	private ThreadSafeBankAccount bankAccount = null;
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public DepositRunnable(ThreadSafeBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				if (done) {
					break;
				}
				bankAccount.deposit(300);
				Thread.sleep(1000);
			}
		} catch (InterruptedException exception) {
			System.out.println(exception);
		}

	}

}
