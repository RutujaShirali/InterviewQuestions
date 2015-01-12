package com.rutuja.string;

public class Permutations {

	public void printPermutations(String input) {
		printPermutations_R("", input);
	}

	private void printPermutations_R(String prefix, String input) {
		if (input.length() == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < input.length(); i++) {
				printPermutations_R(
						prefix + input.charAt(i),
						input.substring(0, i)
								+ input.substring(i + 1, input.length()));
			}
		}
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		p.printPermutations("ABC");
	}

}
