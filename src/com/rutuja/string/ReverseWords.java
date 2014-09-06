package com.rutuja.string;

public class ReverseWords {
	/**
	 * reverses words in the string
	 * 
	 * @param str
	 * @return
	 */
	public String reverseWords(String str) {
		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			if (i == words.length - 1)
				sb.append(words[words.length - i - 1]);
			else
				sb.append(words[words.length - i - 1]).append(" ");
		}
		return sb.toString();

	}

	public String reverseWords2(String str) {
		char[] arr = str.toCharArray();
		int start = 0;
		int end = 0;
		while (start < str.length()) {
			while(start < str.length() && arr[start] == ' ') start++;
			end = str.length() - 1;
			for (int i = start + 1; i < arr.length; i++) {
				if (arr[i] == ' ') {
					end = i - 1;
					break;
				}

			}

			int j = end;
			for (int i = start; i < j; i++, j--) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

			start = end + 2;

		}
		int endIndex = arr.length - 1;
		for (int i = 0; i < endIndex; i++, endIndex--) {
			char temp = arr[i];
			arr[i] = arr[endIndex];
			arr[endIndex] = temp;
		}
		return new String(arr);

	}

	public void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public String reverseWords3(String str) {
		char[] arr = str.toCharArray();
		for (int startIndex = 0; startIndex < str.length();) {
			
			int endIndex = startIndex + 1;
			while (endIndex < str.length() && arr[endIndex] != ' ')
				endIndex++;
			for (int i = startIndex, j = endIndex - 1; i < j; i++, j--)
				swap(arr, i, j);
			startIndex = endIndex + 1;
		}
		for (int i = 0, j = str.length() - 1; i < j; i++, j--)
			swap(arr, i, j);
		return new String(arr);
	}

	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		System.out.println(rw.reverseWords2(" I  am    Rutuja"));
	}

}
