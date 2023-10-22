package ru.academits.yasudis.temperature.model;

public class KelvinScale extends Scale {
    private static final double LOWEST_TEMPERATURE = 0;
    private static final String SCALE_NAME = "Кельвина";

    @Override
    protected String getScaleName() {
        return SCALE_NAME;
    }

    protected double getLowestTemperature() {
        return LOWEST_TEMPERATURE;
    }

    @Override
    public double convertToKelvin(double kelvinTemperature) {
        checkTemperature(kelvinTemperature);

        return kelvinTemperature;
    }

    @Override
    public double convertFromKelvin(double kelvinTemperature) {
        return kelvinTemperature;
    }
}