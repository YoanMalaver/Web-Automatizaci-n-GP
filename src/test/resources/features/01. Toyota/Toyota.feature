@FeatureTestSetToyota
Feature:Ingreso a pagina web

  # ************************************** Pagina Principal *********************************************** #

  @BusquedaVehiculo
   #TotoyaSearchVehicleSteps
  Scenario Outline: Validar la busqueda en Herramientas de compra "Cotizar" en la sección escoge tu toyota
    Given Juan accede a la pagina de Toyota
    And accede a "Herramientas de compra" seleccionando "Cotizar"
    When ingresa <Modelo> y <Version>
    Then se debe visualizar el modelo seleccionado <Precio> del modelo y acceso al detalle
    Examples:
      | Modelo | Version      | Precio              |
      | Avanza | Avanza LE MT | Desde $356,200 M.N. |

  @ValidarBusqueda
    #ValidateSearchSteps
  Scenario: Validar Busqueda en cuadro de Texto
    Given Juan accede a la pagina de Toyota
    When seleciona la lupa de Busqueda
    And Ingresa el texto "Hibrido"
    Then se debe visualizar en las opciones sugeridas
    |¿Por qué híbrido?|

    @RedireccionQuieroUnToyota
    Scenario: Validar redirección del botón "Quiero un Toyota"
      Given Juan accede a la pagina de Toyota




