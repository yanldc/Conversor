package com.example.conversor.service;

import com.example.conversor.model.ConversionResponse;
import org.springframework.stereotype.Service;

@Service
public class UnitConversionService {

    public ConversionResponse convertTemperature(String from, String to, double value) {
        ConversionValidator.validateUnit(from, to, value);

        double result;

        if (from.equalsIgnoreCase("C") && to.equalsIgnoreCase("F")) {
            result = (value * 9/5) + 32;
        } else if (from.equalsIgnoreCase("F") && to.equalsIgnoreCase("C")) {
            result = (value - 32) * 5/9;
        } else {
            result = value; // mesma unidade
        }

        return new ConversionResponse(from.toUpperCase(), to.toUpperCase(), value, result, "temperature");
    }

    public ConversionResponse convertDistance(String from, String to, double value) {
        ConversionValidator.validateUnit(from, to, value);

        double result;
        if (from.equalsIgnoreCase("KM") && to.equalsIgnoreCase("MI")) {
            result = value * 0.621371;
        } else if (from.equalsIgnoreCase("MI") && to.equalsIgnoreCase("KM")) {
            result = value / 0.621371;
        } else {
            result = value;
        }

        return new ConversionResponse(from.toUpperCase(), to.toUpperCase(), value, result, "distance");
    }
}
