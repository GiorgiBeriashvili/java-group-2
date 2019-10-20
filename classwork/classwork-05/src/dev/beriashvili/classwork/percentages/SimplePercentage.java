package dev.beriashvili.classwork.percentages;

public class SimplePercentage implements Calculator {
    /*
     * დაწერეთ მარტივი პროცენტის გამოსათვლელი პროგრამა. მოცემულია ოთხი მონაცემი
     * p - საწყისი თანხა,
     * n - წლების რაოდენობა,
     * q - საბოლოო თანხა.
     * k - პროცენტების რაოდენობა.
     * დანარჩენი სამი სიდიდის მიხედვით გამოთვალეთ მეოთხე.
     * */
    @Override
    public String getPercentage(double initialCapital, double yearsPassed, double closingCapital) {
        double simplePercentage = ((closingCapital - initialCapital) / (yearsPassed * initialCapital)) * 100;

        return String.format("Simple percentage from initial capital of %.2f, %.2f passed years and closing capital of %.2f: %.2f%%", initialCapital, yearsPassed, closingCapital, simplePercentage);
    }
}
