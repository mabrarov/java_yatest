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

import java.util.function.IntConsumer;

public class Solver implements IntConsumer {

  private long length;
  private long maxLength;

  @Override
  public void accept(int value) {
    if (value == 0) {
      length = 0;
    } else {
      ++length;
      if (length > maxLength) {
        maxLength = length;
      }
    }
  }

  public long getMaxLength() {
    return maxLength;
  }

}
