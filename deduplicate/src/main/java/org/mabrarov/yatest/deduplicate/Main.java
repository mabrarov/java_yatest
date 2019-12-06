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
package org.mabrarov.yatest.deduplicate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

  private static final int MAX_ITEMS = 1000000;

  public static void main(String[] args) throws IOException {
    boolean first = true;
    int lastValue = 0;
    int itemCount = readInt(System.in);
    if (itemCount < 0 || itemCount > MAX_ITEMS) {
      throw new IllegalArgumentException("number of items should be [0, " + MAX_ITEMS + "]");
    }
    int item;
    while (itemCount > 0) {
      item = readInt(System.in);
      if (!first && lastValue > item) {
        throw new IllegalArgumentException(
            "items should be non-decreasing, previous item " + lastValue + " current item " + item);
      }
      if (first || lastValue != item) {
        first = false;
        printInt(item, System.out);
      }
      lastValue = item;
      --itemCount;
    }
  }

  private static int readInt(InputStream stream) throws IOException {
    boolean first = true;
    int sign = 1;
    long abs = 0;
    long value = 0;
    for (; ; ) {
      final int c = stream.read();
      if (c == '\n' || c == -1) {
        break;
      }
      if (c == '-' || c == '+') {
        if (!first) {
          throw new IllegalArgumentException("sign is allowed before 1st digit only");
        }
        sign = c == '-' ? -1 : 1;
        continue;
      }
      if (c == ' ' || c == '\t') {
        continue;
      }
      if (c < '0' || c > '9') {
        throw new IllegalArgumentException("only decimal digits are allowed");
      }
      first = false;
      abs = abs * 10 + (c - '0');
      value = abs * sign;
      if (value > Integer.MAX_VALUE) {
        throw new IllegalArgumentException("32 int overflow");
      }
      if (value < Integer.MIN_VALUE) {
        throw new IllegalArgumentException("32 int underflow");
      }
    }
    return (int) value;
  }

  private static void printInt(int value, OutputStream stream) throws IOException {
    if (value >= 0) {
      printNonNegativeInt(value, stream);
    } else {
      stream.write('-');
      printNonNegativeInt(-((long) value), stream);
    }
    stream.write('\n');
    stream.flush();
  }

  private static void printNonNegativeInt(long value, OutputStream stream) throws IOException {
    if (value == 0) {
      stream.write('0');
      return;
    }
    long prev = value / 10;
    if (prev != 0) {
      printNonNegativeInt(prev, stream);
    }
    stream.write((char) ('0' + value % 10));
  }

}
