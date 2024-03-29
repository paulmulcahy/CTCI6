package ca.pmulcahy.ctci6.chp01.q03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestReplaceSpacesWithPercentTwenty {

  @Test
  void NoSpaces() {

    final String abc = "ABC";

    final String actual = ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abc);
    assertEquals(
        abc, actual, "A string without spaces :" + abc + " should return a matching value.");
  }

  @Test
  void OnlySpace() {

    final String space = " ";
    final String expected = "%20";

    final String actual = ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(space);
    assertEquals(
        expected, actual, "A string with a space :" + space + " should return " + expected + ".");
  }

  @Test
  void OneSpaceInMiddle() {

    final String abcd = "AB CD";
    final String expected = "AB%20CD";

    final String actual = ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
    assertEquals(
        expected, actual, "A string with a space :" + abcd + " should return " + expected + ".");
  }

  @Test
  void OneSpaceAtBeginning() {

    final String abcd = " ABCD";
    final String expected = "%20ABCD";

    final String actual = ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
    assertEquals(
        expected, actual, "A string with a space :" + abcd + " should return " + expected + ".");
  }

  @Test
  void OneSpaceAtEnd() {

    final String abcd = "ABCD ";
    final String expected = "ABCD%20";

    final String actual = ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
    assertEquals(
        expected, actual, "A string with a space :" + abcd + " should return " + expected + ".");
  }

  @Test
  void ManySpaces() {

    final String abcd = " A B  C D ";
    final String expected = "%20A%20B%20%20C%20D%20";

    final String actual = ReplaceSpacesWithPercentTwenty.replaceSpacesWithPercentTwenty(abcd);
    assertEquals(
        expected, actual, "A string with a space :" + abcd + " should return " + expected + ".");
  }
}
