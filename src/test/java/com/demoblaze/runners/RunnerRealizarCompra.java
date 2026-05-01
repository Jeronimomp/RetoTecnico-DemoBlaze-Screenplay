package com.demoblaze.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/ComprarProducto.feature",
        glue = {
                "com.demoblaze.stepdefinitions",
                "com.demoblaze.hooks"
        },
        plugin = {
                "pretty",
                "json:target/cucumber-reports/realizarCompra.json"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerRealizarCompra {
}