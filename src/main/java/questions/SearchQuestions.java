package questions;

import net.serenitybdd.screenplay.Question;
import ui.ToyotaUI;

public class SearchQuestions {


    public static Question<String> linkHibrid() {
        return actor -> ToyotaUI.LINK_HIBRIDO.resolveFor(actor).getText().trim();
    }

    public static Question<Boolean> linkHibridBoolean() {
        return actor -> ToyotaUI.LINK_HIBRIDO.resolveFor(actor).isCurrentlyVisible();
    }
}
