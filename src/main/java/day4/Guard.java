package day4;

public class Guard {
    private int id;
    private int minutesSlept;
    private int[] asleepPerMinute;

    public Guard(int id) {
        this.id = id;
        this.minutesSlept = 0;
        this.asleepPerMinute = new int[60];
    }

    public int reportMinuteMostOftenAsleep(){
        int max= 0;
        int index = 0;
        for (int i = 0; i < asleepPerMinute.length; i++) {
            if (asleepPerMinute[i] > max) {
                max = asleepPerMinute[i];
                index = i;
            }
        }
        return index;
    }

    public int reportFrequencyOfMinuteMostOftenAsleep(){
        return asleepPerMinute[reportMinuteMostOftenAsleep()];
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

    public int[] getAsleepPerMinute() {
        return asleepPerMinute;
    }

    public void setAsleepPerMinute(int[] asleepPerMinute) {
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
