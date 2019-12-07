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
package org.mabrarov.yatest.anagram;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

  private static final char MIN_CHAR = 'a';
  private static final char MAX_CHAR = 'z';
  private static final int DICT_SIZE = MAX_CHAR - MIN_CHAR + 1;

  public static void main(String[] args) throws IOException {
    final int[] dict = new int[DICT_SIZE];
    Arrays.fill(dict, 0);
    int c;
    while ((c = readChar(System.in)) != -1) {
      final int index = getDictIndex(c);
      ++dict[index];
    }
    while ((c = readChar(System.in)) != -1) {
      final int index = getDictIndex(c);
      if (dict[index] == 0) {
        System.out.println('0');
        return;
      }
      --dict[index];
    }
    for (final int f : dict) {
      if (f != 0) {
        System.out.println('0');
        return;
      }
    }
    System.out.println('1');
  }

  private static int readChar(InputStream stream) throws IOException {
    final int c = stream.read();
    if (c < 0 || c == '\n') {
      return -1;
    }
    if (c < MIN_CHAR || c > MAX_CHAR) {
      throw new IllegalArgumentException("allowed characters are " + MIN_CHAR + "-" + MAX_CHAR);
    }
    return c;
  }

  private static int getDictIndex(int c) {
    return c - MIN_CHAR;
  }

}
