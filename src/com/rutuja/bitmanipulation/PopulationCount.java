package com.rutuja.bitmanipulation;

public class PopulationCount {

	public static int count(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				count++;
			}
			num = num >> 1;
		}
		return count;
	}

	public static int count2(int num) {
		int[] table = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
		int c = 0;

		while (num != 0) {
			c += table[num & 0xF];
			num >>= 4;
		}
		return c;

	}

	public static int count3(int num) {
		int c = 0;
		while (num != 0) {
			System.out.println(Integer.toBinaryString(num));
			num = num & (num - 1);

			c++;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(count3(247));
		// for (int i = 0; i < 16; i++) {
		// System.out.print(count(i)+",");
		//
		// }

	}

}
