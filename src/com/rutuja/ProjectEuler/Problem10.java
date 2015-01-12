package com.rutuja.ProjectEuler;

public class Problem10 {

	public long findSum(int n) {
		Problem7 p = new Problem7();
		long sum = 0;
		for (int i = 2; i < n; i++) {
			if (p.isPrime(i))
				sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Problem10 o = new Problem10();
		System.out.println(o.findSum(2000000));
	}

}
