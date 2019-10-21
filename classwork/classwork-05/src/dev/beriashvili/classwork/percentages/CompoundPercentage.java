package dev.beriashvili.classwork.percentages;

public class CompoundPercentage implements Calculator {
    /*
     * დაწერეთ რთული პროცენტის გამოსათვლელი პროგრამა. მოცემულია ოთხი მონაცემი
     * p - საწყისი თანხა,
     * n - წლების რაოდენობა,
     * q - საბოლოო თანხა.
     * k - პროცენტების რაოდენობა.
     * დანარჩენი სამი სიდიდის მიხედვით გამოთვალეთ მეოთხე.
     * */
    @Override
    public String getPercentage(double initialCapital, double yearsPassed, double closingCapital) {
        double compoundPercentage = ((Math.pow(closingCapital / initialCapital, 1 / yearsPassed) - 1) * 100);

        return String.format("Complex percentage from initial capital of %.2f, %.2f passed years and closing capital of %.2f: %.2f%%", initialCapital, yearsPassed, closingCapital, compoundPercentage);
    }
}
