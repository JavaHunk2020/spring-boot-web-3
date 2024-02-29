package com.it;

import java.util.PriorityQueue;

public class StringDemo1 {
	
	public static void main(String[] args) {
		String str1="Hero";
		String str2="Hero";
		//Case -1
		if(str1==str2) {
			System.out.println("AHahaha- true ");
		}
		
		
		//Case -2
		String str3="He"+"ro";
		System.out.println("Result is = "+(str1==str3));
		
		
		//Case -3
		String t="He";
		String str4=t+"ro";
		System.out.println("Result is = "+(str1==str4));
		
		
		//Case -4
		final String q="He";
		String str5=q+"ro";
		System.out.println("Result is = "+(str1==str5));
				
		//Case -4
		 String str6=new String("Hero");
		 System.out.println("Result is = "+(str1==str6));
		 
		 
			//Case -5
		 String str7 = str6.intern();
		 System.out.println("Result is = "+(str1==str7));
		 
		//Case -6
		 String p1=new String("Hero");
		 String p2=new String("Hero");
		 System.out.println("Result is = "+(p1==p2));
		
	}

}
