package edu.umb.cs681;

import java.util.LinkedList;

public class Observable {
	
	private LinkedList<Observer> observers;
	
	private boolean changed;
	
	// constructor
	public Observable() {
		observers = new LinkedList<Observer>();
	}
	
	public void addObserver(Observer o) {
		if(o == null) throw new NullPointerException();
		observers.add(o);
	}
	
	public void deleteObserver(Observer o) {
		if(observers.remove(o)) {
			System.out.println("Observer has removed");
		}else {
			System.out.println("This observer is not existed");
		}
		
	}
	
	public void deleteObservers() {
		observers.clear();
	}
	
	public int countObservers() {
		return observers.size();
	}
	
	protected void setChanged() {
		changed = true;
	}
	
	protected void clearChanged() {
		changed = false;
	}
	
	public boolean hasChanged() {
		return changed;
	}
	
	public void notifyObservers() {
		notifyObservers(null);
	}
	
	public void notifyObservers(Object obj) {
		if(!changed) {
			return;
		}
		observers.forEach(n -> n.update(this, obj));
		clearChanged();
	}
}
