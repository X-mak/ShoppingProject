package com.util.util;

public class Search {

	
	public String getKeyWords(String words) {
		StringBuilder w = new StringBuilder();
		w.append("%");
		for(int i = 0 ; i < words.length() ; i ++) {
			w.append(words.charAt(i));			
		}
		w.append("%");
		return w.toString();
	}
	
}
