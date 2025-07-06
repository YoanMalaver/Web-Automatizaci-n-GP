package stepDefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.SauceDemoQuestions;
import tasks.SauceDemoTask;
import ui.SauceDemoUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static org.hamcrest.Matchers.equalTo;

public class MsjsAndButtonContinueShoppingSteps {

    @When("elimino el producto del carrito de compras")
    public void eliminoProductoDelCarrito() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                SauceDemoTask.clickCartIcon(),
                SauceDemoTask.removeProductFromCart()
        );
    }

    @Then("valido el mensaje {string} y el botón {string}")
    public void validoMensajeYBoton(String message, String buttonText) {

        OnStage.theActorInTheSpotlight().should(
                seeThat("Mensaje: ", SauceDemoQuestions.emptyCartMessage(),  equalTo(message))
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                SauceDemoTask.continueShopping(buttonText),
                WaitUntil.the(SauceDemoUI.SHOPPING_CART_TITLE, isNotCurrentlyVisible()).forNoMoreThan(10).seconds()
        );

    }
}
