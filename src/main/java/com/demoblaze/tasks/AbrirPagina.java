package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;


public class AbrirPagina implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().thePageNamed("webdriver.base.url")
        );
    }


    public static AbrirPagina laPaginaDeInicio() {
        return Tasks.instrumented(AbrirPagina.class);
    }
}