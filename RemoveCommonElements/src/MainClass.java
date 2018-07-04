import java.util.HashSet;
import java.util.ArrayList;

public class MainClass {

	
	public static void main(String[] args) {
		String[] a = new String[]{"a", "b", "c"};
		String[] b = new String[]{"b", "c", "d"};
		String[] c = new String[]{"c", "d", "e"};
		
		//Return common elements:
		HashSet<String> commonElements = returnCommonElements(a, b, c);
		
		System.out.println("Common Elements:");
		for(String s : commonElements) {
			System.out.println(s);
		}
		
		//Check if palindrome
		String test;
		test = "abcdedcbA";
		System.out.println(test + ":" + isPalindrome(test));
		
		test = "abc";
		System.out.println(test + ":" + isPalindrome(test));		
	}
	
	public static HashSet<String> returnCommonElements(String[] a, String[] b, String[] c) {
		HashSet<String> hashSet = new HashSet<>();
		
		HashSet<String> output = new HashSet<>();
		boolean isAdded;
		
		for(int i=0; i<a.length; i++) {
			hashSet.add(a[i]);
		}
		
		for(int j=0; j<b.length; j++) {
			isAdded = hashSet.add(b[j]);
			if(!isAdded) {
				output.add(b[j]);
			}
		}
		
		for(int k=0; k<c.length; k++) {
			isAdded = hashSet.add(c[k]);
			if(!isAdded) {
				output.add(c[k]);
			}
			
		}
		
		return output;
	}
	
	public static boolean isPalindrome(String input) {
		int midpoint = (int)Math.floor(input.length()/2);
		input = input.toLowerCase();
		for(int i=0;i<midpoint;i++) {
			if(input.charAt(i)!=input.charAt(input.length()-i-1)) {
				return false;
			}
		}
				
		return true;
	}
	


	
}
