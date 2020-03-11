import Throwables.BadBadValueException;

public class Main {

    public static void main(String[] args) {

//        TimeDuration.runTimeDurationTests();

        RaceResults lRaceResult = new RaceResults();

        try {
            lRaceResult.onNewResult("1", new TimeDuration(100));
            lRaceResult.onNewResult("2", new TimeDuration(200));
            lRaceResult.onNewResult("3", new TimeDuration(50));
            lRaceResult.onNewResult("4", new TimeDuration(1));
            lRaceResult.onNewResult("5", new TimeDuration(500));
        } catch (BadBadValueException e) {
            e.printStackTrace();
        }

        lRaceResult.printResults();

    }


}
