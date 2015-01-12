package com.rutuja.ProjectEuler;

import java.math.BigInteger;

public class Problem16 {

	public BigInteger calculatePowerSum() {
		BigInteger sum = BigInteger.ZERO;
		BigInteger num = new BigInteger("2");
		BigInteger power = num.pow(1000);
		while (power.compareTo(BigInteger.ZERO) == 1) {
			sum = sum.add(power.mod(BigInteger.TEN));
			power = power.divide(BigInteger.TEN);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Problem16().calculatePowerSum());
	}

}
