package com.rutuja.bitmanipulation;

public class SetAllbetij {
	Bits b = new Bits();
	
	public int setij(int m, int n, int i, int j){
		for(int k=i; k<=j; k++){
			
			if(b.test(m, k)!= b.test(n, k-i)){
				m = b.toggle(m, k);
			}
		}
		return m;
	}
	public int setij2(int m, int n, int i, int j){
		int mask = (1<<(j-i+1+1))-1; // 0000....111111
		mask = ~(mask<<i);// 1111...00000...11111
		m = m & mask;
		m= m |(n<<i);
		return m;
		
	}

	public static void main(String[] args) {
		SetAllbetij sb = new SetAllbetij();
		int m = 1024, n = 21;
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(n));
		
		System.out.println(Integer.toBinaryString(sb.setij(m, n, 2, 6)));
		System.out.println(Integer.toBinaryString(sb.setij2(m, n, 2, 6)));

	}
}
