Feature: Validar acceso a páginas restringidas sin autenticación

  Scenario: Intentar acceder a página protegida sin autenticación
    Given un usuario anónimo
    When el usuario ingresa la URL de una página protegida
    Then el sistema redirige al usuario a la página de inicio de sesión

  Scenario: Intentar realizar acciones sin autenticación
    Given un usuario en la página protegida, pero no autenticado
    When el usuario intenta realizar una acción en la página
    Then el sistema muestra un mensaje de error y no permite la acción