package com.rutuja.adhoc;

class MultipleInheritance {

	interface Printable {
		void print();
	}

	interface Showable {
		void print();
	}

	static class testinterface1 implements Printable, Showable {

		public void print() {
			System.out.println("Hello");
		}
	}

	

	public static void main(String args[]) {
		
		testinterface1 ti = new testinterface1();
		Printable p = ti;
		Showable s = ti;
	    s.print();
	    p.print();
		
		
	}
}
