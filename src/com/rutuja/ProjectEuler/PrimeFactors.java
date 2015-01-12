package com.rutuja.ProjectEuler;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
	public int primeFactors() {
		long n = 600851475143L;
		int res = 1;
		List<Integer> primeFactors = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				primeFactors.add(i);
				n /= i;
			}
		}
		for (int num : primeFactors) {
			if (num > res)
				res = num;
		}
		return res;
	}

	public static void main(String[] args) {
		PrimeFactors pf = new PrimeFactors();
		System.out.println(pf.primeFactors());
	}

}
