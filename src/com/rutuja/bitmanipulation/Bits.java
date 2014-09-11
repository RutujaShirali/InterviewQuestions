package com.rutuja.bitmanipulation;

public class Bits {
	
	public int test(int val, int index){
		return(val>>index)&1;
	}
	
	public int set(int val, int index){
		return val|(1<<index);
	}
	
	public int clear(int val, int index){
		return val & ~(1<<index);
	}
	
	public int toggle(int val, int index){
		return val^(1<<index);
	}

	public static void main(String[] args) {
		int a = 5, b = 6;
		Bits bt = new Bits();
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(bt.set(a, 1)));
	}

}
