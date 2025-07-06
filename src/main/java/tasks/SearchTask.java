package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.SearchUi;
import ui.ToyotaUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchTask {

    public static Performable clickSearch() {
        return Task.where(
                "{0} clic en la lupa de búsqueda",
                WaitUntil.the(SearchUi.SEARCH, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(SearchUi.SEARCH)
        );
    }

    //Ingresa el texto SEARCH_INPUT
    public static Performable ingressText(String text) {
        return Task.where(
                "{0} ingresa el texto en el campo de búsqueda",
                WaitUntil.the(SearchUi.SEARCH_INPUT, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(SearchUi.SEARCH_INPUT),
                Scroll.to(SearchUi.SEARCH_INPUT),
                Enter.theValue(text).into(SearchUi.SEARCH_INPUT)
        );
    }

}
