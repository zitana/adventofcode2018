package day4;

import utils.InputReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReposeRecord {

  public static List<String> GUARD_DATA;

  public static int solveWithOop() {
    GUARD_DATA = InputReader.readFile("day4input");
    sortGuardData(GUARD_DATA);

    Guard currentGuard = new Guard(1);
    Pattern idPattern = Pattern.compile("#(\\d*)");
    Matcher matcher;
    boolean awake = true;
    int minuteFellAsleep = 0;
    int awaken;

    //Process data
    NightWatch nightWatch = new NightWatch();

    for (String entry : GUARD_DATA) {
      matcher = idPattern.matcher(entry);
      if (matcher.find()) {
        currentGuard = new Guard(Integer.parseInt(matcher.group(1)));
        nightWatch.add(currentGuard);
        currentGuard = nightWatch.retrieveGuard(currentGuard.getId());
      } else {
        if (awake) {
          minuteFellAsleep = Integer.parseInt(entry.substring(15, 17));
          awake = false;
        } else {
          awaken = Integer.parseInt(entry.substring(15, 17));
          awake = true;

          //Record minutes asleep to current guard
          for (int i = minuteFellAsleep; i < awaken; i++) {
            currentGuard.getAsleepPerMinute().put(i, currentGuard.getAsleepPerMinute().get(i) + 1);
          }
          //Increment total minutes asleep
          currentGuard.setMinutesSlept(currentGuard.getMinutesSlept() + (awaken - minuteFellAsleep));
        }
      }
    }

    Guard guardWhoSleepsTheMost = nightWatch.findGuardWhoSleepsTheMost();
    System.out.println("PART 1 Solution: " + guardWhoSleepsTheMost.getId() * guardWhoSleepsTheMost.reportMinuteMostOftenAsleep());
    Guard guardWithMostConsequentSleepSchedule = nightWatch.findGuardWithMostConsequentSleepSchedule();
    return guardWithMostConsequentSleepSchedule.getId() * guardWithMostConsequentSleepSchedule.reportMinuteMostOftenAsleep();
  }

  private static void sortGuardData(List<String> guardData) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    guardData.sort((o1, o2) -> {
      Date date1 = new Date();
      Date date2 = new Date();
      try {
        date1 = df.parse(o1.substring(1, 16));
        date2 = df.parse(o2.substring(1, 16));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return date1.compareTo(date2);
    });
  }
}
