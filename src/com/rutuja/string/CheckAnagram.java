package com.rutuja.string;

import java.util.Arrays;


public class CheckAnagram {
	public boolean check(String str1, String str2){		
        char[] chars1 = str1.toCharArray();
        Arrays.sort(chars1);
        String sorted1 = new String(chars1);
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars2);
        String sorted2 = new String(chars2);
        if(sorted1.equals(sorted2)) return true;
        else return false;
	}
	public static void main(String[] args) {
		CheckAnagram ca = new CheckAnagram();
		System.out.println(ca.check("dad", "add"));
	}

}
