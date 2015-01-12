package com.rutuja.ProjectEuler;

public class MultiplesOf {

	public int sumOfMultiples() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		MultiplesOf m = new MultiplesOf();
		System.out.println(m.sumOfMultiples());
	}

}
