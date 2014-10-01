package com.rutuja.adhoc;

public class BSet {

	private int[] arr;
	private int size;

	public BSet(int size) {
		super();
		this.size = size;
		arr = new int[(size + 1) / 32];
	}

	public void set(int i) {
		int div = i / 32, mod = i % 32;
		arr[div] |= (1 << mod);
	}

	public void clear(int index) {
		int div = index / 32, mod = index % 32;
		arr[div] &= ~(1 << mod);

	}

	public int test(int index) {
		int div = index / 32, mod = index % 32;
		return (arr[div] >> mod) & 1;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (arr[i / 32] == 0){
				i += 31;
				continue;
			}
			if (test(i) == 1){
				if (sb.length() > 0)
					sb.append(",");
				sb.append(i);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		BSet bs = new BSet(64);
		bs.set(33);
		bs.set(47);
		System.out.println(bs);
		bs.clear(33);
		System.out.println(bs);
		System.out.println(bs.test(0));
	}

}
