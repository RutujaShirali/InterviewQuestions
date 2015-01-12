package com.rutuja.ProjectEuler;

import java.util.ArrayList;
import java.util.List;

public class Problem12 {

	public List<Integer> generateFactors(int num) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				res.add(i);
		}
		return res;
	}

	public int triangularNumber(int size) {
		for (int i = 0;; i++) {
			int n = i * (i + 1) / 2;
			if (generateFactors(n).size() > size)
				return n;
		}
	}

	public static void main(String[] args) {
		Problem12 p = new Problem12();
		System.out.println(p.triangularNumber(500));
	}

}
