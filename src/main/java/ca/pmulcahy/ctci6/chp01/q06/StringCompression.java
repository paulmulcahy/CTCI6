package ca.pmulcahy.ctci6.chp01.q06;

/*
 * Implement a method to perform basic string compression using the counts of repeated characters. For
 * example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become
 * smaller than the original string, your method should return the original string. You can assume the
 * string only has uppercase and lowercase letters (a-z).
 */
public class StringCompression {
  public static String compress(final String uncompressed) {

    if (uncompressed.length() == 0) {
      return uncompressed;
    }

    final StringBuilder sb = new StringBuilder();

    char lastChar = uncompressed.charAt(0);
    int lastCharCount = 1;
    for (int i = 1; i < uncompressed.length(); i++) {
      if (uncompressed.charAt(i) == lastChar) {
        lastCharCount++;
      } else {
        sb.append(lastChar);
        sb.append(lastCharCount);
        lastChar = uncompressed.charAt(i);
        lastCharCount = 1;
      }
    }
    sb.append(lastChar);
    sb.append(lastCharCount);

    if (sb.length() > uncompressed.length()) {
      return uncompressed;
    }
    return sb.toString();
  }
}
