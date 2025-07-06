package stepDefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ToyotaQuestions;
import tasks.ToyotaTask;
import ui.ToyotaUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.equalTo;

public class TotoyaSearchVehicleSteps {

    @Given("^(.*) accede a la pagina de Toyota$")
    public void accedeURL(String actor) {
        theActorCalled(actor).attemptsTo(
                Open.browserOn().thePageNamed("pages.Toyota")
        );
        if(isPresent().matches(ToyotaUI.BUTTON_ALERT.resolveFor(theActorInTheSpotlight()))) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Click.on(ToyotaUI.BUTTON_ALERT)
            );
        }
    }

    @And("accede a {string} seleccionando {string}")
    public void selectTools(String tools, String quote) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ToyotaTask.ingressQuote()
        );

    }
    @When("^ingresa (.*) y (.*)$")
    public void seleccionaCotizar(String model, String version) {
        theActorInTheSpotlight().remember("version", version);

        OnStage.theActorInTheSpotlight().attemptsTo(
                ToyotaTask.selectModel(model),
                ToyotaTask.selectVersion(version)
        );

    }
    @Then("^se debe visualizar el modelo seleccionado (.*) del modelo y acceso al detalle$")
    public void expectResult(String amount) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ToyotaTask.scrollButton(theActorInTheSpotlight().recall("version"))
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("El modelo seleccionado es", ToyotaQuestions.vehicleExpect(), equalTo(theActorInTheSpotlight().recall("version"))),
                seeThat("El modelo seleccionado es", ToyotaQuestions.cardPrice(), equalTo(amount))
        );

    }

}
