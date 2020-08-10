package ca.pmulcahy.ctci7.chp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestQ1_AllUniqueCharacters_WithAdditionalDataStructure {

	private static final String UNIQUE_CHAR_STRING = "abcdefg";
	private static final String NON_UNIQUE_CHAR_STRING = "abcdefa";
	private static final String EMPTY_STRING = "";

	@Test
	public void stringWithUniqueCharacters() {
		boolean result = Q1_AllUniqueCharacters_WithAdditionalDataStructure.isAllUniqueCharacters(UNIQUE_CHAR_STRING);
		assertTrue(result, UNIQUE_CHAR_STRING + " has unique characters.");
	}	

	@Test
	public void stringWithNonUniqueCharacters() {
		boolean result = Q1_AllUniqueCharacters_WithAdditionalDataStructure.isAllUniqueCharacters(NON_UNIQUE_CHAR_STRING);
		assertFalse(result, NON_UNIQUE_CHAR_STRING + " has non unique characters.");
	}	

	@Test
	public void stringWithNoCharacters() {
		boolean result = Q1_AllUniqueCharacters_WithAdditionalDataStructure.isAllUniqueCharacters(EMPTY_STRING);
		assertTrue(result, "The empty String + " + EMPTY_STRING + " has unique characters.");
	}	
}