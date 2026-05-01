package com.demoblaze.stepdefinitions;

import com.demoblaze.interactions.AceptarAlerta;
import com.demoblaze.models.DatosClienteModel;
import com.demoblaze.questions.ValidaCompraExitosa;
import com.demoblaze.tasks.*;
import com.demoblaze.utilidades.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;

public class StepRealizarCompra {

    @Given("El usuario esta en la pagina de inicio de demoblaze")
    public void elUsuarioEstaEnLaPaginaDeInicioDeDemoblaze() {
        OnStage.theActorInTheSpotlight().wasAbleTo(AbrirPagina.laPaginaDeInicio());

    }

    @When("El usuario selecciona el producto")
    public void elUsuarioSeleccionaElProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionaProducto.samsungGalaxy()
        );

    }

    @When("El usuario agrega el producto al carrito")
    public void elUsuarioAgregaElProductoAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregaProducto.alCarrito(),
                AceptarAlerta.deJavaScript()
        );

    }

    @When("El usuario va al carrito y visualiza el producto agregado")
    public void elUsuarioVaAlCarritoYVisualizaElProductoAgregado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VisualizaCarrito.deCompras());

    }

    @When("El usuario realiza el pedido y llena formulario de compra con los siguientes datos:")
    public void elUsuarioRealizaElPedidoYLlenaFormularioDeCompraConLosSiguientesDatos(DatosClienteModel datoscliente) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RealizaPedido.deCompra(datoscliente)
        );

    }

    @Then("Deberia ver un mensaje de confirmacion de compra exitosa")
    public void deberiaVerUnMensajeDeConfirmacionDeCompraExitosa() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El mensaje de compra exitosa", ValidaCompraExitosa.mensajeCompraExitosa(),
                        is(in(Constantes.MENSAJES_EXITO_COMPRA)))

        );
    }

}
