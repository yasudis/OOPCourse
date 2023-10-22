package ru.academits.yasudis.temperature.controller;

import ru.academits.yasudis.temperature.model.Converter;
import ru.academits.yasudis.temperature.model.Scale;
import ru.academits.yasudis.temperature.view.View;

public interface Controller {
    void setView(View view);

    void convert(double value, Scale from, Scale to);

    Converter getConverter();
}
