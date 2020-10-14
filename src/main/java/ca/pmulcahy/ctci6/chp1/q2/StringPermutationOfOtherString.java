package ca.pmulcahy.ctci6.chp1.q2;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class StringPermutationOfOtherString{
	public static boolean stringPermutationOfOther(String str1, String str2) {
		// Not necessary but improves performance
		if(str1.length() != str2.length()) {
			return false;
		} 
		
		Map<Character, Integer> str1Chars = buildCharMap(str1);
		Map<Character, Integer> str2Chars = buildCharMap(str2);
		
		return(str1Chars.equals(str2Chars));
	}
	
	private static Map<Character, Integer> buildCharMap(String str) {		
		Map<Character, Integer> strChars = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			Character ch = str.charAt(i);
			Integer numChars = strChars.get(ch);
			if(numChars==null){
				strChars.put(ch, 1);
			} else {
				strChars.put(ch, numChars + 1);				
			}
		}
		
		return strChars;
	}
}