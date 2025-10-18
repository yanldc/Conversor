package com.example.conversor.service;

import com.example.conversor.exception.NegativeAmountNotAllowedException;
import com.example.conversor.exception.UnsupportedUnitException;

import java.util.Set;

public class ConversionValidator {

    private static final Set<String> SUPPORTED_CURRENCIES = Set.of("USD", "BRL", "EUR");
    private static final Set<String> SUPPORTED_TEMPERATURES = Set.of("C", "F");
    private static final Set<String> SUPPORTED_DISTANCES = Set.of("KM", "MI");
    
    private static final double MAX_CURRENCY_AMOUNT = 1_000_000.0;
    private static final double MAX_UNIT_VALUE = 10_000.0;

    public static void validateCurrency(String from, String to, double amount) {
        if (amount < 0) {
            throw new NegativeAmountNotAllowedException("O valor não pode ser negativo.");
        }
        if (amount > MAX_CURRENCY_AMOUNT) {
            throw new NegativeAmountNotAllowedException("Valor excede o limite máximo de " + MAX_CURRENCY_AMOUNT);
        }
        if (!SUPPORTED_CURRENCIES.contains(from.toUpperCase()) ||
            !SUPPORTED_CURRENCIES.contains(to.toUpperCase())) {
            throw new UnsupportedUnitException("Moeda não suportada: " + from + " ou " + to);
        }
    }

    public static void validateUnit(String from, String to, double value) {
        if (value < 0) {
            throw new NegativeAmountNotAllowedException("O valor não pode ser negativo.");
        }
        if (value > MAX_UNIT_VALUE) {
            throw new NegativeAmountNotAllowedException("Valor excede o limite máximo de " + MAX_UNIT_VALUE);
        }

        boolean tempOk = SUPPORTED_TEMPERATURES.contains(from.toUpperCase()) && SUPPORTED_TEMPERATURES.contains(to.toUpperCase());
        boolean distOk = SUPPORTED_DISTANCES.contains(from.toUpperCase()) && SUPPORTED_DISTANCES.contains(to.toUpperCase());

        if (!tempOk && !distOk) {
            throw new UnsupportedUnitException("Unidade não suportada: " + from + " ou " + to);
        }
    }
}
