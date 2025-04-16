Feature: Validar inicio de sesión con credenciales incorrectas

  Scenario: Intento de inicio de sesión con nombre de usuario y contraseña incorrectos
    Given el usuario está en la página de inicio de sesión
    When el usuario ingresa el nombre de usuario "usuarioInexistente"
    And el usuario ingresa la contraseña "contraseñaIncorrecta"
    And el usuario hace clic en el botón "Iniciar sesión"
    Then se muestra un mensaje de error indicando "Credenciales incorrectas"