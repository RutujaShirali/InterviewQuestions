package com.rutuja.adhoc;

public class NoofWords {

	public int wordcount(String sentence) {
		// String[] arr = sentence.split("\\s+");
		// return arr.length;

		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			//Skip whitespace
			while(i < sentence.length() && Character.isWhitespace(sentence.charAt(i))) i++;
			//Non-whitespace
			if( i == sentence.length())
				break;
			while(i < sentence.length() && !Character.isWhitespace(sentence.charAt(i))) i++;
			count++;
		}
		return count;

	}

	public static void main(String[] args) {
		NoofWords nw = new NoofWords();
		System.out.println(nw.wordcount("    This is a demo    "));

	}

}
