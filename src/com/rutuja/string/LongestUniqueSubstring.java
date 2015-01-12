package com.rutuja.string;

import java.util.Arrays;

public class LongestUniqueSubstring {

	public int lenUniqueSub(String s) {
		int maxLength = 1, curlength = 1;
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		visited[s.charAt(0)] = 0;
		for (int i = 1; i < s.length(); i++) {
			int prevIndex = visited[s.charAt(i)];
			if (prevIndex == -1 || i - curlength > prevIndex)
				curlength += 1;
			else {
				if (curlength > maxLength)
					maxLength = curlength;
				curlength = i - prevIndex;
			}
			visited[s.charAt(i)] = i;
		}
		if (curlength > maxLength)
			maxLength = curlength;
		return maxLength;
	}

	public static void main(String[] args) {
		LongestUniqueSubstring lus = new LongestUniqueSubstring();
		System.out.println(lus.lenUniqueSub("Abcdefghijklmnopqrstuvwxyz"));
	}

}
