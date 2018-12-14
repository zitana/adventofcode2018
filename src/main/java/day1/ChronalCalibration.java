package day1;

import utils.InputReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChronalCalibration {

  public static int countFrequency() {
    List<String> data = InputReader.readFile("day1input");
    return data.stream().mapToInt(Integer::valueOf).sum();
  }

  public static int calibrate() {
    List<Integer> numbers = InputReader.readFile("day1input").stream().map(Integer::valueOf).collect(Collectors.toList());
    Set<Integer> frequencies = new HashSet<>();
    int currentFrequency = 0;
    boolean searching = true;
    do {
      for (Integer number : numbers) {
        currentFrequency += number;
        if (frequencies.contains(currentFrequency)) {
          searching = false;
          break;
        }
        frequencies.add(currentFrequency);
      }
    } while (searching);
    return currentFrequency;
  }

}
