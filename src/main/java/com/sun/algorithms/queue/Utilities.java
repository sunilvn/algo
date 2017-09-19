package com.sun.algorithms.queue;

public class Utilities <T> {

	public static Queue<?> reverse(Queue<Object> queue) {

		if (queue.isEmpty()) {
			System.out.println("Queue is empty");
			return new Queue<Object>();
		} else {
			return rev(queue);
		}
	}

	private static Queue<?> rev(Queue<Object> queue) {
		if (queue.isEmpty())
			return queue;
		else {
			Object data = queue.dequeue();
			rev(queue);
			queue.enqueue(data);
			return queue;
		}
	}
}
