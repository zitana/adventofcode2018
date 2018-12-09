package day4;

import utils.InputReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReposeRecord {

    public static List<String> GUARDDATA;

    public static int partOne() {
        List<String> guardData = InputReader.readFile("day4input");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        guardData.sort((o1, o2) -> {
            Date date1 = new Date();
            Date date2 = new Date();
            try {
                date1 = df.parse(o1.substring(1,16));
                date2 = df.parse(o2.substring(1,16));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date1.compareTo(date2);
        });

        Map<Integer,Integer> minutesAsleep = new HashMap<>();
        Map<Integer,Integer> minuteAsleep = new HashMap<>();
        Integer currentGuard = 0;
        Pattern idPattern = Pattern.compile("#(\\d*)");
        Matcher matcher;
        boolean awake = true;
        int fellAsleep = 0;
        int awaken;

        for (String entry : guardData) {
            matcher = idPattern.matcher(entry);
            if (matcher.find()) {
                currentGuard = Integer.parseInt(matcher.group(1));
            } else {
                if (awake) {
                    fellAsleep = Integer.parseInt(entry.substring(15,17));
                    awake = false;
                } else {
                    awaken = Integer.parseInt(entry.substring(15,17));
                    awake = true;
                    if (minutesAsleep.containsKey(currentGuard)) {
                        minutesAsleep.put(currentGuard, minutesAsleep.get(currentGuard) + (awaken - fellAsleep));
                    } else {
                        minutesAsleep.put(currentGuard, awaken - fellAsleep);
                    }
                    //Find out when is the guard most often asleep
                    if (currentGuard == 1823) {
                        for (int i = fellAsleep; i < awaken; i++) {
                            if (minuteAsleep.containsKey(i)) {
                                minuteAsleep.put(i, minuteAsleep.get(i) + 1);
                            } else {
                                minuteAsleep.put(i,1);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(minutesAsleep);
        //Find the guard with most amount of sleep
        int guard = Collections.max(minutesAsleep.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println(guard);
        int minute = Collections.max(minuteAsleep.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println(minute);
        return guard * minute;
    }

    public static int partTwo() {
        GUARDDATA = InputReader.readFile("day4input");
        sortGuardData(GUARDDATA);

        Guard currentGuard = new Guard(1);
        Pattern idPattern = Pattern.compile("#(\\d*)");
        Matcher matcher;
        boolean awake = true;
        int fellAsleep = 0;
        int awaken;

        NightWatch nightWatch = new NightWatch();

        for (String entry : GUARDDATA) {
            matcher = idPattern.matcher(entry);
            if (matcher.find()) {
                currentGuard = new Guard(Integer.parseInt(matcher.group(1)));
                nightWatch.add(currentGuard);
                currentGuard=nightWatch.retrieveGuard(currentGuard.getId());
            } else {
                if (awake) {
                    fellAsleep = Integer.parseInt(entry.substring(15,17));
                    awake = false;
                } else {
                    awaken = Integer.parseInt(entry.substring(15,17));
                    awake = true;

                    //Record minutes asleep to current guard
                    for (int i = fellAsleep; i < awaken; i++) {
                        currentGuard.getAsleepPerMinute().put(i,currentGuard.getAsleepPerMinute().get(i) + 1);
                    }
                    //Increment total minutes asleep
                    currentGuard.setMinutesSlept(currentGuard.getMinutesSlept() + (awaken - fellAsleep));
                }
            }
        }

        nightWatch.printGuards();
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
