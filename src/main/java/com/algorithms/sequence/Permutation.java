package com.algorithms.sequence;

public class Permutation {

	public void perm(String pre,String str){
		
		if(str.length()==0){
			System.out.println(pre);
			return;
		}
		else{
		
			for (int i = 0; i < str.length(); i++) {
				perm(pre+str.charAt(i), str.substring(0, i)+str.substring(i+1,str.length()));
				
			}
		}		
	}
}
