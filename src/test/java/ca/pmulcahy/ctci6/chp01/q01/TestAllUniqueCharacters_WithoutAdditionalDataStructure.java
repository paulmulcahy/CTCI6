package ca.pmulcahy.ctci6.chp01.q01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestAllUniqueCharacters_WithoutAdditionalDataStructure {

  @Test
  void stringWithUniqueCharacters() {
    final String uniqueCharacterString = "abcdefg";
    final boolean result =
        AllUniqueCharacters_WithAdditionalDataStructure.isAllUniqueCharacters(
            uniqueCharacterString);
    assertTrue(result, uniqueCharacterString + " has unique characters.");
  }

  @Test
  void stringWithNonUniqueCharacters() {
    final String nonUniqueCharacterString = "abcdefa";
    final boolean result =
        AllUniqueCharacters_WithAdditionalDataStructure.isAllUniqueCharacters(
            nonUniqueCharacterString);
    assertFalse(result, nonUniqueCharacterString + " has non unique characters.");
  }

  @Test
  void stringWithNoCharacters() {
    final String emptyString = "";
    final boolean result =
        AllUniqueCharacters_WithAdditionalDataStructure.isAllUniqueCharacters(emptyString);
    assertTrue(result, "The empty String + " + emptyString + " has unique characters.");
  }
}
