package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SauceDemoUI {

    public static final Target USERNAME_INPUT = Target.the("Username input field")
            .located(By.id("username"));

    public static final Target PASSWORD_INPUT = Target.the("Password input field")
            .located(By.id("password"));

    public static final Target SIGN_IN_BUTTON = Target.the("Sign in button")
            .located(By.xpath("//button[contains(., 'Sign in')]"));

    public static final Target LOGOUT_BUTTON = Target.the("Logout button")
            .located(By.xpath("//a[contains(text(), 'Logout')]"));

    public static final Target BOTONES_ADD_TO_CART = Target.the("botones de agregar al carrito")
            .locatedBy("//button[contains(@class, 'cart-button')]");

    public static final Target NOMBRES_PRODUCTOS = Target.the("nombres de los productos")
        .locatedBy("//h3[contains(@class, 'text-lg') and contains(@class, 'font-medium') and contains(@class, 'text-gray-900')]/a");

    public static final Target PRECIOS_PRODUCTOS = Target.the("precios de los productos")
            .locatedBy("//span[contains(@class, 'text-lg') and contains(@class, 'font-medium') and contains(@class, 'text-gray-900')]");

    public static final Target CART_COUNT = Target.the("cantidad de productos en el carrito")
            .locatedBy("//span[contains(@class, 'cart-count') and text()='{0}']");

    public static final Target CART_ICON = Target.the("icono del carrito de compras")
            .locatedBy("//a[@href='cart.php' and contains(@class, 'cart-icon')]");

    public static final Target SHOPPING_CART_TITLE = Target.the("título del carrito de compras")
            .locatedBy("//h2[normalize-space()='Shopping Cart']");

    public static final Target PRODUCTO_EN_CARRITO = Target.the("producto en el carrito")
            .locatedBy("//h3[normalize-space()='{0}']");

    public static final Target PRICE_PRODUCT_IN_CART = Target.the("Valor producto en el carrito")
            .locatedBy("//p[contains(normalize-space(), '{0}')]");

    public static Target PRICE_IN_CART(String price) {
        return Target.the("Valor de producto en el carrito")
                .located(By.xpath("//p[contains(normalize-space(), '"+price+"')]"));
    }

    public static final Target BOTON_CONTINUAR_COMPRANDO = Target.the("botón continuar comprando")
            .locatedBy("//button[contains(text(), 'Continue Shopping')]");

    public static final Target TOTAL_PRICE = Target.the("total de la compra")
          .locatedBy("//div[contains(text(), 'Total: ${0}')]");

    public static final Target REMOVE_BUTTON = Target.the("botón eliminar producto del carrito")
        .locatedBy("//button[contains(., 'Remove')]");

    public static final Target EMPTY_CART_MESSAGE = Target.the("mensaje de carrito vacío")
        .locatedBy("//p[contains(text(), 'Your cart is empty.')]");

    public static final Target BUTTON_CONTINUE_SHOPING = Target.the("botón continuar comprando")
        .locatedBy("//a[contains(normalize-space(), '{0}')]");







}
