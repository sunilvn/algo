package com.algorithms.stringutil;

public class StringUtil {

	public static void printSubStrings(String str){
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}
	
	
}
