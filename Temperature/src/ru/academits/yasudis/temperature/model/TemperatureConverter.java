package ru.academits.yasudis.temperature.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TemperatureConverter implements Converter {
    private final Scale[] scales;

    public TemperatureConverter(Scale[] scales) {
        if (scales == null) {
            throw new NullPointerException("Количество шкал в массиве не должно быть пустым.");
        }

        if (scales.length < 2) {
            throw new IllegalArgumentException(
                    "Количество шкал в массиве должно быть больше 1: количество шкал = " + scales.length + "."
            );
        }

        Set<Scale> uniqueScales = new HashSet<>();

        for (Scale scale : scales) {
            if (!uniqueScales.add(scale)) {
                throw new IllegalArgumentException(
                        "В шкалах аргументов конструктора есть дубликат: \"" + scale + "\" шкала найдена более одного раза"
                );
            }
        }

        this.scales = Arrays.copyOf(scales, scales.length);
    }

    @Override
    public Scale[] getScales() {
        return scales;
    }

    @Override
    public double convertTemperature(double temperature, Scale from, Scale to) {
        return to.convertFromKelvin(from.convertToKelvin(temperature));
    }
}