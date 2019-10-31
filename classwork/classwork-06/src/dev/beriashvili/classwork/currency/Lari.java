package dev.beriashvili.classwork.currency;

import java.util.HashMap;

public class Lari implements Converter {
    /*
     * დავალების შესრულების პროცესში გამოყენეთ კლასები, ინტერფეისები, პაკეტები.

     * პროგრამას უნდა შეეძლოს სამ ვალუტაში კონვერტაცია ლარში USD, GBP და EUR.
     * მიმდინარე ვალუტის კურსი
     * USD 1.7710 ყიდვა
     * EUR 2.2700 ყიდვა
     * GBP 2.8950 ყიდვა
     * გაითვალისწინეთ, რომ ვალუტის გადამყიდველმა ნებისმიერ დროს უნდა შეძლოს ვალუტის
     * კურსის ცვლილების შეტანა.
     * */
    public HashMap<String, Double> exchangeRates = new HashMap<>();

    public void main() {
        initializeExchangeRates();
    }

    private void initializeExchangeRates() {
        exchangeRates.put("GEL", 1.0000);
        exchangeRates.put("USD", 1.7710);
        exchangeRates.put("EUR", 2.2700);
        exchangeRates.put("GBP", 2.8950);
    }

    @Override
    public double getExchangeRate(String currency) {
        return exchangeRates.get(currency);
    }

    @Override
    public void setExchangeRate(String currency, double rate) {
        exchangeRates.put(currency, rate);
    }

    @Override
    public double convertFromCurrency(String currency, double amount) {
        double rate = exchangeRates.get(currency);

        return rate * amount;
    }

    @Override
    public double convertToCurrency(String currency, double amount) {
        double rate = exchangeRates.get(currency);

        return amount / rate;
    }

    public double convertFromGEL(double amount) {
        return convertFromCurrency("GEL", amount);
    }

    public double convertFromUSD(double amount) {
        return convertFromCurrency("USD", amount);
    }

    public double convertFromEUR(double amount) {
        return convertFromCurrency("EUR", amount);
    }

    public double convertFromGBP(double amount) {
        return convertFromCurrency("GBP", amount);
    }

    public double convertToGEL(double amount) {
        return convertToCurrency("GEL", amount);
    }

    public double convertToUSD(double amount) {
        return convertToCurrency("USD", amount);
    }

    public double convertToEUR(double amount) {
        return convertToCurrency("EUR", amount);
    }

    public double convertToGBP(double amount) {
        return convertToCurrency("GBP", amount);
    }
}
