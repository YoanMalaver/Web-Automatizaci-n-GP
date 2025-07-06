package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import ui.ToyotaUI;

public class ToyotaTask {

    public static Performable ingressQuote() {
        return Task.where(
                "{0} busca un vehículo",
                Click.on(ToyotaUI.OPTION_TOOLS),
                Click.on(ToyotaUI.OPTION_QUOTE),
                Scroll.to(ToyotaUI.TITLE)
        );
    }
    // selecciona el modelo del vehículo
    public static Performable selectModel(String model) {
        return Task.where(
                "{0} selecciona el modelo del vehículo",
                Click.on(ToyotaUI.LIST_MODEL),
                Click.on(ToyotaUI.SELECT_MODEL(model))
        );
    }
    // Selecciona la versión del vehículo
    public static Performable selectVersion(String version) {
        return Task.where(
                "{0} selecciona la versión del vehículo",
                Click.on(ToyotaUI.LIST_VERSION),
                Click.on(ToyotaUI.SELECT_VERSION(version))
        );
    }

    // scroll to the button Version
    public static Performable scrollButton(String expectVersion) {
        return Task.where(
                "{0} scroll to the button Version",
                Scroll.to(ToyotaUI.SELECT_VERSION(expectVersion))
        );
    }
}
