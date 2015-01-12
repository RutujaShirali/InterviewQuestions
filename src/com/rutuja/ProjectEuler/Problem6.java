package com.rutuja.ProjectEuler;

public class Problem6 {

	public int sumofSquares(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (i * i);
		}
		return sum;
	}

	public int squaresofSums(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result * result;
	}

	public static void main(String[] args) {
		Problem6 p = new Problem6();
		System.out.println(p.squaresofSums(100) - p.sumofSquares(100));

	}

}
