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
package org.mabrarov.yatest.list_merge;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Main {

  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 100;
  private static final int MAX_LISTS = 1024;
  private static final int DICT_SIZE = MAX_VALUE - MIN_VALUE + 1;

  public static void main(String[] args) throws IOException {
    final int[] dict = new int[DICT_SIZE];
    Arrays.fill(dict, 0);
    int k = readNonNegativeInt(System.in);
    if (k < 0 || k > MAX_LISTS) {
      throw new IllegalArgumentException("number of lists should be [0, " + MAX_LISTS + "]");
    }
    final int maxListSize = k * 10;
    for (; k > 0; --k) {
      int n = readNonNegativeInt(System.in);
      if (n < 0 || n > maxListSize) {
        throw new IllegalArgumentException("list size should be [0, " + maxListSize + "]");
      }
      for (; n > 0; --n) {
        final int value = readNonNegativeInt(System.in);
        if (value < MIN_VALUE || value > MAX_VALUE) {
          throw new IllegalArgumentException(
              "list item should be [" + MIN_VALUE + ", " + MAX_VALUE + "]");
        }
        ++dict[getDictIndex(value)];
      }
    }
    for (int i = 0; i < dict.length; ++i) {
      int f = dict[i];
      final int value = MIN_VALUE + i;
      for (; f > 0; --f) {
        printNonNegativeInt(value, System.out);
        System.out.write(' ');
      }
    }
    System.out.flush();
  }

  private static int getDictIndex(int value) {
    return value - MIN_VALUE;
  }

  private static int readNonNegativeInt(InputStream stream) throws IOException {
    boolean first = true;
    long value = 0;
    for (; ; ) {
      final int c = stream.read();
      if (c == -1 || (!first && isSeparator(c))) {
        break;
      }
      if (c == '+') {
        if (!first) {
          throw new IllegalArgumentException("sign is allowed before 1st digit only");
        }
        first = false;
        continue;
      }
      if (first && (isSeparator(c))) {
        continue;
      }
      if (c < '0' || c > '9') {
        throw new IllegalArgumentException("only decimal digits are allowed");
      }
      first = false;
      value = value * 10 + (c - '0');
      if (value > Integer.MAX_VALUE) {
        throw new IllegalArgumentException("32 int overflow");
      }
    }
    return (int) value;
  }

  private static boolean isSeparator(int c) {
    return c == '\n' ||c == '\r' || c == ' ' || c == '\t';
  }

  private static void printNonNegativeInt(int value, OutputStream stream) throws IOException {
    if (value == 0) {
      stream.write('0');
      return;
    }
    int prev = value / 10;
    if (prev != 0) {
      printNonNegativeInt(prev, stream);
    }
    stream.write((char) ('0' + value % 10));
  }
}
