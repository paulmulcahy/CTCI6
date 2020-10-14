package ca.pmulcahy.ctci6.chp1.q9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestStringRotation{
	
	@Test
	public void duplicate() {
		
		final String s1 = "abcde";
		final String s2 = s1;
				
		final boolean actual = StringRotation.isRotation(s1, s2);
		assertTrue(actual,  "When s1: " + s1 + " matches s2: + " + s2 + " the value should return true.");
	}
	
	@Test
	public void substring() {
		
		final String s1 = "abcde";
		final String s2 = "abc";
				
		final boolean actual = StringRotation.isRotation(s1, s2);
		assertTrue(actual,  "When s1: " + s1 + " is a substring s2: + " + s2 + " the value should return true.");
	}

	@Test
	public void completelyDifferent() {
		
		final String s1 = "abc";
		final String s2 = "xyz";
				
		final boolean actual = StringRotation.isRotation(s1, s2);
		assertFalse(actual,  "When s1: " + s1 + " is not a substring s2: + " + s2 + " the value should return false.");
	}
	
	@Test
	public void substringDifferentCase() {
		
		final String s1 = "abc";
		final String s2 = "AB";
				
		final boolean actual = StringRotation.isRotation(s1, s2);
		assertFalse(actual,  "When s1: " + s1 + " is not a substring s2: + " + s2 + " the value should return false.");
	}
	
	@Test
	public void superstring() {
		
		final String s1 = "abcde";
		final String s2 = "abcdea";
				
		final boolean actual = StringRotation.isRotation(s1, s2);
		assertFalse(actual,  "When s1: " + s1 + " is not a substring s2: + " + s2 + " the value should return false.");
	}
}