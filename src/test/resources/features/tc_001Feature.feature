Feature: Validar inicio de sesión con credenciales correctas

  Scenario: Iniciar sesión con nombre de usuario y contraseña válidos
    Given El usuario está en la página de inicio de sesión
    When El usuario ingresa el nombre de usuario válido "usuarioEjemplo"
    And El usuario ingresa la contraseña válida "contraseñaEjemplo"
    And El usuario hace clic en el botón 'Iniciar sesión'
    Then El usuario es redirigido a la página principal
    And Se muestra un mensaje de bienvenida