package ca.pmulcahy.ctci6.chp01.q01;

/*
 * Implement an algorithm to determine if a string has all unique characters if you cannot use additional data structures
 */

public class AllUniqueCharacters_WithoutAdditionalDataStructure {
  public static boolean isAllUniqueCharacters(final String str) {
    for (int i = 0; i < str.length(); i++) {
      final char iChar = str.charAt(i);
      for (int j = 0; j < i; j++) {
        final char jChar = str.charAt(j);
        if (iChar == jChar) {
          return false;
        }
      }
    }
    return true;
  }
}
