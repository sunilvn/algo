package com.algorithms.utils;

import java.util.Arrays;

public class SortUtil{

	public static void BubbleSort(int a[]) {

		for (int i = 0; i < a.length - 1; i++) {

			for (int j = 0; j < a.length - 1 - i; j++) {

				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void SelectionSort(int a[]) {

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {

				if (a[i] > a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
			System.out.println(Arrays.toString(a));
		}
	}

	public static void QuickSort(int a[]) {

		quicksort(a, 0, a.length - 1);

	}

	public static void MergeSort(int a[]){
		int temp[]=new int[a.length];
		mergeSort(a,0,a.length-1,temp);
	}
	
	private static void mergeSort(int[] a, int low, int high, int[] temp) {
	
		if(low>=high)return;
		
		else{
			
			int mid=(low+high)/2;
			
			mergeSort(a,low,mid,temp);
			mergeSort(a,mid+1,high,temp);
			merge(a,low,mid,high,temp);
			
			
		}
	}

	private static void merge(int[] a, int low, int mid, int high, int[] temp) {
		int i=low,k=low;
		int j=mid+1;
		
		while(i<=mid && j<=high){
			
			if(a[i]<=a[j])
				temp[k++]=a[i++];
			else
				temp[k++]=a[j++];
		}
		 while(i<=mid){
			 temp[k++]=a[i++];
		 }
		 while(j<=high){
			temp[k++] = a[j++];
		}
		 for (int j2 = low; j2 <= high; j2++) {
			a[j2]=temp[j2];
		}

	}

	private static void quicksort(int[] a, int low, int high) {

		if (low > high) {
			return;
		} else {
			int pindex = partition(a, low, high);
			quicksort(a, low, pindex - 1);
			quicksort(a, pindex + 1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {

		int pivot = a[low], left = low, right = high;

		while (left < right) {

			while (a[left] <= pivot) {
				left++;
				if(left>high)
					break;
				
			}
			while (a[right] > pivot) {
				right--;
				if(right<high)break;
			}
			if (left < right)
				swap(a, left, right);

		}
		swap(a, low, right);
		return right;
	}

	private static void swap(int a[], int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
