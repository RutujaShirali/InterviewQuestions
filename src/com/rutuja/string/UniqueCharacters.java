package com.rutuja.string;
public class UniqueCharacters {
	
	/* determines whether the string has all unique characters
	 * 
	 * 
	 */
	public boolean isUnique(String str) {
		boolean[] check = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			if (check[str.charAt(i)])
				return false;
			check[str.charAt(i)] = true;
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		UniqueCharacters uc = new UniqueCharacters();
		System.out.println(uc.isUnique("abcd"));

	}

}
