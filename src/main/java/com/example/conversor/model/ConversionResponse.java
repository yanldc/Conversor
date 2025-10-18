package com.example.conversor.model;

public class ConversionResponse {
    private String from;
    private String to;
    private double inputValue;
    private double convertedValue;
    private String type; // "currency" ou "unit"

    public ConversionResponse(String from, String to, double inputValue, double convertedValue, String type) {
        this.from = from;
        this.to = to;
        this.inputValue = inputValue;
        this.convertedValue = convertedValue;
        this.type = type;
    }

    // Getters e Setters
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public double getInputValue() { return inputValue; }
    public double getConvertedValue() { return convertedValue; }
    public String getType() { return type; }
}
