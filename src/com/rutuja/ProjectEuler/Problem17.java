package com.rutuja.ProjectEuler;

public class Problem17 {

	public String numberToWords(int num) {
		String[] tensWords = { "", "ten", "twenty", "thirty", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety" };
		String[] numWords = { "", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		String words = "";
		if (num == 1000) {
			words = "onethousand";
			return words;
		}
		if (num % 100 == 0) {
			words = numWords[num/100]+"hundred";
			return words;
		}
		if (num % 100 < 20) {
			words = numWords[num % 100];
			num /= 100;
		} else {
			words = numWords[num % 10];
			num /= 10;

			words = tensWords[num % 10] + words;
			num /= 10;
		}
		if (num == 0)
			return words;
		return numWords[num] + "hundredand" + words;

	}

	public int totalNumbers() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 1000; i++) {
			System.out.println(numberToWords(i));
			sb.append(numberToWords(i));
		}
		return sb.length();
	}

	public static void main(String[] args) {
		System.out.println(new Problem17().totalNumbers());

	}

}
