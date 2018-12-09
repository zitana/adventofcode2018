package day4;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NightWatch {
    private Map<Integer, Guard> guards;

    public NightWatch() {
        this.guards = new HashMap<>();
    }

    public Guard retrieveGuard(int id) {
        return guards.get(id);
    }

    public void add(Guard guard) {
        if (!guards.containsKey(guard.getId()))
        guards.put(guard.getId(), guard);
    }

    public boolean contains(Guard g) {
        return guards.containsKey(g.getId());
    }

    public boolean contains(Integer id) {
        return guards.containsKey(id);
    }

    public void printGuards() {
        System.out.println(guards);
    }

    public Guard findGuardWithMostConsequentSleepSchedule() {
        return Collections.max(guards.entrySet(), Comparator.comparingInt(n -> n.getValue().reportFrequencyOfMinuteMostOftenAsleep())).getValue();
    }

    public Guard findGuardWhoSleepsTheMost() {
        return guards.get(Collections.max(guards.entrySet(), Comparator.comparingInt(n -> n.getValue().getMinutesSlept())).getKey());
    }

}
