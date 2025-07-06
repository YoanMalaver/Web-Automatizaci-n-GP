package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

import java.time.LocalTime;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RedirectionButtonSteps {

    /*
    @When("hace clic en el botón \"Quiero un Toyota\"")
    public void haceClicEnElBotonQuieroUnToyota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Click.on(ToyotaUI.BOTON_QUIERO_UN_TOYOTA)
        );
    }

    @Then("es redirigido a la página de solicitud de Toyota")
    public void esRedirigidoAPaginaSolicitudToyota() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("La URL es la esperada", ToyotaQuestions.urlEsLaDeSolicitud(), equalTo("https://www.toyota.mx/quiero-un-toyota"))
        );
    }


    // Crear un metodo para validar la hora actual*/


}



