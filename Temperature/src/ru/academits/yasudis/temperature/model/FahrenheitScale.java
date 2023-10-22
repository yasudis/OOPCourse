package ru.academits.yasudis.temperature.model;

public class FahrenheitScale extends Scale {
    private static final double LOWEST_TEMPERATURE = -459.67;
    private static final String SCALE_NAME = "Фаренгейт";

    @Override
    protected String getScaleName() {
        return SCALE_NAME;
    }

    @Override
    protected double getLowestTemperature() {
        return LOWEST_TEMPERATURE;
    }

    @Override
    public double convertToKelvin(double fahrenheitTemperature) {
        checkTemperature(fahrenheitTemperature);

        return (fahrenheitTemperature - getLowestTemperature()) / 1.8;
    }

    @Override
    public double convertFromKelvin(double kelvinTemperature) {
        return 1.8 * kelvinTemperature + getLowestTemperature();
    }
}