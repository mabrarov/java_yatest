/*
 * Copyright (c) 2019 Marat Abrarov (abrarov@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mabrarov.yatest.jewelery_and_stones;

import static org.junit.Assert.assertEquals;
import static org.mabrarov.yatest.jewelery_and_stones.Solver.countStoneJewellery;

import org.junit.Test;

public final class SolverTest {

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidJewellery_exception() {
    countStoneJewellery("aabcadefagRbn", "zwwaaybb");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidStone_exception() {
    countStoneJewellery("aabcadefagbn", "zwwa|aybb");
  }

  @Test
  public void test_nullJewellery_zero() {
    assertEquals(0, countStoneJewellery(null, "abc"));
  }

  @Test
  public void test_nullStones_zero() {
    assertEquals(0, countStoneJewellery("abc", null));
  }

  @Test
  public void test_nullJewelleryAndNullStones_zero() {
    assertEquals(0, countStoneJewellery(null, null));
  }

  @Test
  public void test_emptyJewellery_zero() {
    assertEquals(0, countStoneJewellery("", "abc"));
  }

  @Test
  public void test_emptyStones_zero() {
    assertEquals(0, countStoneJewellery("abc", ""));
  }

  @Test
  public void test_emptyJewelleryAndEmptyStones_zero() {
    assertEquals(0, countStoneJewellery("", ""));
  }

  @Test
  public void test_singleJewelleryAndDifferentStones_zero() {
    assertEquals(0, countStoneJewellery("a", "bcd"));
  }

  @Test
  public void test_singleStoneAndDifferentJewellery_zero() {
    assertEquals(0, countStoneJewellery("bcd", "a"));
  }

  @Test
  public void test_jewelleryIntersectOneStone_non_zero() {
    assertEquals(1, countStoneJewellery("abcdefg", "zwway"));
  }

  @Test
  public void test_duplicateJewelleryIntersectDuplicateStones_non_zero() {
    assertEquals(4, countStoneJewellery("aabcadefagbn", "zwwaaybb"));
  }

}
