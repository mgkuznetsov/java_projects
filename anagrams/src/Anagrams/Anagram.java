package Anagrams;

import Anagrams.SortImplementations;

public class Anagram {
	
	public boolean isAnagram(String str1, String str2) {
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		//Convert both Strings into arrays int so they can be processed by Quicksort
		int[] strAsInt1 = new int[str1.length()];
		int[] strAsInt2 = new int[str2.length()];
		
		
		//Convert char array into 
		for(int i=0; i<str1.length(); i++) {
			strAsInt1[i]=(int)str1.charAt(i);
			strAsInt2[i]=(int)str2.charAt(i);
		}
		
		//Sort both Strings
		int[] strAsIntSorted1 = SortImplementations.quickSort(strAsInt1);
		int[] strAsIntSorted2 = SortImplementations.quickSort(strAsInt2);
		
		//Check if sorted versions of the strings are the same
		for(int j=0; j<str1.length(); j++) {
			if(strAsIntSorted1[j] != strAsIntSorted2[j]) {
				return false;
			}
		}
		
		return true; //Strings are the same
		
		
	}
	
	public static void main(String[] args) {
		Anagram myAnagram = new Anagram();
		System.out.println(myAnagram.isAnagram("listen", "silent"));
		System.out.println(myAnagram.isAnagram("listen", "abcdef"));
	}
}
