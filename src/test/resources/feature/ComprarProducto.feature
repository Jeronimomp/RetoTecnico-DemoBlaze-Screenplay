Feature: Comprar producto en demoblaze

  Scenario: Comprar un producto exitosamente
    Given El usuario está en la página de inicio de demoblaze
    When El usuario selecciona el producto
    And El usuario agrega el producto al carrito
    And El usuario va al carrito y visualiza el producto agregado
    And El usuario realiza el pedido y llena formulario de compra con los siguientes datos:
      | nombre | pais | ciudad   | tarjeta             | mes | anio |
      | Juan   | USA  | New York | 1234 5678 9012 3456 | 12  | 2025 |
    Then Debería ver un mensaje de confirmación de compra exitosa