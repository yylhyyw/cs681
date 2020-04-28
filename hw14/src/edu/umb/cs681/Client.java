package edu.umb.cs681;

public class Client {
	
	public static void main(String[] args) {
		AdmissionControl admissionControl = new AdmissionControl();
		EntranceHandler entranceHandler = new EntranceHandler(admissionControl);
		ExitHandler exitHandler = new ExitHandler(admissionControl);
		Thread[] enterthreads = new Thread[10];
		Thread[] exitthreads = new Thread[10];
		
		for(int i = 0; i <10; i++) {
			enterthreads[i] = new Thread(entranceHandler);
			enterthreads[i].start();
			exitthreads[i] = new Thread(exitHandler);
			exitthreads[i].start();
		}
	
	}
}
