package com.rutuja.ProjectEuler;

public class Problem5 {
	public int SmallestMultiple() {
		int res = 1;
		boolean flag;
		do {
			flag = true;
			res += 1;
			for (int i = 1; i <= 20; i++) {
				if (res % i != 0)
					flag = false;
			}
		} while (flag != true);
		return res;
	}

	public static void main(String[] args) {
		Problem5 p = new Problem5();
		System.out.println(p.SmallestMultiple());
	}

}
