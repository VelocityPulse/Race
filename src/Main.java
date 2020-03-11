import Throwables.BadBadValueException;

public class Main {

    public static void main(String[] args) {

        /*
            Hello, here's my idea about this system
            For me there's several issues that make it not really efficient.

            First, there's a missing scenario, in case TimeDuration throws.
            The code currently throws an error which is a problem for the behaviour of the code around it.
            Whatever the try catch is... In the main, or in the constructor.

            Second, the RFID is a type String, which allows the user in Main to put whatever he wants...
            Not very secure if a unknowledgeable developper tries it, or if you have to explain it to a not developper person
            which could ask the question : "If we put the name of the course... So it's not really a RFID right ?"

            About if my code handle it properly, I'm not used to JUnit system and I apologize for it.
            I tried my own test implementation.
        */

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