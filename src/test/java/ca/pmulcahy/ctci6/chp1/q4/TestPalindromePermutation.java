package ca.pmulcahy.ctci6.chp1.q4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestPalindromePermutation{
	
	@Test
	public void emptyString() {
		
		final String empty = "";
				
		boolean result = PalindromePermutation.isPermutationOfPalindrome(empty);
		assertTrue(result, empty + " is a permutation of a palindrome: /'/'");
	}
	
	@Test
	public void singleWhiteSpaceString() {
		
		final String whiteSpace = " ";
				
		boolean result = PalindromePermutation.isPermutationOfPalindrome(whiteSpace);
		assertTrue(result, whiteSpace + " is a permutation of a palindrome: /'/'.");
	}

	@Test
	public void tripleLetterString() {
		
		final String possiblePermutation = "ababa  ";
				
		boolean result = PalindromePermutation.isPermutationOfPalindrome(possiblePermutation);
		assertTrue(result, possiblePermutation + " is a permutation of a palindrome: /'  /'.");
	}
	
	@Test
	public void tact_Coa() {
		
		final String tact_Coa = "Tact Coa";
				
		boolean result = PalindromePermutation.isPermutationOfPalindrome(tact_Coa);
		assertTrue(result, tact_Coa + " is a permutation of a palindrome: /'taco cat/', /'atco cta/', etc.");
	}	
	
	@Test
	public void notPalindromePermutation() {
		
		final String notPalindromePermutation = "ab";
				
		boolean result = PalindromePermutation.isPermutationOfPalindrome(notPalindromePermutation);
		assertFalse(result, notPalindromePermutation + " is not a permutation of a palindrome.");
	}

	@Test
	public void notPalindromePermutationTripleLeters() {
		
		final String notPalindromePermutation = "aaabbb";
				
		boolean result = PalindromePermutation.isPermutationOfPalindrome(notPalindromePermutation);
		assertFalse(result, notPalindromePermutation + " is not a permutation of a palindrome.");
	}
	
}