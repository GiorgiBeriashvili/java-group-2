package dev.beriashvili.classwork.currency;

public interface Converter {
    double getExchangeRate(String currency);
    
    void setExchangeRate(String currency, double rate);

    double convertFromCurrency(String currency, double amount);

    double convertToCurrency(String currency, double amount);
}
