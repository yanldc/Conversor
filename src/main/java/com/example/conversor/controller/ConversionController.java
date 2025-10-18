package com.example.conversor.controller;

import com.example.conversor.model.ConversionResponse;
import com.example.conversor.service.CurrencyConversionService;
import com.example.conversor.service.UnitConversionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
public class ConversionController {

    private final CurrencyConversionService currencyService;
    private final UnitConversionService unitService;

    public ConversionController(CurrencyConversionService currencyService, UnitConversionService unitService) {
        this.currencyService = currencyService;
        this.unitService = unitService;
    }

    @GetMapping("/currency")
    public ConversionResponse convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
        return currencyService.convert(from, to, amount);
    }

    @GetMapping("/unit/temperature")
    public ConversionResponse convertTemperature(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double value) {
        return unitService.convertTemperature(from, to, value);
    }

    @GetMapping("/unit/distance")
    public ConversionResponse convertDistance(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double value) {
        return unitService.convertDistance(from, to, value);
    }
}
