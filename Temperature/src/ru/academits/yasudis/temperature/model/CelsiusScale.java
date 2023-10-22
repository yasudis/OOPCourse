package ru.academits.yasudis.temperature.model;

public class CelsiusScale extends Scale {
    private static final double LOWEST_TEMPERATURE = -273.15;
    private static final String SCALE_NAME = "Цельсия";

    @Override
    protected String getScaleName() {
        return SCALE_NAME;
    }

    @Override
    protected double getLowestTemperature() {
        return LOWEST_TEMPERATURE;
    }

    @Override
    public double convertToKelvin(double celsiusTemperature) {
        checkTemperature(celsiusTemperature);

        return celsiusTemperature - getLowestTemperature();
    }

    @Override
    public double convertFromKelvin(double kelvinTemperature) {
        return kelvinTemperature + getLowestTemperature();
    }
}