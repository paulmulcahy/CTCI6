package ca.pmulcahy.ctci6.chp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestQ2_StringPermutationOfOtherString{
	
	@Test
	public void stringsWithDifferentLengths() {
		
		final String length3 = "123";
		final String length4 = "1234";
				
		boolean result = Q2_StringPermutationOfOtherString.stringPermutationOfOther(length3, length4);
		assertFalse(result, length3 + " is a different length from " + length4 + " and therefore cannot be a permutation.");
	}	
	
	@Test
	public void matchingStrings() {
	
		final String matchingString = "Matching String!";
		
		boolean result = Q2_StringPermutationOfOtherString.stringPermutationOfOther(matchingString, matchingString);
		assertTrue(result, "The string " + matchingString + " should work if provided twice.");
	}
	
	@Test
	public void stringsWithSameLengthDifferentUniqueCharacters() {
		
		final String abc = "ABC";
		final String xyz = "XYZ";
		
		boolean result = Q2_StringPermutationOfOtherString.stringPermutationOfOther(abc, xyz);
		assertFalse(result, "The string " + abc + " is not a permuation of " + xyz);
	}

	@Test
	public void stringsPermutationsOfEachOther() {
		
		final String abc = "ABC";
		final String cba = "CBA";
		
		boolean result = Q2_StringPermutationOfOtherString.stringPermutationOfOther(abc, cba);
		assertTrue(result, "The string " + abc + " is a permuation of " + cba);
	}

	@Test
	public void stringsSameLengthSameUniqueCharactersNotPermutation() {
		
		final String aabc = "AABC";
		final String abcc = "ABCC";
		
		boolean result = Q2_StringPermutationOfOtherString.stringPermutationOfOther(aabc, abcc);
		assertFalse(result, "The string " + aabc + " has the same unique characters but is not a permutation of " + abcc);
	}
	
}