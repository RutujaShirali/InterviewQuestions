package com.rutuja.dp;

import java.util.Arrays;

public class MakeChange {
	int[] denominations = { 1, 5, 10, 25, 50 };

	public int change(int money) {
		int[] minCoins = new int[money + 1];
		int[] parent = new int[minCoins.length];
		Arrays.fill(parent, -1);
		Arrays.fill(minCoins, Integer.MAX_VALUE / 2);
		minCoins[0] = 0;
		for (int i = 1; i < minCoins.length; i++) {
			for (int coin : denominations) {
				if (i - coin >= 0) {
					// minCoins[i] = Math.min(minCoins[i - coin] + 1,
					// minCoins[i]);
					if (minCoins[i - coin] + 1 < minCoins[i]) {
						minCoins[i] = minCoins[i - coin] + 1;
						parent[i] = coin;
					}
				}
			}
		}
		int[] result = new int[minCoins[minCoins.length - 1]];
		for (int i = 0; i < result.length; i++) {
			result[i] = parent[money];
			money = money - parent[money];
		}
		System.out.println(Arrays.toString(result));
		return minCoins[minCoins.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(new MakeChange().change(77));
	}
}
