package com.rutuja.ProjectEuler;

public class Problem7 {

	public boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
			;
		}
		return true;
	}

	public int generatePrime(int n) {
		int[] primes = new int[n];
		int num = 2;
		int index = 0;
		while(index < primes.length){
		if (isPrime(num)){
			primes[index] = num;
			index++;
		}
		num++;
		}

		return primes[n-1];
	}

	public static void main(String[] args) {
		Problem7 p = new Problem7();
		System.out.println(p.generatePrime(10001));
	}

}
