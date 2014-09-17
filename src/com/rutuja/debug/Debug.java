package com.rutuja.debug;

import java.util.Random;

public class Debug {
	private static Random rand = new Random();

	public static int[] randomArray(int n, int min, int max){
		int[] arr = new int[n];
		for(int i =0; i< n; i++){
			arr[i] = rand.nextInt(max-min)+min;
		}
		return arr;
	}
	public static int[] randomArray(int n){
		return randomArray(n, -50, 50);
	}
	
	public static int[] randomArray(){
		return randomArray(10,0,100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
