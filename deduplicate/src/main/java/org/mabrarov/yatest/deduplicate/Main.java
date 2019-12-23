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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Iterating over all currency");
    for (final Currency currency : Currency.all()) {
      System.out.println("Ordinal of " + currency + " is " + currency.ordinal());
      System.out.println("Name of " + currency + " is " + currency.name());
    }
    System.out.println(Currency.get(Currency.CAD.ordinal()));
    System.out.println(Currency.get(Currency.CAD.name()));
  }

}

final class Currency {

  public static final Currency USD = new Currency();
  public static final Currency CAD = new Currency();
  public static final Currency RUB = new Currency();

  private static final List<Currency> allCurrency;
  private static final Map<String, Currency> nameToCurrency;

  static {
    final List<Currency> allCurrencyTemp = new ArrayList<>();
    final Map<String, Currency> nameToCurrencyTemp = new HashMap<>();
    int ordinal = 0;
    for (final Field f : Currency.class.getDeclaredFields()) {
      if (Modifier.isStatic(f.getModifiers()) && f.getType().equals(Currency.class)) {
        Currency currency;
        try {
          currency = (Currency) f.get(null);
        } catch (IllegalAccessException e) {
          throw new AssertionError(e);
        }
        if (currency == null) {
          throw new AssertionError("Static fields of Currency type should be not null");
        }
        String name = f.getName();
        currency.ordinal = ordinal++;
        currency.name = name;
        allCurrencyTemp.add(currency);
        nameToCurrencyTemp.put(name, currency);
      }
    }
    allCurrency = Collections.unmodifiableList(allCurrencyTemp);
    nameToCurrency = Collections.unmodifiableMap(nameToCurrencyTemp);
  }

  private int ordinal;
  private String name;

  private Currency() {
  }

  public int ordinal() {
    return ordinal;
  }

  public String name() {
    return name;
  }

  public static List<Currency> all() {
    return allCurrency;
  }

  public static Currency get(int ordinal) {
    return allCurrency.get(ordinal);
  }

  public static Currency get(String name) {
    return nameToCurrency.get(name);
  }

  @Override
  public String toString() {
    return name;
  }

}
