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
package org.mabrarov.yatest.max_sequence_len;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public final class SolverTest {

  @Test
  public void test_noItems_zero() {
    assertEquals(0, new Solver().getMaxLength());
  }

  @Test
  public void test_singleZeroItem_zero() {
    final Solver solver = new Solver();
    solver.accept(0);
    assertEquals(0, solver.getMaxLength());
  }

  @Test
  public void test_singleNonZeroItem_one() {
    final Solver solver = new Solver();
    solver.accept(1);
    assertEquals(1, solver.getMaxLength());
  }

  @Test
  public void test_longestSequenceAtBegin_expectedValue() {
    assertEquals(3, count(1, 1, 1, 0, 0, 1, 0));
  }

  @Test
  public void test_longestSequenceAtEnd_expectedValue() {
    assertEquals(3, count(1, 1, 0, 0, 1, 0, 0, 1, 1, 1));
  }

  @Test
  public void test_longestSequenceInTheMiddle_expectedValue() {
    assertEquals(3, count(1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1));
  }

  @Test
  public void test_duplicateLongestSequence_expectedValue() {
    assertEquals(3, count(1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1));
  }

  private long count(int... items) {
    final Solver solver = new Solver();
    Arrays.stream(items).sequential().forEach(solver);
    return solver.getMaxLength();
  }

}
