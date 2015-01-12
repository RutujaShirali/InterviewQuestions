package com.rutuja.string;

public class PowerSet {

	private void powerset(char[] arr, boolean[] used, int index) {
		if (index == arr.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < used.length; i++) {
				if (used[i])
					sb.append(arr[i]);
			}
			System.out.println(sb.toString());
		} else {
			used[index] = false;
			powerset(arr, used, index + 1);
			used[index] = true;
			powerset(arr, used, index + 1);
		}
	}

	public static void main(String[] args) {
		String s = "abcd";
		new PowerSet().powerset(s.toCharArray(), new boolean[s.length()], 0);

	}

}
