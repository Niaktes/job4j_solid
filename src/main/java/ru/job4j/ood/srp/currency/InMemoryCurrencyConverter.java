package ru.job4j.ood.srp.currency;

public class InMemoryCurrencyConverter implements CurrencyConverter {

    private static final int CURRENCIES_COUNT = Currency.values().length;
    private static double[][] conversationTable = new double[CURRENCIES_COUNT][CURRENCIES_COUNT];

    public InMemoryCurrencyConverter() {
        this.conversationTable[Currency.RUB.ordinal()][Currency.USD.ordinal()] = 0.014;
        this.conversationTable[Currency.RUB.ordinal()][Currency.EUR.ordinal()] = 0.013;
        this.conversationTable[Currency.USD.ordinal()][Currency.EUR.ordinal()] = 0.93;
        this.conversationTable[Currency.USD.ordinal()][Currency.RUB.ordinal()] = 74D;
        this.conversationTable[Currency.EUR.ordinal()][Currency.USD.ordinal()] = 1.07;
        this.conversationTable[Currency.EUR.ordinal()][Currency.RUB.ordinal()] = 79.3;
        this.conversationTable[Currency.RUB.ordinal()][Currency.RUB.ordinal()] = 1D;
        this.conversationTable[Currency.USD.ordinal()][Currency.USD.ordinal()] = 1D;
        this.conversationTable[Currency.EUR.ordinal()][Currency.EUR.ordinal()] = 1D;
    }

    @Override
    public double convert(Currency source, double sourceValue, Currency target) {
        return sourceValue * conversationTable[source.ordinal()][target.ordinal()];
    }
}
