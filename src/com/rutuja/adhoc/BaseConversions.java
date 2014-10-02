package com.rutuja.adhoc;

/**
 * Convert from decimal to base, base to decimal and from one base to another base.
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class BaseConversions {

	public static String decimalToBase(int number, int radix) {
		String alphabets = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			sb.append(alphabets.charAt(number % radix));
			number /= radix;
		}
		return sb.reverse().toString();
	}

	public static String baseToDecimal(String number, int radix) {
		String alphabets = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		int i = 0;
		for (char c : alphabets.toCharArray()) {
			hashMap.put(c, i);
			i++;
		}
		int pow = 1;
		int sum = 0;
		for (i = number.length() - 1; i >= 0; i--, pow *= radix) {
			sum += hashMap.get(number.charAt(i)) * pow;
		}
		return sum + "";
	}
	
	public static String baseToBase(String number, int from, int to){
		return decimalToBase(Integer.parseInt(baseToDecimal(number, from)),to);
		
	}

	public static void main(String[] args) {
		System.out.println(decimalToBase(255, 16));
		System.out.println(baseToDecimal("FF", 16));
		System.out.println(baseToBase("19", 26, 36));

	}

}
