package com.demoblaze.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

public class Principal {

    @Managed
    WebDriver driver;

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast()) ;
        OnStage.theActorCalled("cliente");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));

    }

    @After
    public void cerrarNavegador(){
        driver.quit();
    }
}
