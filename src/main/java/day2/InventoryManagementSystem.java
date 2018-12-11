package day2;

import utils.InputReader;

import java.util.*;

public class InventoryManagementSystem {
  public static int checksum() {
    List<String> inventory = InputReader.readFile("day2input");

    int doubleCount = 0;
    int tripleCount = 0;

    Map<String, Integer> occurrences = new HashMap<>();
    Set<String> candidates = new HashSet<>();

    for (String id : inventory) {
      occurrences.clear();
      for (String c : id.split("")) {
        if (!occurrences.containsKey(c)) {
          occurrences.put(c, 1);
        } else {
          occurrences.put(c, occurrences.get(c) + 1);
        }
      }
      if (occurrences.values().stream().filter(n -> n.equals(2)).count() >= 1) {
        doubleCount++;
        candidates.add(id);
      }
      if (occurrences.values().stream().filter(n -> n.equals(3)).count() >= 1) {
        tripleCount++;
        candidates.add(id);
      }
    }

    ArrayList<String> strings = new ArrayList<>(candidates);
    for (int i = 0; i < strings.size(); i++) {
      for (int j = i + 1; j < strings.size(); j++) {
        compare(strings.get(i), strings.get(j));
      }
    }
    //Part one solution:
    return doubleCount * tripleCount;
  }

  public static boolean compare(String first, String second) {
    int differences = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i)) {
        differences++;
        if (differences > 1) {
          return false;
        }
      } else {
        sb.append(first.charAt(i));
      }
    }
    //Part two solution
    System.out.println(sb.toString());
    return true;
  }
}



