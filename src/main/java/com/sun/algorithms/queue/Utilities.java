package com.sun.algorithms.queue;

public class Utilities {

	public static Queue reverse(Queue queue) {

		if (queue.isEmpty()) {
			System.out.println("Queue is empty");
			return new Queue();
		} else {
			return rev(queue);
		}
	}

	private static Queue rev(Queue queue) {
		if (queue.isEmpty())
			return queue;
		else {
			int data = queue.dequeue();
			rev(queue);
			queue.enqueue(data);
			return queue;
		}
	}
}
