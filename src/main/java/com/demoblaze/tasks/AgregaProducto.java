package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.HomePage.AGREGAR_AL_CARRITO;

public class AgregaProducto implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(AGREGAR_AL_CARRITO)
        );
    }

        public static AgregaProducto alCarrito() {
            return Tasks.instrumented(AgregaProducto.class);
        }
}
