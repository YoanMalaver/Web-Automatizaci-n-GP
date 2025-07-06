package questions;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Question;
import ui.SauceDemoUI;


public class SauceDemoQuestions {

    public static Question<Boolean> products(String productName) {
        return actor -> SauceDemoUI.PRODUCTO_EN_CARRITO.of(productName).resolveFor(actor).isVisible();
    }

    public static Question<Boolean> priceInCart(String price) {
        return actor -> SauceDemoUI.PRICE_IN_CART(price).resolveFor(actor).isVisible();
    }

    public static Question<Boolean> priceProductoInCart(String price) {
        return actor -> SauceDemoUI.PRICE_PRODUCT_IN_CART.of(price).resolveFor(actor).isVisible();
    }

    public static Question<String> totalPrice(String totalPrice) {
        return actor -> SauceDemoUI.TOTAL_PRICE.of(totalPrice).resolveFor(actor).getText().trim();
    }

    public static Question<String> emptyCartMessage() {
        return actor -> SauceDemoUI.EMPTY_CART_MESSAGE.resolveFor(actor).getText().trim();
    }


    public static Question<String> productNames() {
        return actor -> SauceDemoUI.NOMBRES_PRODUCTOS.resolveAllFor(actor).stream()
                .map(WebElementState::getText)
                .reduce((first, second) -> first + ", " + second)
                .orElse("");
    }

    public static Question<String> productPrices() {
        return actor -> SauceDemoUI.PRECIOS_PRODUCTOS.resolveAllFor(actor).stream()
                .map(WebElementState::getText)
                .reduce((first, second) -> first + ", " + second)
                .orElse("");
    }






}
