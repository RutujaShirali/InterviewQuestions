package com.rutuja.adhoc;
/***
 * 
 * 
 * @author Rutuja
 *  This program finds if the given number is the sum of two cubes
 */

public class FindifSumofTwoCubes {
	private int []arr;
	public FindifSumofTwoCubes() {
		preprocess();
	}
	private void preprocess(){
		arr = new int[1291];
		for(int i=1; i*i<Integer.MAX_VALUE/i; i++){
			arr[i] = i*i*i;
		}
	}

	public boolean findout(int num){
		int start,end;
		for(int i = 0, j=arr.length-1; i<=j;){
			start = arr[i];
			end = arr[j];
			if(start+end > num) j--;
			else if(start+end==num) return true;
			else i++;
			
		}
		return false;
		
	}
	public static void main(String[] args) {
		FindifSumofTwoCubes f = new FindifSumofTwoCubes();
		System.out.println(f.findout(17));
		System.out.println(f.findout(9));
	}

}
