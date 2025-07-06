package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ToyotaUI {

    public static final Target OPTION_TOOLS = Target.the("Option Tools")
            .located(By.xpath("//span[.='Herramientas de compra']"));

    public static final Target OPTION_QUOTE = Target.the("Option Quote")
            .located(By.xpath("//span[contains(text(),'Cotizar')]"));

    public static final Target TITLE = Target.the("Title")
            .located(By.xpath("//div[contains(text(),'Escoge tu Toyota')]"));

    public static final Target LIST_MODEL = Target.the("Vehicle Model")
            .located(By.id("vehiculo"));

    public static final Target MODEL_AVANZA = Target.the("Vehicle Model")
            .located(By.xpath("//div[@class='model-info section']//span[.='Avanza']"));

    public static final Target LIST_VERSION = Target.the("Vehicle Version")
            .located(By.id("version"));

    public static final Target VERSION_AVANZA = Target.the("Vehicle Version")
            .located(By.xpath("//li[contains(.,'Avanza LE MT')]"));

    // Asersions

    public static final Target VEHICLE_EXPECT = Target.the("Titulo vehiculo esperado")
            .located(By.className("card__title"));

    public static final Target CARD_PRICE = Target.the("Card Price")
            .located(By.className("card__price-wrapper"));

    public static final Target BUTTON_QUOTE = Target.the("Button Quote")
            .located(By.id("details-anchor"));

    // Dinamico

    public static final Target SELECT_MODEL (String expectText) {
        return Target.the("Selecciona el modelo")
                .located(org.openqa.selenium.By.xpath("//div[@class='model-info section']//span[.='" + expectText + "']"));
    }
    public static final Target SELECT_VERSION (String expectText) {
        return Target.the("Selecciona la version")
                .located(org.openqa.selenium.By.xpath("//div[@class='model-info section']//span[.='" + expectText + "']"));
    }

    // Alert
    public static final Target BUTTON_ALERT = Target.the("Button Alert")
            .located(By.xpath("//a[contains(text(), \"ENTENDIDO\")]"));

    // Buscador
    public static final Target SEARCH = Target.the("Campo de búsqueda")
            .located(By.id("button-57210e227b"));

    public static final Target SEARCH_INPUT = Target.the("Campo de búsqueda")
        .located(By.xpath("//input[@type='text' and @placeholder='¿Qué estás buscando?']"));

    public static final Target LINK_HIBRIDO = Target.the("Link ¿Por qué híbrido?")
        .located(By.xpath("//a[contains(text(),'¿Por qué híbrido?')]"));

}
