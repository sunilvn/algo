package com.algorithms.utils;

public class SearchUtil {

	public static int BinarySearch(int a[], int data) {
		return binarySearch(a, data, 0, a.length - 1);

	}

	public static int BinarySearchusingRecu(int a[], int data) {
		return binarySearchrecu(a, data, 0, a.length - 1);

	}

	/**
	 * 
	 * @param a
	 * @param data
	 * @param low
	 * @param high
	 * @return
	 */
	private static int binarySearchrecu(int[] a, int data, int low, int high) {

		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (data < a[mid])
				return binarySearchrecu(a, data, low, mid - 1);
			else if (data > a[mid])
				return binarySearchrecu(a, data, mid + 1, high);
			else
				return mid;
		}
	}

	/**
	 * 
	 * @param a
	 * @param data
	 * @param low
	 * @param high
	 * @return
	 */

	private static int binarySearch(int[] a, int data, int low, int high) {

		while (low <= high) {
			int mid = (low + high) / 2;
			if (data == a[mid]) {
				return mid;
			} else if (data < a[mid])
				high = mid - 1;
			else if (data > a[mid])
				low = mid + 1;

		}
		return -1;
	}
}
