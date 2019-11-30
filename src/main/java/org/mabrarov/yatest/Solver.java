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
package org.mabrarov.yatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Solver {

  private static class Item {

    final char character;
    int count;

    Item(final int character) {
      this.character = (char) character;
      count = 1;
    }

    @Override
    public String toString() {
      return count < 2 ? Character.toString(character) : Character.toString(character) + count;
    }
  }

  public static String rle(final String str) {
    if (str == null || str.isEmpty()) {
      return "";
    }
    return rle(str.chars().parallel());
  }

  private static String rle(final IntStream stream) {
    return stream.collect(ArrayList::new, (items, character) -> {
      if (character < 'A' || 'Z' < character) {
        throw new IllegalArgumentException("Found \"" + (char) character + "\"");
      }
      if (items.isEmpty()) {
        items.add(new Item(character));
      } else {
        final Item lastItem = lastItem(items);
        if (lastItem.character == character) {
          ++lastItem.count;
        } else {
          items.add(new Item(character));
        }
      }
    }, (BiConsumer<List<Item>, List<Item>>) (left, right) -> {
      if (left.isEmpty()) {
        left.addAll(right);
      } else if (!right.isEmpty()) {
        final Item leftLastItem = lastItem(left);
        final Item rightFirstItem = firstItem(right);
        if (leftLastItem.character != rightFirstItem.character) {
          left.addAll(right);
        } else {
          leftLastItem.count += rightFirstItem.count;
          left.addAll(right.subList(1, right.size()));
        }
      }
    }).stream().map(Objects::toString).collect(Collectors.joining());
  }

  private static <T> T lastItem(final List<T> list) {
    return list.listIterator(list.size()).previous();
  }

  private static <T> T firstItem(final List<T> list) {
    return list.iterator().next();
  }
}
