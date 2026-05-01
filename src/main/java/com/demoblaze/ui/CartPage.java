package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target BOTON_REALIZAR_PEDIDO= Target.the("Realizar pedido").locatedBy("//button[@class='btn btn-success']");
    public static final Target NOMBRE= Target.the("Nombre").locatedBy("//input[@id='name']");
    public static final Target PAIS= Target.the("Pais").locatedBy("//input[@id='country']");
    public static final Target CIUDAD= Target.the("Ciudad").locatedBy("//input[@id='city']");
    public static final Target TARJETA_CREDITO= Target.the("Trjeta").locatedBy("//input[@id='card']");
    public static final Target MES= Target.the("Mes").locatedBy("//input[@id='month']");
    public static final Target ANIO= Target.the("Anio").locatedBy("//input[@id='year']");
    public static final Target BOTON_COMPRA= Target.the("Botón Compra").locatedBy("//button[@onclick='purchaseOrder()']");
    public static final Target MENSAJE_COMPRA_EXITOSA= Target.the("Compra exitosa").locatedBy("(//h2)[3]");
}
