package com.rutuja.string;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

	public void count(String sentence) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			Integer n = map.get(words[i]);
			n = (n == null) ? 1 : ++n;
			map.put(words[i], n);
		}

		System.out.println(map.get("abc"));
	}

	public static void main(String[] args) {
		WordFrequency wf = new WordFrequency();
		wf.count("abc hhdfg   kjgi abc jhgrgn hndjf abc jhurgh abc");
	}

}
