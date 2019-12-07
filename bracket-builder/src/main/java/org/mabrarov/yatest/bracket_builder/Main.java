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
package org.mabrarov.yatest.bracket_builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Main {

  private static final int MAX_PAIRS = 11;
  private static final char OPEN_BRACKET = '(';
  private static final char CLOSE_BRACKET = ')';

  public static void main(String[] args) throws IOException {
    int pairCount;
    try (final InputStreamReader inputStream = new InputStreamReader(System.in);
        final BufferedReader reader = new BufferedReader(inputStream)) {
      pairCount = Integer.parseInt(reader.readLine());
    }
    if (pairCount < 0 || pairCount > MAX_PAIRS) {
      throw new IllegalArgumentException("number of pairs should be [0, " + MAX_PAIRS + "]");
    }
    if (pairCount == 0) {
      return;
    }
    char[] brackets = new char[pairCount * 2];
    printPairs(brackets, 0, 0, pairCount, System.out);
  }

  private static void printPairs(char[] brackets, int offset, int openPairs, int pendingPairs,
      OutputStream stream) throws IOException {
    if (pendingPairs == 0 && openPairs == 0) {
      print(brackets, stream);
      return;
    }
    if (pendingPairs > 0) {
      // ...(...
      brackets[offset] = OPEN_BRACKET;
      printPairs(brackets, offset + 1, openPairs + 1, pendingPairs - 1, stream);
    }
    if (openPairs > 0) {
      // ...)...
      brackets[offset] = CLOSE_BRACKET;
      printPairs(brackets, offset + 1, openPairs - 1, pendingPairs, stream);
    }
  }

  private static void print(char[] brackets, OutputStream stream) throws IOException {
    for (char bracket : brackets) {
      stream.write(bracket);
    }
    stream.write('\n');
    stream.flush();
  }
}
