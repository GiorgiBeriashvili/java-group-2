package dev.beriashvili.classwork;

import dev.beriashvili.classwork.currency.Lari;

import java.text.DecimalFormat;
import java.util.Map;

class Utils {
    static void main() {
        Lari lari = new Lari();
        lari.main();

        DecimalFormat decimalFormat = new DecimalFormat("0.#####");

        // Getting base currency exchange rates
        for (Map.Entry<String, Double> entry : lari.exchangeRates.entrySet()) {
            String currency = entry.getKey();
            Double rate = entry.getValue();

            System.out.println(String.format("%s's base exchange rate is: %s", currency, decimalFormat.format(rate)));
        }

        double amount = 100;

        // Convert to GEL
        System.out.println("\nConverting to GEL...");
        System.out.println(String.format("%s %s = %s GEL", decimalFormat.format(amount), "GEL", decimalFormat.format(lari.convertFromGEL(amount))));
        System.out.println(String.format("%s %s = %s GEL", decimalFormat.format(amount), "USD", decimalFormat.format(lari.convertFromUSD(amount))));
        System.out.println(String.format("%s %s = %s GEL", decimalFormat.format(amount), "EUR", decimalFormat.format(lari.convertFromEUR(amount))));
        System.out.println(String.format("%s %s = %s GEL", decimalFormat.format(amount), "GBP", decimalFormat.format(lari.convertFromGBP(amount))));

        // Convert from GEL
        System.out.println("\nConverting from GEL...");
        System.out.println(String.format("%s GEL = %s %s", decimalFormat.format(amount), decimalFormat.format(lari.convertToGEL(amount)), "GEL"));
        System.out.println(String.format("%s GEL = %s %s", decimalFormat.format(amount), decimalFormat.format(lari.convertToUSD(amount)), "USD"));
        System.out.println(String.format("%s GEL = %s %s", decimalFormat.format(amount), decimalFormat.format(lari.convertToEUR(amount)), "EUR"));
        System.out.println(String.format("%s GEL = %s %s", decimalFormat.format(amount), decimalFormat.format(lari.convertToGBP(amount)), "GBP"));

        // Get exchange rate
        System.out.println("\nGetting exchange rate...");
        System.out.println(String.format("Exchange rate of USD: %s", decimalFormat.format(lari.getExchangeRate("USD"))));
        System.out.println(String.format("%s %s = %s Lari", decimalFormat.format(amount), "GEL", decimalFormat.format(lari.convertFromUSD(amount))));

        // Set exchange rate
        double exchangeRate = 2.5;

        System.out.println("\nSetting exchange rate...");
        System.out.println(String.format("Setting exchange rate of USD to: %s", decimalFormat.format(exchangeRate)));
        lari.setExchangeRate("USD", exchangeRate);
        System.out.println(String.format("Exchange rate of USD: %s", decimalFormat.format(lari.getExchangeRate("USD"))));
        System.out.println(String.format("%s %s = %s Lari", decimalFormat.format(amount), "GEL", decimalFormat.format(lari.convertFromUSD(amount))));
    }
}
