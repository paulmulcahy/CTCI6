package ca.pmulcahy.ctci6.chp1.q1;

import java.util.HashSet;
import java.util.Set;

/*
 * Implement an algorithm to determine if a string has all unique characters if you cannot use additional data structures
 */

public class AllUniqueCharacters_WithoutAdditionalDataStructure{
	public static boolean isAllUniqueCharacters(String str) {
		for(int i=0; i<str.length(); i++) {
			char iChar = str.charAt(i);
			for(int j=0; j<i; j++) {
				char jChar = str.charAt(j);
				if(iChar == jChar) {
					return false;
				}
			}
		}
		return true;
	}
}