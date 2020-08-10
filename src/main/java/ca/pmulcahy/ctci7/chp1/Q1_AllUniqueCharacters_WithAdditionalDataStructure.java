package ca.pmulcahy.ctci7.chp1;

import java.util.HashSet;
import java.util.Set;

/*
 * Implement an algorith to determine if a string has all unique characters
 */

public class Q1_AllUniqueCharacters_WithAdditionalDataStructure{
	public static boolean isAllUniqueCharacters(String str) {
		Set<Character> charsUsed = new HashSet<>();
		for(int i=0; i<str.length(); i++) {
			boolean nonUniqueChar = charsUsed.add(str.charAt(i));
			if(!nonUniqueChar) {
				return false;
			}
		}
		return true;
	}
}