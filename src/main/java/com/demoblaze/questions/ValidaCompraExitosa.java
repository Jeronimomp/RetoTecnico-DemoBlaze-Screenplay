package com.demoblaze.questions;

import com.demoblaze.ui.CartPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

public class ValidaCompraExitosa implements Question <String> {

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(CartPage.MENSAJE_COMPRA_EXITOSA).answeredBy(actor).trim();
    }

    public static ValidaCompraExitosa mensajeCompraExitosa() {
        return new ValidaCompraExitosa();
    }
}
