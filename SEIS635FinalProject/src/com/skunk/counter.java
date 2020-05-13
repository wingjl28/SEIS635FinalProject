package com.skunk;

public class counter {

	private int value;
	counter(){
		this.value = 0;
	}
	
	public void addCount() {
		this.value++;
	}
	
	public void removeCount() {
		this.value--;
	}
	
	public int getValue() {
		return this.value;
	}
}
