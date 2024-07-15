package main.java;
public class CurrencyConverter {
    private final CurrencyRates currencyRates;

    public CurrencyConverter(CurrencyRates currencyRates) {
        this.currencyRates = currencyRates;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = currencyRates.getRate(fromCurrency);
        double toRate = currencyRates.getRate(toCurrency);
        return (amount / fromRate) * toRate;
    }
}