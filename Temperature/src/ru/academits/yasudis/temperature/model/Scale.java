package ru.academits.yasudis.temperature.model;

public abstract class Scale {
    private static final double LOWEST_TEMPERATURE = 0;
    private static final String SCALE_NAME = null;

    protected String getScaleName() {
        return SCALE_NAME;
    }

    protected double getLowestTemperature() {
        return LOWEST_TEMPERATURE;
    }

    public abstract double convertToKelvin(double temperature);

    public abstract double convertFromKelvin(double kelvinTemperature);

    protected void checkTemperature(double temperature) {
        if (temperature < LOWEST_TEMPERATURE) {
            throw new IllegalArgumentException(String.format(
                    "Температура " + getScaleName() + " должна быть выше чем " + getLowestTemperature() + " градусов."));
        }
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(getLowestTemperature());
        hash = prime * hash + getScaleName().hashCode();

        return hash;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        return o != null && o.getClass() == getClass();
    }

    public String toString() {
        return getScaleName();
    }
}