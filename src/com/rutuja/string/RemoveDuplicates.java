package com.rutuja.string;

public class RemoveDuplicates {
	/**
	 * Removes duplicates without using additional buffer
	 * @param str
	 * @return
	 */

	public String removeDuplicate(String str) {
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if(i == j);
				else if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count < 1)
				result += str.charAt(i);
		}
		return result;
	}

	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		System.out.print(rd.removeDuplicate("Rockstar"));

	}

}
