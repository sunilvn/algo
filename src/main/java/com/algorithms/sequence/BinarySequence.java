package com.algorithms.sequence;

public class BinarySequence {

	public void printBinarySequence(int a[],int n){
		if(n<=0){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
		else{
			
			a[n-1]=0;
			printBinarySequence(a, n-1);
			a[n-1]=1;
			printBinarySequence(a, n-1);
			
		}
	}
	
	public void printIntSequence(int a[],int n){
		if(n<=0){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
		else{
			for (int i = 0; i <3; i++) {
				a[n-1]=i;
				printBinarySequence(a, n-1);
			}		
		}
	} 
}
