package tasks;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import ui.SauceDemoUI;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class SauceDemoTask {

    public static Performable logIn(String username, String password) {
        return Task.where(
                "User logs in to Sauce Demo",
                Enter.theValue(username).into(SauceDemoUI.USERNAME_INPUT),
                Enter.theValue(password).into(SauceDemoUI.PASSWORD_INPUT),
                Click.on(SauceDemoUI.SIGN_IN_BUTTON),
                WaitUntil.the(SauceDemoUI.LOGOUT_BUTTON, isCurrentlyVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Performable selectProducts(Target botonesAddToCart, Target nombreProducto, Target precioProducto, int cantidad) {
        return Task.where("selecciona " + cantidad + " productos y obtiene sus datos",
            actor -> {
                ListOfWebElementFacades buttons = botonesAddToCart.resolveAllFor(actor);
                if (cantidad > buttons.size()) {
                    throw new IllegalArgumentException("La cantidad solicitada excede el número de productos disponibles.");
                }
                Random random = new Random();
                List<Integer> indicesSeleccionados = new java.util.ArrayList<>();
                while (indicesSeleccionados.size() < cantidad) {
                    int index = random.nextInt(buttons.size());
                    if (!indicesSeleccionados.contains(index)) {
                        indicesSeleccionados.add(index);
                        buttons.get(index).click();
                    }
                }
                List<String> nombres = new java.util.ArrayList<>();
                List<String> precios = new java.util.ArrayList<>();
                for (int index : indicesSeleccionados) {
                    nombres.add(nombreProducto.resolveAllFor(actor).get(index).getText());
                    precios.add(precioProducto.resolveAllFor(actor).get(index).getText());
                }
                actor.remember("nombresProductos", nombres);
                actor.remember("preciosProductos", precios);
            }
        );
    }

    public static Performable validateProductsInCart(String expectedCount) {
        return Task.where("valida que los productos se hayan agregado correctamente al carrito de compras",
                Scroll.to(SauceDemoUI.CART_ICON),
                WaitUntil.the(SauceDemoUI.CART_ICON, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(SauceDemoUI.CART_COUNT.of(expectedCount), isCurrentlyVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Performable clickCartIcon() {
        return Task.where("hace clic en el icono del carrito de compras",
                WaitUntil.the(SauceDemoUI.CART_ICON, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(SauceDemoUI.CART_ICON),
                WaitUntil.the(SauceDemoUI.SHOPPING_CART_TITLE, isCurrentlyVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Performable removeProductFromCart() {
        return Task.where("elimina el producto del carrito de compras",
                WaitUntil.the(SauceDemoUI.REMOVE_BUTTON, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(SauceDemoUI.REMOVE_BUTTON)
        );
    }

    public static Performable continueShopping(String buttonText) {
        return Task.where("hace clic en el botón continuar comprando",
                WaitUntil.the(SauceDemoUI.BUTTON_CONTINUE_SHOPING.of(buttonText), isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(SauceDemoUI.BUTTON_CONTINUE_SHOPING.of(buttonText))
        );
    }


}
