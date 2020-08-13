package ca.pmulcahy.ctci7.chp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQ6_StringCompression{
	
	@Test
	public void allUniqueCharacters() {
		
		final String abc = "ABC";
				
		final String actual = Q6_StringCompression.compress(abc);
		assertEquals(abc, actual,  "A string without only unqiue characters :" + abc + " should return a matching value.");
	}	
	
	@Test
	public void allMatchingCharacters() {
		
		final String abc = "AAA";
		final String expected = "A3";
				
		final String actual = Q6_StringCompression.compress(abc);
		assertEquals(expected, actual,  "A string without all matching characters :" + abc + " should return a compressed value:" + expected);
	}
	
}