Feature: Validar bloqueo de cuenta tras múltiples intentos fallidos

  Scenario: Bloqueo de cuenta por intentos fallidos
    Given el usuario está en la página de inicio de sesión
    When el usuario ingresa credenciales incorrectas tres veces consecutivas
    Then el sistema registra cada intento fallido

    When el usuario intenta iniciar sesión con la misma cuenta
    Then se muestra mensaje de error 'Cuenta bloqueada temporalmente por seguridad'

    When el usuario espera el tiempo configurado para desbloqueo
    Then el sistema permite intentar iniciar sesión nuevamente