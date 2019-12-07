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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final int MAX_ITEMS = 10000;

  public static void main(String[] args) throws IOException {
    final Solver solver = new Solver();
    try (final InputStreamReader inputStream = new InputStreamReader(System.in);
         final BufferedReader reader = new BufferedReader(inputStream)) {
      int itemCount = readInt(reader);
      if (itemCount < 0 || itemCount > MAX_ITEMS) {
        throw new IllegalArgumentException("number of items should be [0, " + MAX_ITEMS + "]");
      }
      while (itemCount > 0) {
        final int item = readInt(reader);
        if (item != 0 && item != 1) {
          throw new IllegalArgumentException("items should be 0 or 1");
        }
        solver.accept(item);
        --itemCount;
      }
    }
    System.out.println(solver.getMaxLength());
  }

  private static int readInt(final BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

}