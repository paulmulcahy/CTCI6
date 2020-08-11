package ca.pmulcahy.ctci7.chp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQ3_ReplaceSpacesWithPercentTwenty{
	
	@Test
	public void NoSpaces() {
		
		final String abc = "ABC";
				
		final String actual = Q3_ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abc);
		assertEquals(abc, actual,  "A string without spaces :" + abc + " should return a matching value.");
	}	
	
	@Test
	public void OnlySpace() {
		
		final String space = " ";
		final String expected = "%20";
				
		final String actual = Q3_ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(space);
		assertEquals(expected, actual,  "A string with a space :" + space + " should return " + expected + ".");
	}
	
	@Test
	public void OneSpaceInMiddle() {
		
		final String abcd = "AB CD";
		final String expected = "AB%20CD";
				
		final String actual = Q3_ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
		assertEquals(expected, actual,  "A string with a space :" + abcd + " should return " + expected + ".");
	}

	@Test
	public void OneSpaceAtBeginning() {
		
		final String abcd = " ABCD";
		final String expected = "%20ABCD";
				
		final String actual = Q3_ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
		assertEquals(expected, actual,  "A string with a space :" + abcd + " should return " + expected + ".");
	}		

	@Test
	public void OneSpaceAtEnd() {
		
		final String abcd = "ABCD ";
		final String expected = "ABCD%20";
				
		final String actual = Q3_ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
		assertEquals(expected, actual,  "A string with a space :" + abcd + " should return " + expected + ".");
	}	
	
	@Test
	public void ManySpaces() {
		
		final String abcd = " A B  C D ";
		final String expected = "%20A%20B%20%20C%20D%20";
				
		final String actual = Q3_ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
		assertEquals(expected, actual,  "A string with a space :" + abcd + " should return " + expected + ".");
	}
}