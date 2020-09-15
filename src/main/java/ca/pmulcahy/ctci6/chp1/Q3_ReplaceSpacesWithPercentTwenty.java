package ca.pmulcahy.ctci6.chp1;

/*
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has
 * sufficient space at the end to hold the additional characters, and that you are given the "true" length
 * of the string. (Note: If implementing in Java, please use a character array so that you can perform this
 * operation in place.)
 */
public class Q3_ReplaceSpacesWithPercentTwenty{
	public final static Character EMPTY_CHAR = ' '; 
	
	public static String replaceSpacesWithPercentTwenty(String str) {
		Character[] characterArrayWithSpaceAllocatedForAdditionalCharacters = toCharacterArrayWithSpaceAllocatedForAdditionalCharacters(str);
		Character[] characterArrayWithSpacesReplacedByPercentTwenty = replaceSpacesWithPercentTwentyInPlace(characterArrayWithSpaceAllocatedForAdditionalCharacters);
		char[] charArrayWithSpacesReplacedByPercentTwenty = characterArrayToCharArray(characterArrayWithSpacesReplacedByPercentTwenty);
		return new String (charArrayWithSpacesReplacedByPercentTwenty);
	}

	private static int additionalCharactersNeeded(String str) {
		int spacesInString = 0;
		for(int i=0; i<str.length(); i++) {
			if(EMPTY_CHAR.equals(str.charAt(i))) {
				spacesInString++;
			}
		}
		return spacesInString*2;
	}
	
	private static Character[] toCharacterArrayWithSpaceAllocatedForAdditionalCharacters(String str) {		
		Character[] chArr = new Character[str.length() + additionalCharactersNeeded(str)];
		
		for(int i=0; i<str.length(); i++) {
			chArr[i] = str.charAt(i);
		}
		
		return chArr;
	}
	
	private static Character[] replaceSpacesWithPercentTwentyInPlace(Character[] chArr) {
		int i = chArr.length-1;
		int j = chArr.length-1;;

		while(i>=0) {
			if(null!=chArr[i]) {
				if(EMPTY_CHAR.equals(chArr[i])) {
					chArr[j--] = '0';					
					chArr[j--] = '2';
					chArr[j--] = '%';
				} else {
					chArr[j--] = chArr[i];
				}				
			}
			i--;
		}

		return chArr;
	}
	
	private static char[] characterArrayToCharArray(Character[] chArr) {
		char[] charArr = new char[chArr.length];
		for(int i=0; i<chArr.length; i++) {
			charArr[i] = chArr[i];
		}
		return charArr;
	}
}