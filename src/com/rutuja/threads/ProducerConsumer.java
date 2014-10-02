package com.rutuja.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	class Producer implements Runnable {
		private BlockingQueue<Integer> q;
		private int id;

		public Producer(BlockingQueue<Integer> q, int id) {
			super();
			this.q = q;
			this.id = id;
		}

		@Override
		public void run() {
			Random rand = new Random();

			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000 * rand.nextInt(3));
					q.put(id * 10 + i);
					System.out.println("Producer " + id + " Produced "
							+ (id * 10 + i));
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}

			}
			System.out.println("Producer " + id + " has terminated");

		}

	}

	class Consumer implements Runnable {
		private BlockingQueue<Integer> q;
		private int id;

		public Consumer(BlockingQueue<Integer> q, int id) {
			super();
			this.q = q;
			this.id = id;
		}

		@Override
		public void run() {
			try {
				while (true)
					System.out.println("Consumer " + id + " Consumed "
							+ q.take());
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
			System.out.println("Consumer " + id + " has terminated");
		}
	}

	public static void main(String[] args) {
		new ProducerConsumer().go();

	}

	private void go() {
		BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
		List<Runnable> r = new ArrayList<Runnable>();
		List<Producer> pd = new ArrayList<Producer>();
		List<Consumer> c = new ArrayList<>();
		List<Thread> producers = new ArrayList<Thread>();
		ThreadGroup tg = new ThreadGroup("");
		List<Thread> consumers = new ArrayList<Thread>();
		for (int i = 0; i < 3; i++) {
			pd.add(new Producer(q, i));
			c.add(new Consumer(q, i));
			r.add(c.get(c.size() - 1));
			r.add(pd.get(pd.size() - 1));
		}
		for (Runnable run : pd) {
			Thread t = new Thread(tg, run);
			producers.add(t);
			t.start();
		}
		for (Runnable run : c) {
			Thread t = new Thread(run);
			consumers.add(t);
			t.start();
		}
		for (Thread t : producers) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (!q.isEmpty()) {

		}
		for (Thread t : consumers) {
			t.interrupt();
		}
	}

}
