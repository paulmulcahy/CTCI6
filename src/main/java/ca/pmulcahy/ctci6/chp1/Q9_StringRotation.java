package ca.pmulcahy.ctci6.chp1;

/*
 * Assume you have a method isSubString which checks if one word is a substring of another. Given two strins, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubString (eg., waterbottle is a rotation of erbottlewat)
 */
public class Q9_StringRotation{
	public static boolean isRotation(String s1, String s2) {
		boolean s1LengthGreaterOrEqual = s1.length() >= s2.length();
		String s1Doubled = s1 + s1;
		boolean s1DoubledContains = s1Doubled.contains(s2);
		return (s1LengthGreaterOrEqual && s1DoubledContains);
	}
}	