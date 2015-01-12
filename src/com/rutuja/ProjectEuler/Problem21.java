package com.rutuja.ProjectEuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.rutuja.ProjectEuler.Problem12;

public class Problem21 {
	Problem12 obj = new Problem12();

	public int[] calculateSum() {
		int[] sums = new int[10000];
		for (int i = 1; i < 10000; i++) {
			int sum = 0;
			List<Integer> list = obj.generateFactors(i);
			list.remove(list.size() - 1);
			for (int n : list) {
				sum += n;
			}
			sums[i] = sum;
		}

		return sums;
	}

	public int sumAmicable() {
		int[] sums = calculateSum();
		int sum = 0;
		for (int i = 1; i < 10000; i++) {
			if (sums[i] < 10000 && i != sums[i] && sums[sums[i]] == i) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Problem21().sumAmicable());

	}

}
