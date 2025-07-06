package questions;

import net.serenitybdd.screenplay.Question;
import ui.ToyotaUI;

public class ToyotaQuestions {

    public static Question<String> vehicleExpect() {
        return actor -> ToyotaUI.VEHICLE_EXPECT.resolveFor(actor).getText().trim();
    }

    public static Question<String> cardPrice() {
        return actor -> ToyotaUI.CARD_PRICE.resolveFor(actor).getText().trim();
    }

    public static Question<String> buttonQuote() {
        return actor -> ToyotaUI.BUTTON_QUOTE.resolveFor(actor).getText().trim();
    }

}
