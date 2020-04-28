package edu.umb.cs681;

public class Client {
	public static void main(String[] args) {
		ThreadSafeBankAccount bankAccount = new ThreadSafeBankAccount();
		DepositRunnable depositRunnable= new DepositRunnable(bankAccount);
		WithdrawRunnable withdrawRunnable = new WithdrawRunnable(bankAccount);
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			Thread depositThread = new Thread(depositRunnable);
			depositThread.start();
			threads[i] = depositThread;
			Thread withdrawThread = new Thread(withdrawRunnable);
			withdrawThread.start();
			threads[i] = withdrawThread;
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		depositRunnable.setDone();
		withdrawRunnable.setDone();
		for (int i = 0; i < 10; i++) {
			threads[i].interrupt();
			try {
				threads[i].join();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
