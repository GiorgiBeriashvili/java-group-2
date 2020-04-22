package ge.edu.btu.giorgi.beriashvili.covid.models;

import java.util.ArrayList;

public class CovidStatistics {
    public static ArrayList<Covid> get() {
        ArrayList<Covid> statistics = new ArrayList<>();

        statistics.add(new Covid("US", 760245, 40702, 71003));
        statistics.add(new Covid("Spain", 200210, 166256, 635895));
        statistics.add(new Covid("Italy", 178972, 23660, 51003));

        return statistics;
    }
}
