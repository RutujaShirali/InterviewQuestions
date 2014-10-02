package com.rutuja.threads;

public class Threads {
	
	class RunnableDemo implements Runnable {
		private Thread t;
		private String threadName;
		
		
		

		public RunnableDemo(String threadName) {
			this.threadName = threadName;
			System.out.println("Creating " + threadName);
		}
		
		@Override
		public void run() {
			System.out.println("Running " + threadName);
			for(int i =4;i>0;i--){
				System.out.println("Thread: " + threadName + "," + i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					System.out.println("Thread " + threadName
							+ " was interrupted");
				}
			}
			System.out.println("Thread " + threadName + " exiting");
		}
		
		public void start(){
			System.out.println("Starting " + threadName);
			if(t==null){
				t = new Thread(this, threadName);
				t.start();
			}
		}
	}

	public static void main(String[] args) {
		Threads.RunnableDemo r1 = new Threads().new RunnableDemo("Thread1");
		r1.start();
		Threads.RunnableDemo r2 = new Threads().new RunnableDemo("Thread2");
		r2.start();
	}

}
