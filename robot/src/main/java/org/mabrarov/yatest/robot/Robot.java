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
package org.mabrarov.yatest.robot;

import java.util.concurrent.Semaphore;

class Foot implements Runnable {

  private final Semaphore mayStep;
  private final Semaphore stepMade;
  private final String name;

  public Foot(String name, Semaphore mayStep, Semaphore stepMade) {
    this.name = name;
    this.mayStep = mayStep;
    this.stepMade = stepMade;
  }

  public void run() {
    for (; ; ) {
      try {
        mayStep.acquire();
        step();
        stepMade.release();
      } catch (InterruptedException ignored) {
        Thread.currentThread().interrupt();
        break;
      }
    }
  }

  private void step() {
    System.out.println("Step by " + name);
  }
}

public class Robot {

  public static void main(String[] args) {
    // First step by right foot
    final Semaphore leftStepMade = new Semaphore(1);
    final Semaphore rightStepMade = new Semaphore(0);
    new Thread(new Foot("left", rightStepMade, leftStepMade)).start();
    new Thread(new Foot("right", leftStepMade, rightStepMade)).start();
  }
}
