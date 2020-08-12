package ca.pmulcahy.ctci7.chp1;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or * phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome * does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
public class Q4_PalindromePermutation{
	public static boolean isPermutationOfPalindrome(String str) {
		String strLower = str.toLowerCase();
		String whiteSpaceRemoved = strLower.replace(" ", "");
		
		Map<Character, Integer> characterCount = new HashMap<>();
		for(int i=0; i<whiteSpaceRemoved.length(); i++) {
			Character c = whiteSpaceRemoved.charAt(i);
			Integer count = characterCount.get(c);
			if (count==null){
				characterCount.put(c, 1);
			} else {
				characterCount.put(c, count + 1);
			}
		}
		
		boolean oddCharFound = false;		
		for(Integer i : characterCount.values()) {
			if(i%2 == 1) {
				if(oddCharFound) {
					return false;
				}
				oddCharFound = true;
			}
		}
		return true;
	}
}