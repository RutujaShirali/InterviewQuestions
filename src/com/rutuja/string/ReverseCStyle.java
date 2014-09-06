package com.rutuja.string;

import java.util.Arrays;

public class ReverseCStyle {
	/*reverses c style string
	 * 
	 * 
	 */
	public void reverse(char[] arr) {
		int len;
		for (len = 0; arr[len] != 0; len++)
			;
		len -= 1;
		for (int i = 0; i < len; i++) {
			char temp = arr[i];
			arr[i] = arr[len];
			arr[len] = temp;
			len--;

		}
	}

	public static void main(String[] args) {
		ReverseCStyle rs = new ReverseCStyle();
		char[] arr = new char[] { 'a', 'b', 'c', 'd', 0, 0 };
		rs.reverse(arr);
		System.out.println(Arrays.toString(arr));

	}

}
