package com.rutuja.ProjectEuler;

public class EvenFibo {

	public long sumOfEvenFibo() {
		long sum = 2;
		int fibo1 = 1;
		int fibo2 = 2;
		int fibo = fibo1 + fibo2;
		fibo1 = fibo2;
		fibo2 = fibo;
		while (fibo <= 4000000) {
			if (fibo % 2 == 0) {
				sum += fibo;
			}
			fibo = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibo;

		}
		return sum;
	}

	public static void main(String[] args) {
		EvenFibo ef = new EvenFibo();
		System.out.println(ef.sumOfEvenFibo());
	}

}
