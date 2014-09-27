package com.rutuja.adhoc;

public class Collatz {

	public static void main(String[] args) {
		
		
	}

	private int collatz(long n) {
		if (n <= 1)
			return 0;
		return 1 + collatz(n % 2 == 0 ? n / 2 : 3 * n + 1);

	}
}
