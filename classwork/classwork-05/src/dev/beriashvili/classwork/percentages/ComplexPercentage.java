package dev.beriashvili.classwork.percentages;

public class ComplexPercentage implements Calculator {
    /*
     * დაწერეთ რთული პროცენტის გამოსათვლელი პროგრამა. მოცემულია ოთხი მონაცემი
     * p - საწყისი თანხა,
     * n - წლების რაოდენობა,
     * q - საბოლოო თანხა.
     * k - პროცენტების რაოდენობა.
     * დანარჩენი სამი სიდიდის მიხედვით გამოთვალეთ მეოთხე.
     * */
    @Override
    public String getPercentage(double initialCapital, int yearsPassed, double closingCapital) {
        if (initialCapital < closingCapital) {
            return String.format("After %d years, initial capital of %.0f has risen to %.0f with a %.0f%% increase!", yearsPassed, initialCapital, closingCapital, Math.round(closingCapital - initialCapital) / initialCapital * 100);
        } else if (initialCapital > closingCapital) {
            return String.format("After %d years, initial capital of %.0f has fallen to %.0f with a %.0f%% decrease!", yearsPassed, initialCapital, closingCapital, Math.round(initialCapital - closingCapital) / closingCapital * 100);
        } else {
            return String.format("After %d years, initial capital of %.0f has remained the same.", yearsPassed, initialCapital);
        }
    }
}
