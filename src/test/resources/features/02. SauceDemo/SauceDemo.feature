@FeatureSauceDemo
Feature: Prueba de conocimiento automatización Web

  Background:
    Given ingreso en la página de SauceDemo

  @Login # Punto 1
    #SauceDemoSteps
  Scenario: Iniciar sesión con éxito
    When ingreso el usuario "standard_user" y la contraseña "standard123"

  @ValidarProductos # Punto 2
    #SauceDemoSteps
  Scenario: Validar los productos agregados al carrito de compras
    And ingreso el usuario "standard_user" y la contraseña "standard123"
    When agrego 2 productos al carrito de compras
    Then valido que los productos se hayan agregado correctamente al carrito de compras
    And Valido el total de productos en el carrito de compras

  @MJSAndButtonContinueShopping # Punto 3
    #MsjsAndButtonContinueShoppingSteps
  Scenario: Agregar un producto al azar, eliminar el producto, validar el mensaje y el botón "Continue Shopping"
    And ingreso el usuario "standard_user" y la contraseña "standard123"
    When agrego 1 productos al carrito de compras
    And elimino el producto del carrito de compras
    Then valido el mensaje "Your cart is empty." y el botón "Continue Shopping"

  @ValidarProductosCatalogo # Punto 4 Escenario simple
    #CatalogSteps
   #CatalogSteps
  Scenario: Validar 3 productos del catálogo Scenario simple
    When ingreso el usuario "standard_user" y la contraseña "standard123"
    Then valido que los productos del catálogo sean correctos
      | Producto            | Valor   |
      | Bluetooth Speaker   | $129.99 |
      | Coffee Maker        | $79.99  |
      | Mechanical Keyboard | $149.99 |

  @ValidarProductosCatalogoSO # Punto 4 Escenario outline
    #CatalogSteps
   #CatalogSteps
  Scenario Outline: Validar 3 productos del catálogo Scenario simple
    When ingreso el usuario "standard_user" y la contraseña "standard123"
    Then valido el <nombre> y <valor> los productos del catálogo sean correctos
    Examples:
      | nombre            | valor   |
      | Bluetooth Speaker   | $129.99 |
      | Coffee Maker        | $79.99  |
      | Mechanical Keyboard | $149.99 |





