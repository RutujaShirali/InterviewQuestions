package com.rutuja.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramArray {

	class Pair implements Comparable<Pair> {
		String a, b;

		public Pair(String a, String b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair o) {
			return a.compareTo(o.a);
		}

	}

	public void sortArray(String[] arr) {
		Pair[] help = new Pair[arr.length];
		for (int i = 0; i < arr.length; i++) {
			char[] chars = arr[i].toCharArray();
			Arrays.sort(chars);
			help[i] = new Pair(new String(chars), arr[i]);
		}
		Arrays.sort(help);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = help[i].b;
		}

		System.out.println(Arrays.toString(arr));
	}

	// Method 2

	public long calculateVal(String str) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
				53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
		long val = 1;
		for (int i = 0; i < str.length(); i++) {
			val *= prime[str.charAt(i) - 'a'];
		}
		return val;
	}

	public void sortArray2(String[] arr) {
		Map<Long, List<String>> m = new HashMap<>();
		List<String> list;
		for (int i = 0; i < arr.length; i++) {
			long val = calculateVal(arr[i]);
			list = m.get(val);
			if (list == null) {
				m.put(val, list = new ArrayList<>());
			}
			list.add(arr[i]);
		}
		int index = 0;
		for (long k : m.keySet()) {

			list = m.get(k);
			for (int i = 0; i < list.size(); i++) {
				arr[index++] = list.get(i);
			}
		}

		System.out.println(Arrays.toString(arr));
	}
	
	public void sortArray3(String[] arr){
		Arrays.sort(arr, new AnagramComparator());
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		String[] arr = { "cat", "dog", "act", "god" };
		new AnagramArray().sortArray3(arr);
	}

	class AnagramComparator implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			if (calculateVal(a) == calculateVal(b))
				return 0;
			return a.compareTo(b);

		}

	}

}
