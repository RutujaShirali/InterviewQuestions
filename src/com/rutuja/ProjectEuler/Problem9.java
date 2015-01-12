package com.rutuja.ProjectEuler;

public class Problem9 {

	public long productPythTriplet() {
		long prod = 0;
		for (int a = 1; a <= 1000; a++) {
			for (int b = 1; b <= 1000; b++) {
				int c = 1000 - a - b;
				if (((a * a) + (b * b) == c * c) && c > 0)
					prod = a * b * c;
			}
		}
		return prod;
	}
	
	public static void main(String[] args) {
		Problem9 p = new Problem9();
		System.out.println(p.productPythTriplet());
	}

}
