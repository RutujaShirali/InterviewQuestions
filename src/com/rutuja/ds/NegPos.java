package com.rutuja.ds;

import java.util.Arrays;

public class NegPos {

	public void negPosRel(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			negPosRel(arr, l, mid);
			negPosRel(arr, mid + 1, r);
			// now you have array of form arr[l..mid] nnn ppp arr[mid+1...r] nnn
			// ppp
			if (arr[mid] >= 0 && arr[mid + 1] < 0) {
				int x = l, y =r;
				for (int i = l; i <= mid; i++) {
					if (arr[i] >= 0) {
						x = i;
						break;
					}
				}
				for (int i = r; i > mid; i--) {
					if (arr[i] < 0) {
						y = i;
						break;
					}
				}
				leftRotate(arr,x,y,mid-x+1);

			}

		}
	}
	
	public void leftRotate(int[] arr, int start, int end, int val){
		reverse(arr, start, start+val-1);
		reverse(arr,start+val,end);
		reverse(arr,start,end);
	}
	
	public void reverse(int[] arr, int start, int end){
		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,-2,3,-4,-5,6,-7,8,-9};
		NegPos np = new NegPos();
		np.negPosRel(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

}
