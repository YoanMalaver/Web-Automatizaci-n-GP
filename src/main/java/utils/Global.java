package utils;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class Global {
    public static Question<List<String>> OptionsList(Target selectTarget) {
        return actor -> {
            WebElement selectWebElement = selectTarget.resolveFor(actor);
            List<WebElement> optionElements = selectWebElement.findElements(By.tagName("option"));

            List<String> nationalityOptions = optionElements.stream()
                    .map(WebElement::getText)
                    .peek(option -> System.out.println("Lista de Opciones " + option))
                    .collect(Collectors.toList());

            return nationalityOptions;
        };
    }

}
