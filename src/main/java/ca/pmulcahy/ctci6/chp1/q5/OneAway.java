package ca.pmulcahy.ctci6.chp1.q5;

/*
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or * replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneAway{
	public static boolean isStringOneEditFromAnotherString(String s1, String s2) {
		// Zero Edits
		if(s1.equals(s2)) {
			return true;
		}

		int lengthDiff = s1.length() - s2.length();
		
		if(lengthDiff == 0) {
			return isReplacedCharacter(s1, s2);
		}
		
		if(lengthDiff == 1) {
			return isAdditionalCharacter(s1, s2);
		}
		if(lengthDiff == -1) {
			return isAdditionalCharacter(s2, s1);
		}
		
		return false;		
	}
	
	private static boolean isReplacedCharacter(String s1, String s2) {
		boolean replaceCharFound = false;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(replaceCharFound) {
					return false;
				}
				replaceCharFound = true;
			}
		}
		return true;
	}
	
	private static boolean isAdditionalCharacter(String sLong, String sShort) {
		String sLongFirstDifferentCharRemoved = sLong.substring(0, sLong.length()-1);
		for(int i=0; i<sShort.length(); i++) {
			if(sLong.charAt(i) != sShort.charAt(i)) {
				sLongFirstDifferentCharRemoved = sLong.substring(0, i) + sLong.substring(i+1, sLong.length());
				break;
			}
		}
		
		return sLongFirstDifferentCharRemoved.equals(sShort);
	}
}