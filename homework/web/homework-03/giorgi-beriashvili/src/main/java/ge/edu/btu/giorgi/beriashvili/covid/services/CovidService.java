package ge.edu.btu.giorgi.beriashvili.covid.services;

import ge.edu.btu.giorgi.beriashvili.covid.models.Covid;
import ge.edu.btu.giorgi.beriashvili.covid.models.CovidStatistics;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public class CovidService {
    @WebMethod
    public ArrayList<Covid> getCovidStatistics() {
        return CovidStatistics.get();
    }

    @WebMethod
    public Covid getCountryStatistics(String country) {
        for (Covid covid : CovidStatistics.get()) {
            if (covid.getCountry().equals(country)) {
                return covid;
            }
        }

        return new Covid();
    }

    @WebMethod
    public int getTotalConfirmed() {
        int total = 0;

        for (Covid covid : CovidStatistics.get()) {
            total += covid.getConfirmed();
        }

        return total;
    }

    @WebMethod
    public int getTotalDeaths() {
        int total = 0;

        for (Covid covid : CovidStatistics.get()) {
            total += covid.getDeaths();
        }

        return total;
    }

    @WebMethod
    public int getTotalRecoveries() {
        int total = 0;

        for (Covid covid : CovidStatistics.get()) {
            total += covid.getRecovered();
        }

        return total;
    }
}
