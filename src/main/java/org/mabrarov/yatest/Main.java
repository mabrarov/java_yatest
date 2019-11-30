package org.mabrarov.yatest;

public class Main {

  public static void main(String[] args) {
    if (args.length < 1) {
      // No text to transform is specified - show usage and ext with error
      System.err.println("Usage: java -jar yatest.jar text_to_transform");
      System.exit(1);
    }
    String input = args[0];
    String result = Solver.rle(input);
    System.out.println(input);
    System.out.println(result);
  }

}
