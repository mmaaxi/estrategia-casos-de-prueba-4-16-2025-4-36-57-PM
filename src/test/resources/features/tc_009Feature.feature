Feature: Validar manejo de caracteres especiales en los campos de inicio de sesión

  Scenario: Validación de caracteres especiales en inicio de sesión
    Given el usuario está en la página de login
    When ingresa caracteres especiales en el campo de nombre de usuario
    Then el sistema debe aceptar o rechazar caracteres especiales según la política de validación
    When ingresa caracteres especiales en el campo de contraseña
    Then el campo debe aceptar la entrada y enmascarar los caracteres ingresados
    When el usuario hace clic en 'Iniciar sesión'
    Then el sistema muestra un mensaje de error en caso de formato inválido o acepta la autenticación si es correcto