package edu.umb.cs681;

public class Client {
	
	public static void main(String[] args) {
		AdmissionControl admissionControl = new AdmissionControl();
		EntranceHandler entranceHandler = new EntranceHandler(admissionControl);
		ExitHandler exitHandler = new ExitHandler(admissionControl);
		
		Thread entranceThread = new Thread(entranceHandler);
		entranceThread.start();
		Thread exitThread = new Thread(exitHandler);
		exitThread.start();

		try{
			Thread.sleep(1000);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		entranceHandler.setDone();
		exitHandler.setDone();
		entranceThread.interrupt();
		exitThread.interrupt();
		try {
			entranceThread.join();
			exitThread.join();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
