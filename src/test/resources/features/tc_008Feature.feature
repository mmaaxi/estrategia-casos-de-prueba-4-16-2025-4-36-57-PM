Feature: Validar comportamiento ante campos vacíos en el inicio de sesión

  Scenario: Verificar mensajes de error para campos vacíos en el inicio de sesión
    Given el usuario está en la página de inicio de sesión
    When deja el campo de nombre de usuario vacío y envía el formulario
    Then el sistema muestra un mensaje de error solicitando el ingreso del nombre de usuario

    When deja el campo de contraseña vacío y envía el formulario
    Then el sistema muestra un mensaje de error solicitando el ingreso de la contraseña