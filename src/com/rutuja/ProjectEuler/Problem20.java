package com.rutuja.ProjectEuler;

import java.math.BigInteger;

public class Problem20 {

	public BigInteger calculateFactorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		return n.multiply(calculateFactorial(n.subtract(BigInteger.ONE)));
	}

	public int sumFactDigits(int n) {
		BigInteger result = calculateFactorial(new BigInteger(String.valueOf(n)));
		System.out.println(result);
		int sum = 0;
		String str = result.toString();
		for(int i = 0; i< str.length(); i++){
			sum += Character.getNumericValue(str.charAt(i));
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Problem20().sumFactDigits(100));
	}

}
