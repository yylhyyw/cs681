package edu.umb.cs681;

public class Client {
    public static void main(String[] args) {
		
		Thread[] threads = new Thread[12];
		RequestHandler[] requestHandlers = new RequestHandler[12];


		for (int i = 0; i < 12; i++) {
			System.out.println("Start Thread " + i);
			requestHandlers[i] = new RequestHandler(i);
			threads[i] = new Thread(requestHandlers[i]);
			threads[i].start();
		}

		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " " + e);
		}
		for(int i = 0; i < 12; i++) {
			requestHandlers[i].setDone();
			threads[i].interrupt();
			try {
				threads[i].join();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}