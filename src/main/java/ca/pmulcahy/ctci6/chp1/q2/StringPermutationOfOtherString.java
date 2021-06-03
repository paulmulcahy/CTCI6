package ca.pmulcahy.ctci6.chp1.q2;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class StringPermutationOfOtherString{
	public static boolean stringPermutationOfOther(final String str1, final String str2) {
		// Not necessary but improves performance
		if(str1.length() != str2.length()) {
			return false;
		} 
		
		final Map<Character, Integer> str1Chars = buildCharMap(str1);
		final Map<Character, Integer> str2Chars = buildCharMap(str2);
		
		return(str1Chars.equals(str2Chars));
	}
	
	private static Map<Character, Integer> buildCharMap(final String str) {		
		final Map<Character, Integer> strChars = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			final Character ch = str.charAt(i);
			final Integer numChars = strChars.get(ch);
			if(numChars==null){
				strChars.put(ch, 1);
			} else {
				strChars.put(ch, numChars + 1);				
			}
		}
		
		return strChars;
	}
}