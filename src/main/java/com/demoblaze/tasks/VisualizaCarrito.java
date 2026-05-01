package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.HomePage.VER_CARRITO;

public class VisualizaCarrito implements Task{
    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(VER_CARRITO)
        );
    }

    public static VisualizaCarrito deCompras() {
        return new VisualizaCarrito();
    }
}
