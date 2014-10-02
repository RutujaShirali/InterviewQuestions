package com.rutuja.adhoc;
/**
 * 
 * Collatz Conjecture
 * @author Rutuja
 *
 */


public class Collatz {

	public static void main(String[] args) {
		System.out.println(collatz(3));
		
	}

	private static int collatz(long n) {
		if (n <= 1)
			return 0;
		return 1 + collatz(n % 2 == 0 ? n / 2 : 3 * n + 1);

	}
}
