package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SearchUi {

    // Buscador
    public static final Target SEARCH = Target.the("Campo de búsqueda")
            .located(By.id("button-57210e227b"));

    public static final Target SEARCH_INPUT = Target.the("Campo de búsqueda")
            .located(By.xpath("//input[@type='text' and @placeholder='¿Qué estás buscando?']"));

    public static final Target LINK_HIBRIDO = Target.the("Link ¿Por qué híbrido?")
            .located(By.xpath("//a[contains(text(),'¿Por qué híbrido?')]"));

    // (//a[span[normalize-space(text())='Quiero un Toyota']])[6]
    public static final Target LINK_QUER_UN_TOYOTA = Target.the("Link Quiero un Toyota")
            .located(By.xpath("(//a[span[normalize-space(text())='Quiero un Toyota']])[6]"));

    public static final Target SECTION_CONTACT_INFO = Target.the("Sección Información de Contacto")
        .located(By.xpath("//div[@class='section-heading' and normalize-space(text())='Información de Contacto']"));

    // //span[@class='cmp-navigation__item-title' and normalize-space(text())='Servicio']
    public static final Target LINK_SERVICIO = Target.the("Link Servicio")
            .located(By.xpath("//span[@class='cmp-navigation__item-title' and normalize-space(text())='Servicio']"));


}
