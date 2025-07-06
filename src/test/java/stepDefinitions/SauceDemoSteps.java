package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matcher;
import questions.SauceDemoQuestions;
import tasks.SauceDemoTask;
import ui.SauceDemoUI;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class SauceDemoSteps {

    @Given("^(.*) en la página de SauceDemo$")
    public void onPage(String actor) {
        theActorCalled(actor).attemptsTo(
                Open.browserOn().thePageNamed("pages.SauceDemo")
        );
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void logIn(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SauceDemoTask.logIn(username, password)
        );
    }

    @When("^agrego (.*) productos al carrito de compras$")
    public void addProductsToCart(int value) throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SauceDemoTask.selectProducts(SauceDemoUI.BOTONES_ADD_TO_CART, SauceDemoUI.NOMBRES_PRODUCTOS, SauceDemoUI.PRECIOS_PRODUCTOS, value),
                SauceDemoTask.validateProductsInCart(String.valueOf(value))
        );
    }

    @Then("^valido que los productos se hayan agregado correctamente al carrito de compras$")
    public void validateProducts() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SauceDemoTask.clickCartIcon()
        );

        List<String> nombres = OnStage.theActorInTheSpotlight().recall("nombresProductos");
        List<String> precios = OnStage.theActorInTheSpotlight().recall("preciosProductos");

        for (int i = 0; i < nombres.size(); i++) {
            String nombre = nombres.get(i);
            String precio = precios.get(i);

            OnStage.theActorInTheSpotlight().should(
                    seeThat("Nombre del Producto", SauceDemoQuestions.products(nombre), equalTo(true)),
                    seeThat("Valor: ", SauceDemoQuestions.priceInCart(precio), equalTo(true))
            );
        }
    }

    @When("^Valido el total de productos en el carrito de compras$")
    public void validateTotal() throws InterruptedException {

        List<String> precios = OnStage.theActorInTheSpotlight().recall("preciosProductos");


        double total = precios.stream()
                .mapToDouble(precio -> Double.parseDouble(precio.replace("$", "")))
                .sum();

        System.out.println("Total: $" + String.format("%.2f", total));

        OnStage.theActorInTheSpotlight().should(
                seeThat("Valor: ", SauceDemoQuestions.totalPrice(String.format("%.2f", total)), containsString(String.format("%.2f", total))));

    }


}
