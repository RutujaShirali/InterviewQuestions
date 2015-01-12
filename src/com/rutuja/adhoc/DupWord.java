package com.rutuja.adhoc;

import java.util.HashSet;

public class DupWord {
	
	public String FindFirstDup(String str){
		HashSet<String> set = new HashSet<>();
		String[] arr = str.split(" ");
		for(int i = 0; i <arr.length; i++){
			if(set.add(arr[i]) == false)
				return arr[i];
		}
		return "No duplicate words";
	}
	
	public static void main(String[] args) {
		DupWord dw = new DupWord();
		System.out.println(dw.FindFirstDup("I am rutuja. I am an angel"));

	}

}
