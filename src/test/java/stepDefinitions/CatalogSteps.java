package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.SauceDemoQuestions;
import tasks.SauceDemoTask;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CatalogSteps {

    // crea el snnipet When valido los productos del catálogo
    @When("^valido los productos del catálogo$")
    public void validateCatalog() {

    }

    // crea el snnipet Then valido que los productos del catálogo sean correctos
    @When("^valido que los productos del catálogo sean correctos$")
    public void validateCatalogProducts(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        rows.forEach(row -> {
            String expectedName = row.get("Producto");
            String expectedPrice = row.get("Valor");

            OnStage.theActorInTheSpotlight().should(
                    seeThat("El nombre del producto", SauceDemoQuestions.productNames(), containsString(expectedName)),
                    seeThat("El precio del producto", SauceDemoQuestions.productPrices(), containsString(expectedPrice))
            );
        });
    }

    @When("^valido el (.*) y ().* los productos del catálogo sean correctos$")
    public void validateCatalogProducts(String productName, String productPrice) {

        OnStage.theActorInTheSpotlight().should(
                seeThat("El nombre del producto", SauceDemoQuestions.productNames(), containsString(productName)),
                seeThat("El precio del producto", SauceDemoQuestions.productPrices(), containsString(productPrice))
        );
    }
}
