package com.demoblaze.ui;


import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target SAMSUNG_GALAXY= Target.the("Samsumg Galaxy S6").locatedBy("(//a[@href='prod.html?idp_=1'])[1]");
    public static final Target AGREGAR_AL_CARRITO= Target.the("Agregar al carrito").locatedBy("//a[@onclick='addToCart(1)']");
    public static final Target VER_CARRITO= Target.the("Ver carrito").locatedBy("//a[@id='cartur']");

}
