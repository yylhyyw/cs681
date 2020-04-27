package edu.umb.cs681;

public class Client implements Runnable {

	private Address addr1 = new Address("XXX Street", "XXX City", "XXX State", 00000);
	private Address addr2 = new Address("YYY Street", "YYY City", "YYY State", 11111);
	private Customer customer1 = new Customer(addr1);
	private Customer customer2 = new Customer(addr2);
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Client());
		Thread t2 = new Thread(new Client());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	@Override
	public void run() {
		customer1.getAddress();
		customer2.getAddress();
		customer1.setAddress(addr2);
		customer2.setAddress(addr1);
		customer1.getAddress();
		customer2.getAddress();
	}

}
