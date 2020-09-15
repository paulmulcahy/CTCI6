package ca.pmulcahy.ctci6.chp1;

import java.util.HashSet;
import java.util.Set;

/*
 * Implement an algorithm to determine if a string has all unique characters
 */

public class Q1_AllUniqueCharacters_WithAdditionalDataStructure{
	public static boolean isAllUniqueCharacters(String str) {
		Set<Character> charsUsed = new HashSet<>();
		for(int i=0; i<str.length(); i++) {
			boolean uniqueChar = charsUsed.add(str.charAt(i));
			if(!uniqueChar) {
				return false;
			}
		}
		return true;
	}
}