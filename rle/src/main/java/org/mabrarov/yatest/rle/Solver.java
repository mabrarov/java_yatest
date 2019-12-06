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
package org.mabrarov.yatest.rle;

public final class Solver {

  private Solver() {
    throw new AssertionError("Utility class should not be instantiated");
  }

  public static String rle(final String str) {
    if (str == null || str.isEmpty()) {
      return "";
    }
    final int length = str.length();
    // Result is at most as long as input str
    final StringBuilder builder = new StringBuilder(length);
    char prevChar = 0;
    int prevCharCount = 0;
    for (int i = 0; i < length; ++i) {
      final char currentChar = str.charAt(i);
      // Validate: str should consist of A-Z symbols only
      if (currentChar < 'A' || 'Z' < currentChar) {
        throw new IllegalArgumentException("Invalid char \"" + currentChar + "\" at " + i);
      }
      // First char should be handled separately
      if (builder.length() == 0) {
        builder.append(currentChar);
        prevChar = currentChar;
        prevCharCount = 1;
        continue;
      }
      // Handling of subsequent char when there is previous char
      if (currentChar == prevChar) {
        // Found duplicate
        ++prevCharCount;
        continue;
      }
      // Found new char. First complete handling of previous char
      if (prevCharCount > 1) {
        // Store number of chars only if it's greater than one
        builder.append(prevCharCount);
      }
      // Handle new char
      builder.append(currentChar);
      prevChar = currentChar;
      prevCharCount = 1;
    }
    // Complete handling of last char
    if (prevCharCount > 1) {
      builder.append(prevCharCount);
    }
    return builder.toString();
  }
}
