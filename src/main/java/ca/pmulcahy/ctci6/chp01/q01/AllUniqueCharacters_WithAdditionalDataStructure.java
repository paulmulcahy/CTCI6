package ca.pmulcahy.ctci6.chp01.q01;

import java.util.HashSet;
import java.util.Set;

/*
 * Implement an algorithm to determine if a string has all unique characters
 */

public class AllUniqueCharacters_WithAdditionalDataStructure{
	public static boolean isAllUniqueCharacters(final String str) {
		final Set<Character> charsUsed = new HashSet<>();
		for(int i=0; i<str.length(); i++) {
			final boolean uniqueChar = charsUsed.add(str.charAt(i));
			if(!uniqueChar) {
				return false;
			}
		}
		return true;
	}
}