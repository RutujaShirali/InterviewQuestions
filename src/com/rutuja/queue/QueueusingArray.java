package com.rutuja.queue;

public class QueueusingArray {
	private int capacity;
	private int[] queue;
	private int front, rear, size;

	public QueueusingArray(int capacity) {
		super();
		this.capacity = capacity;
		this.queue = new int[capacity];
		this.front = 0;
		this.rear = capacity - 1;
		this.size = 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(int element) {
		if (isFull())
			return;
		rear = (rear + 1) % capacity;
		queue[rear] = element;
		size++;
		System.out.println("Enqueued to queue " + element);
	}

	public int dequeue() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int item = queue[front];
		front = (front + 1) % capacity;
		size--;
		return item;
	}

	public static void main(String[] args) {
		QueueusingArray qa = new QueueusingArray(10);
		qa.enqueue(10);
		qa.enqueue(20);
		qa.enqueue(30);
		qa.enqueue(40);
		qa.enqueue(50);
		qa.enqueue(60);
		System.out.println("Dequeued " + qa.dequeue());
	}
}
