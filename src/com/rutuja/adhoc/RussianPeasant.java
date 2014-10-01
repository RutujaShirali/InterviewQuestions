package com.rutuja.adhoc;

public class RussianPeasant {

	public int div2(int a) {
		return a>>1;
	}

	public int mul2(int a) {
		return a<<1;
	}

	public int add2(int A, int B) {
		int cin =0 , cout =0;
		int res =0;
		for(int i =0; i< 32; i++){
			int a = A&(1<<i), b = B&(1<<i);
			int s = a^b^cin;
			res = s|res;
			cout = (a&b)|(a&cin)|(b&cin);
			cin = cout<<1;
		}
		return res;
		
	}

	public boolean isOdd(int a) {
		return (a&1) == 1;
	}

	public int mult(int a, int b) {
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int sum = 0;
		while(a!=0){
			if(isOdd(a)) sum = add2(sum, b);
			a = div2(a);
			b = mul2(b);
		}
        return sum;
	}

	public static void main(String[] args) {
		System.out.println(new RussianPeasant().mult(238, 13));

	}

}
