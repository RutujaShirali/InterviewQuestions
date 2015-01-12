package com.rutuja.ProjectEuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 {

	public int nameScores() throws FileNotFoundException {
		Scanner scan = new Scanner(new File(
				"C:\\Users\\Rutuja\\Desktop\\p022_names.txt"));
		String names = scan.nextLine();
		names = names.replace("\"", "");
		String[] name = names.split(",");
		System.out.println(Arrays.toString(name));
		Arrays.sort(name);
		int s = 0;
		for (int i = 0; i < name.length; i++) {
			s += getAlphaScore(name[i]) * (i + 1);
		}
		return s;
	}

	public int getAlphaScore(String str) {
		int score = 0;
		for (int i = 0; i < str.length(); i++) {
			score += (str.charAt(i) - 'A' + 1);
		}
		return score;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(new Problem22().nameScores());
	}

}
