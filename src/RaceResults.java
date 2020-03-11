import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RaceResults {

    private List<Arrival> mArrivals;

    public RaceResults() {
        mArrivals = new ArrayList<>();
    }

    public void onNewResult(String iTagNumber, TimeDuration iResultTime) {
        mArrivals.add(new Arrival(iTagNumber, iResultTime));
    }

    public void printResults() {

        mArrivals.sort(new Comparator<Arrival>() {
            @Override
            public int compare(Arrival o1, Arrival o2) {

                if (o1.mTimeDuration.getTime() < o2.mTimeDuration.getTime())
                    return 0;
                else if (o1.mTimeDuration.getTime() > o2.mTimeDuration.getTime())
                    return 1;
                return 0;
            }
        });

        StringBuilder oResult = new StringBuilder("Results :\n");
        int lPlace = 0;
        for (Arrival lItem : mArrivals) {
            oResult.append("#").append(lPlace).append(lItem.mRFID).append("(").append(lItem.mTimeDuration.toString()).append(")\n");
        }
        System.out.print(oResult.toString());
    }


    private static class Arrival {
        String mRFID;
        TimeDuration mTimeDuration;

        public Arrival(String iRFID, TimeDuration iTimeDuration) {
            mRFID = iRFID;
            mTimeDuration = iTimeDuration;
        }
    }
}
