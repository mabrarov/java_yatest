package org.mabrarov.yatest;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SolverTest {

  @Test
  public void test_null_empty() {
    assertThat(Solver.rle(null), isEmptyString());
  }

  @Test
  public void test_empty_empty() {
    assertThat(Solver.rle(""), isEmptyString());
  }

  @Test
  public void test_singleChar_cingleChar() {
    assertThat(Solver.rle("P"), containsString("P"));
  }

  @Test
  public void test_allCharsSame_theSameCharMultiplied() {
    assertThat(Solver.rle("MMMM"), containsString("M4"));
  }

  @Test(expected = Exception.class)
  public void test_startsFromLessThanA_exception() {
    Solver.rle("0ABC");
  }

  @Test(expected = Exception.class)
  public void test_containsLessThanA_exception() {
    Solver.rle("A0BC");
  }

  @Test(expected = Exception.class)
  public void test_endsWithLessThanA_exception() {
    Solver.rle("ABC0");
  }

  @Test(expected = Exception.class)
  public void test_startsFromGreaterThanZ_exception() {
    Solver.rle("aABC");
  }

  @Test(expected = Exception.class)
  public void test_containsGreaterThanZ_exception() {
    Solver.rle("AaBC");
  }

  @Test(expected = Exception.class)
  public void test_endsWithGreaterThanZ_exception() {
    Solver.rle("ABCa");
  }

  @Test
  public void test_startsFromSingleChar_startsFromTheSameSingleChar() {
    assertThat(Solver.rle("XYYYBXBTTRR"), startsWith("XY3"));
  }

  @Test
  public void test_endsWithSingleChar_endsWithTheSameSingleChar() {
    assertThat(Solver.rle("AAAXYRYYBBTTR"), endsWith("T2R"));
  }

  @Test
  public void test_containsSingleChar_containsTheSameSingleChar() {
    assertThat(Solver.rle("AABAXYYYBTTRR"), containsString("Y3BT2"));
  }

  @Test
  public void test_complexSequenceWithRepeatedChars_expectedValue() {
    assertThat(Solver.rle("AABAXYYYBTPTRRUUUAPPPPNMNMNLLLEEEAAA"),
        containsString("A2BAXY3BTPTR2U3AP4NMNMNL3E3A3"));
  }

}
