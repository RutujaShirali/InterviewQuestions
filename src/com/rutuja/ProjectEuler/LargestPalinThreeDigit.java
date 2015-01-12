package com.rutuja.ProjectEuler;

public class LargestPalinThreeDigit {

	public int largestPal() {
		int rev = 0;
		int res = 0;
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {
				int mul = i * j;
				int temp = mul;
				rev = 0;
				while (temp > 0) {
					int dig = temp % 10;
					rev = rev * 10 + dig;
					temp = temp / 10;
				}
				if (rev == mul && rev > res) {
					res = rev;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LargestPalinThreeDigit lp = new LargestPalinThreeDigit();
		System.out.println(lp.largestPal());

	}

}
