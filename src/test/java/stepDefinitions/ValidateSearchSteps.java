package stepDefinitions;

import exceptions.CaseFailedException;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.SearchQuestions;
import tasks.SearchTask;
import ui.ToyotaUI;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.core.IsEqual.equalTo;

public class ValidateSearchSteps {

    @When("^seleciona la lupa de Busqueda$")
    public void selectSearch() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchTask.clickSearch()
        );
    }


    @And("Ingresa el texto {string}")
    public void ingressText(String text) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchTask.ingressText(text)
        );

    }

    @Then("se debe visualizar en las opciones sugeridas")
    public void viewOptions(List<String> options) {

        if(isPresent().matches(ToyotaUI.LINK_HIBRIDO.resolveFor(OnStage.theActorInTheSpotlight()))) {
            OnStage.theActorInTheSpotlight().should(
                    seeThat("Se Contiene el texto ", SearchQuestions.linkHibrid(), equalTo(options.get(0))),
                    seeThat("Se visualiza/esta presente", SearchQuestions.linkHibridBoolean(), equalTo(true))
            );
        } else {
            throw new CaseFailedException("No se presenta la opción de búsqueda esperada: " + options.get(0));
        }


    }


}
