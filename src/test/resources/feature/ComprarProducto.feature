Feature: Comprar producto en demoblaze

  Scenario: Comprar un producto exitosamente
    Given El usuario esta en la pagina de inicio de demoblaze
    When El usuario selecciona el producto
    And El usuario agrega el producto al carrito
    And El usuario va al carrito y visualiza el producto agregado
    And El usuario realiza el pedido y llena formulario de compra con los siguientes datos:
      | nombre | pais | ciudad   | tarjeta             | mes | anio |
      | Juan   | USA  | New York | 1234 5678 9012 3456 | 12  | 2025 |
    Then Deberia ver un mensaje de confirmacion de compra exitosa