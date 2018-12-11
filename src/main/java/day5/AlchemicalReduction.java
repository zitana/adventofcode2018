package day5;

import utils.InputReader;

public class AlchemicalReduction {

  public static int part1(String input) {

    boolean shrinking = true;
    while (shrinking) {
      for (int i = 0; i < input.length() - 2; i++) {
        if (doesReact(input.charAt(i), input.charAt(i + 1))) {
          input = input.replace(input.substring(i, i + 2), "");
          shrinking = true;
          break;
        }
        shrinking = false;
      }
    }
    return input.length();
  }

  private static boolean doesReact(char firstLetter, char secondLetter) {
    return Math.abs(firstLetter - secondLetter) == 32;
  }

  public static int part2() {
    String input = InputReader.readString("day5input");
    String stringToModify = input;
    int min = Integer.MAX_VALUE;
    int current;
    for (int i = 65; i < 91; i++) {
      stringToModify = input;
      String character = String.valueOf((char) i);
      String modifiedString = stringToModify.replace(character, "").replace(character.toLowerCase(), "");
      current = part1(modifiedString);
      if (current < min) {
        min = current;
      }
    }
    return min;
  }
}
