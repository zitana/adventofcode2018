package day4;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Guard {
    private int id;
    private int minutesSlept;
    private Map<Integer,Integer> asleepPerMinute;

    public Guard(int id) {
        this.id = id;
        this.minutesSlept = 0;
        this.asleepPerMinute = new HashMap<>();
        for (int i = 0; i < 60; i++) {
            asleepPerMinute.put(i,0);
        }
    }

    public int reportMinuteMostOftenAsleep(){
        Integer key = Collections.max(asleepPerMinute.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println("Guard id:" + getId() + " | Minute most often asleep: " + key + " | Frequency " + asleepPerMinute.get(key));
        return key;
    }

    public int reportFrequencyOfMinuteMostOftenAsleep(){
        return asleepPerMinute.get(reportMinuteMostOftenAsleep());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinutesSlept() {
        return minutesSlept;
    }

    public void setMinutesSlept(int minutesSlept) {
        this.minutesSlept = minutesSlept;
    }

    public Map<Integer, Integer> getAsleepPerMinute() {
        return asleepPerMinute;
    }

    public void setAsleepPerMinute(Map<Integer, Integer> asleepPerMinute) {
        this.asleepPerMinute = asleepPerMinute;
    }


    @Override
    public String toString() {
        return "Guard{" +
                "id=" + id +
                ", minutesSlept=" + minutesSlept +
                ", \nasleepPerMinute=" + asleepPerMinute +
                "}\n\n";
    }
}
