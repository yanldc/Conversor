package com.example.conversor.service;

import com.example.conversor.exception.ConversionRateNotFoundException;
import com.example.conversor.model.ConversionResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyConversionService {

    // Taxas fixas de exemplo (em produção, buscaria de API externa)
    private static final Map<String, Double> RATES_TO_USD = Map.of(
            "USD", 1.0,
            "BRL", 0.18,
            "EUR", 1.1
    );

    public ConversionResponse convert(String from, String to, double amount) {
        ConversionValidator.validateCurrency(from, to, amount);

        Double fromRate = RATES_TO_USD.get(from.toUpperCase());
        Double toRate = RATES_TO_USD.get(to.toUpperCase());

        if (fromRate == null || toRate == null) {
            throw new ConversionRateNotFoundException("Taxa de conversão não encontrada.");
        }

        double valueInUsd = amount / fromRate;
        double converted = valueInUsd * toRate;

        return new ConversionResponse(from.toUpperCase(), to.toUpperCase(), amount, converted, "currency");
    }
}
