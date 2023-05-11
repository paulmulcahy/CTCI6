package ca.pmulcahy.ctci6.chp01.q04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestPalindromePermutation {

  @Test
  void emptyString() {

    final String empty = "";

    final boolean result = PalindromePermutation.isPermutationOfPalindrome(empty);
    assertTrue(result, empty + " is a permutation of a palindrome: /'/'");
  }

  @Test
  void singleWhiteSpaceString() {

    final String whiteSpace = " ";

    final boolean result = PalindromePermutation.isPermutationOfPalindrome(whiteSpace);
    assertTrue(result, whiteSpace + " is a permutation of a palindrome: /'/'.");
  }

  @Test
  void tripleLetterString() {

    final String possiblePermutation = "ababa  ";

    final boolean result = PalindromePermutation.isPermutationOfPalindrome(possiblePermutation);
    assertTrue(result, possiblePermutation + " is a permutation of a palindrome: /'  /'.");
  }

  @Test
  void tact_Coa() {

    final String tact_Coa = "Tact Coa";

    final boolean result = PalindromePermutation.isPermutationOfPalindrome(tact_Coa);
    assertTrue(
        result, tact_Coa + " is a permutation of a palindrome: /'taco cat/', /'atco cta/', etc.");
  }

  @Test
  void notPalindromePermutation() {

    final String notPalindromePermutation = "ab";

    final boolean result =
        PalindromePermutation.isPermutationOfPalindrome(notPalindromePermutation);
    assertFalse(result, notPalindromePermutation + " is not a permutation of a palindrome.");
  }

  @Test
  void notPalindromePermutationTripleLeters() {

    final String notPalindromePermutation = "aaabbb";

    final boolean result =
        PalindromePermutation.isPermutationOfPalindrome(notPalindromePermutation);
    assertFalse(result, notPalindromePermutation + " is not a permutation of a palindrome.");
  }
}
