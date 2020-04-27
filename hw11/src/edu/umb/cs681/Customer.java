package edu.umb.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class Customer {
	
	private Address address;
	ReentrantLock lock = new ReentrantLock();
	
	// constructor
	public Customer(Address addr) {
		this.address = addr;
	}
	
	public void setAddress(Address addr) {
		lock.lock();
		try {
			this.address = addr;
			System.out.println("customer's address is set to " + this.address.toString());
		} finally {
			lock.unlock();
		}
		
	}
	
	public Address getAddress() {
		Address tmpAddress = null;
		lock.lock();
		try {
			tmpAddress = this.address;
			System.out.println("customer's address is set to " + tmpAddress.toString());
		} finally {
			lock.unlock();
		}
		return tmpAddress;
	}
}
