package com.demoblaze.tasks;

import com.demoblaze.ui.HomePage;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionaProducto implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.SAMSUNG_GALAXY)
        );
    }

    public static SeleccionaProducto samsungGalaxy() {
        return Tasks.instrumented(SeleccionaProducto.class);

    }
}
