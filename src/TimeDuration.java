import Throwables.BadBadValueException;

public class TimeDuration {

    private int mTime;

    public TimeDuration(int iTime) throws BadBadValueException {
        if (iTime < 0)
            throw new BadBadValueException("Negative number");
        mTime = iTime;
    }

    public int getTime() {
        return mTime;
    }

    @Override
    public String toString() {
        String oOutput;

        int hours = mTime / 3600;
        int minutes = (mTime % 3600) / 60;
        int seconds = mTime % 60;

        if (hours != 0)
            oOutput = String.format("%dh %dm %ds", hours, minutes, seconds);
        else if (minutes != 0)
            oOutput = String.format("%dm %ds", minutes, seconds);
        else
            oOutput = String.format("%ds", seconds);

        return oOutput;
    }

    public static void runTimeDurationTests() {

        try {
            System.out.println(new TimeDuration(-1).toString());
        } catch (BadBadValueException iE) {
            iE.printStackTrace();
        }
        try {
            System.out.println(new TimeDuration(-432).toString());
        } catch (BadBadValueException iE) {
            iE.printStackTrace();
        }
        try {
            System.out.println(new TimeDuration(0).toString());
        } catch (BadBadValueException iE) {
            iE.printStackTrace();
        }
        try {
            System.out.println(new TimeDuration(1).toString());
        } catch (BadBadValueException iE) {
            iE.printStackTrace();
        }
        try {
            System.out.println(new TimeDuration(50).toString());
        } catch (BadBadValueException iE) {
            iE.printStackTrace();
        }
        try {
            System.out.println(new TimeDuration(100).toString());
        } catch (BadBadValueException iE) {
            iE.printStackTrace();
        }
        try {
            System.out.println(new TimeDuration(10000).toString());
        } catch (BadBadValueException iE) {
            iE.printStackTrace();
        }
    }
}
