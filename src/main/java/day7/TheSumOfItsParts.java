package day7;

import utils.InputReader;

import java.util.*;

public class TheSumOfItsParts {

  public static void main(String[] args) {
    List<String> input = InputReader.readFile("day7input");

    Map<Character, TreeSet<Character>> steps = new HashMap<>();

    for (String s : input) {
      Character prerequisite = s.charAt(5);
      Character character = s.charAt(36);
      steps.putIfAbsent(prerequisite, new TreeSet<>());
      if (steps.containsKey(character)) {
        steps.get(character).add(prerequisite);
      } else {
        steps.put(character, new TreeSet<>());
        steps.get(character).add(prerequisite);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!steps.isEmpty()) {
      Character c = steps.entrySet().stream().filter(e -> e.getValue().isEmpty()).findFirst().get().getKey();
      sb.append(c);
      steps.remove(c);
      for (TreeSet<Character> set : steps.values()) {
        set.remove(c);
      }
    }
    System.out.println(sb.toString());
  }
}
