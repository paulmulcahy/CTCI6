package ca.pmulcahy.ctci6.chp01.q06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringCompression{
	
	@Test
	public void allUniqueCharacters() {
		
		final String abc = "ABC";
				
		final String actual = StringCompression.compress(abc);
		assertEquals(abc, actual,  "A string without only unqiue characters :" + abc + " should return a matching value.");
	}	
	
	@Test
	public void allMatchingCharacters() {
		
		final String abc = "AAA";
		final String expected = "A3";
				
		final String actual = StringCompression.compress(abc);
		assertEquals(expected, actual,  "A string without all matching characters :" + abc + " should return a compressed value:" + expected);
	}
	
}