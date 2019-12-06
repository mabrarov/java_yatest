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

  @Test
  public void test_null_jewellery_zero() {
    assertEquals(0, countStoneJewellery(null, "abc"));
  }

  @Test
  public void test_null_stones_zero() {
    assertEquals(0, countStoneJewellery("abc", null));
  }

  @Test
  public void test_null_jewellery_and_null_stones_zero() {
    assertEquals(0, countStoneJewellery(null, null));
  }

  @Test
  public void test_empty_jewellery_zero() {
    assertEquals(0, countStoneJewellery("", "abc"));
  }

  @Test
  public void test_empty_stones_zero() {
    assertEquals(0, countStoneJewellery("abc", ""));
  }

  @Test
  public void test_empty_jewellery_and_empty_stones_zero() {
    assertEquals(0, countStoneJewellery("", ""));
  }

  @Test
  public void test_single_jewellery_and_different_stones_zero() {
    assertEquals(0, countStoneJewellery("a", "bcd"));
  }

  @Test
  public void test_single_stone_and_different_jewellery_zero() {
    assertEquals(0, countStoneJewellery("bcd", "a"));
  }

  @Test
  public void test_jewellery_intersect_one_stone_non_zero() {
    assertEquals(1, countStoneJewellery("abcdefg", "zwway"));
  }

  @Test
  public void test_duplicate_jewellery_intersect_duplicate_stones_non_zero() {
    assertEquals(4, countStoneJewellery("aabcadefagbn", "zwwaaybb"));
  }

}
