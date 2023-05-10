package ca.pmulcahy.ctci6.chp01.q02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestStringPermutationOfOtherString {

  @Test
  public void stringsWithDifferentLengths() {

    final String length3 = "123";
    final String length4 = "1234";

    final boolean result =
        StringPermutationOfOtherString.stringPermutationOfOther(length3, length4);
    assertFalse(
        result,
        length3
            + " is a different length from "
            + length4
            + " and therefore cannot be a permutation.");
  }

  @Test
  public void matchingStrings() {

    final String matchingString = "Matching String!";

    final boolean result =
        StringPermutationOfOtherString.stringPermutationOfOther(matchingString, matchingString);
    assertTrue(result, "The string " + matchingString + " should work if provided twice.");
  }

  @Test
  public void stringsWithSameLengthDifferentUniqueCharacters() {

    final String abc = "ABC";
    final String xyz = "XYZ";

    final boolean result = StringPermutationOfOtherString.stringPermutationOfOther(abc, xyz);
    assertFalse(result, "The string " + abc + " is not a permuation of " + xyz);
  }

  @Test
  public void stringsPermutationsOfEachOther() {

    final String abc = "ABC";
    final String cba = "CBA";

    final boolean result = StringPermutationOfOtherString.stringPermutationOfOther(abc, cba);
    assertTrue(result, "The string " + abc + " is a permuation of " + cba);
  }

  @Test
  public void stringsSameLengthSameUniqueCharactersNotPermutation() {

    final String aabc = "AABC";
    final String abcc = "ABCC";

    final boolean result = StringPermutationOfOtherString.stringPermutationOfOther(aabc, abcc);
    assertFalse(
        result,
        "The string "
            + aabc
            + " has the same unique characters but is not a permutation of "
            + abcc);
  }
}
