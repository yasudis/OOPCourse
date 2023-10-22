package ru.academits.yasudis.temperature_main;

import ru.academits.yasudis.temperature.model.*;
import ru.academits.yasudis.temperature.controller.TemperatureController;
import ru.academits.yasudis.temperature.view.View;
import ru.academits.yasudis.temperature.view.DesktopView;

public class Main {
    public static void main(String[] args) {
        Scale[] scales = {
                new FahrenheitScale(),
                new CelsiusScale(),
                new KelvinScale(),
        };

        Converter temperatureConverter = new TemperatureConverter(scales);
        TemperatureController controller = new TemperatureController(temperatureConverter);
        View view = new DesktopView(controller);

        controller.setView(view);
        view.start();
    }
}