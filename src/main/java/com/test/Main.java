package com.test;


public class Main {
	public static void main(String[] arg){
		String data = "";
		StringBuffer buf = new StringBuffer();
		for(char ch : data.toCharArray()){
			buf.append((char)(ch-1));
		}
		System.out.println(buf.toString());
	}
}
