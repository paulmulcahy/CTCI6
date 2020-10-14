package ca.pmulcahy.ctci6.chp1.q5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestOneAway{
	
	@Test
	public void zeroDifferences() {
		
		final String strings = "abc";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(strings, strings);
		assertTrue(result, strings + " is zero edits from " + strings + " and should return true.");
	}
	
	@Test
	public void firstStringTwoCharactersLonger() {
		
		final String str1 = "abc";
		final String str2 = "abcde";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertFalse(result, str1 + " is 2 digits longer than " + str2 + " and should return false.");
	}
	
	@Test
	public void secondStringTwoCharactersLonger() {
		
		final String str1 = "abc";
		final String str2 = "abcde";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str2, str1);
		assertFalse(result, str2 + " is 2 digits longer than " + str1 + " and should return false.");
	}

	@Test
	public void replacedFirstCharacter() {
	
		final String str1 = "abcde";
		final String str2 = "Abcde";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}

	@Test
	public void replacedMiddleCharacter() {
	
		final String str1 = "abcde";
		final String str2 = "abCde";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}
	
	@Test
	public void replacedLastCharacter() {
	
		final String str1 = "abcde";
		final String str2 = "abcdE";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}
	
	@Test
	public void additionalFirstCharacter() {
	
		final String str1 = "abcd";
		final String str2 = "1abcd";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}

	@Test
	public void additionalMiddleCharacter() {
	
		final String str1 = "abcd";
		final String str2 = "ab1cd";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}
	
	@Test
	public void additionalLastCharacter() {
	
		final String str1 = "abcd";
		final String str2 = "abcd1";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}
	
	@Test
	public void firstCharacterRemoved() {
	
		final String str1 = "abcde";
		final String str2 = "bcde";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}

	@Test
	public void middleCharacterRemoved() {
	
		final String str1 = "abcde";
		final String str2 = "abde";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}

	@Test
	public void lastCharacterRemoved() {
	
		final String str1 = "abcde";
		final String str2 = "abcd";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}
	
	@Test
	public void additionalFirstCharacterAndLastCharacterRemoved() {
	
		final String str1 = "bcde";
		final String str2 = "abcd";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertFalse(result, str1 + " is 2 edits away from " + str2 + " and should return false.");
	}
	
	@Test
	public void additionalLastCharacterAndFirstCharacterRemoved() {
	
		final String str1 = "abcd";
		final String str2 = "bcde";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertFalse(result, str1 + " is 2 edits away from " + str2 + " and should return false.");
	}

	@Test
	public void emptyStringAndCharacter() {
	
		final String str1 = "";
		final String str2 = "1";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str1, str2);
		assertTrue(result, str1 + " is 1 edit away from " + str2 + " and should return true.");
	}

	@Test
	public void characterAndEmptyString() {
	
		final String str1 = "";
		final String str2 = "1";
				
		boolean result = OneAway.isStringOneEditFromAnotherString(str2, str1);
		assertTrue(result, str2 + " is 1 edit away from " + str1 + " and should return true.");
	}
	
}