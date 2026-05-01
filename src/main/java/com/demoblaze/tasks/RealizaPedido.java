package com.demoblaze.tasks;

import com.demoblaze.models.DatosClienteModel;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demoblaze.ui.CartPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizaPedido implements Task {
    private final DatosClienteModel datosCliente;

    public RealizaPedido(DatosClienteModel datosCliente) {
        this.datosCliente = datosCliente;
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_REALIZAR_PEDIDO),
                WaitUntil.the(NOMBRE, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(datosCliente.getNombre()).into(NOMBRE),
                Enter.theValue(datosCliente.getPais()).into(PAIS),
                Enter.theValue(datosCliente.getCiudad()).into(CIUDAD),
                Enter.theValue(datosCliente.getTarjeta()).into(TARJETA_CREDITO),
                Enter.theValue(datosCliente.getMes()).into(MES),
                Enter.theValue(datosCliente.getAnio()).into(ANIO),
                Click.on(BOTON_COMPRA)
        );
        System.out.println("MENSAJE EXITOSO pppp" +MENSAJE_COMPRA_EXITOSA.resolveFor(actor).getText());
    }

    public static RealizaPedido deCompra(DatosClienteModel datosCliente) {
        return Tasks.instrumented(RealizaPedido.class, datosCliente);
    }
}
