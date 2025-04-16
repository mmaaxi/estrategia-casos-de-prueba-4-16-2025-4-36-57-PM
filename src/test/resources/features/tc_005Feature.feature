Feature: Validar cierre de sesión

  Scenario: Validar que el usuario puede cerrar sesión correctamente
    Given el usuario ha iniciado sesión con credenciales válidas
    When hace clic en el botón 'Cerrar sesión'
    Then el usuario debe ser redirigido a la página de inicio

  Scenario: Intentar acceder a una página protegida sin iniciar sesión
    Given el usuario no ha iniciado sesión
    When intenta acceder a una página protegida
    Then el sistema debe redirigir al usuario a la página de inicio de sesión