package com.rutuja.dp;

public class AddKElements {
	
	public void addK(int[] arr,int k){
		int sum =0;
		for(int i =0; i<k; i++){
			sum +=arr[i];
		}
		System.out.println(sum);
		for(int j =0; j<arr.length-k;j++){
			sum = sum-arr[j]+arr[j+k];
			System.out.println(sum);
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,-3,2,4,7,-9};
		AddKElements a = new AddKElements();
		a.addK(arr, 3);

	}

}
