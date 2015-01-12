package com.rutuja.ProjectEuler;

import java.util.ArrayList;
import java.util.List;

public class Problem14 {

	public List<Long> generateCollatz(long num) {
		List<Long> collatzList = new ArrayList<Long>();
		while (num > 1) {
			collatzList.add(num);
			if (num % 2 == 0) {
				num = num / 2;
			} else {
				num = 3 * num + 1;
			}

		}
		collatzList.add(num);
		return collatzList;
	}

	public int largestCollatz(int n) {
		int maxSize = 0;
		int number = 1;

		for (int i = 1; i < n; i++) {
			int curSize = generateCollatz(i).size();
			if (curSize > maxSize) {
				maxSize = curSize;
				number = i;
			}
		}
		return number;
	}

	public static void main(String[] args) {
		System.out.println(new Problem14().largestCollatz(1000000));
	}

}
