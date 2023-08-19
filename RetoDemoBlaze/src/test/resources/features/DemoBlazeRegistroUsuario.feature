# language: es
Característica: Realizar registro y logueo en la página web

  Escenario: Verificar que un usuario se pueda registrar en la página exitosamente
    Dado que el usuario haya ingresado a la página
    Cuando el usuario se registra en la página exitosamente
    Entonces la página mostrará una alerta "Sign up successful."

  Escenario: Verificar que un usuario se pueda loguear y su usuario se pueda visualizar
    Dado que el usuario se haya registrado en la página web
    Cuando el usuario suministra los datos para loguearse y valida
    Entonces se mostrará su usuario "Welcome " seguido de su usuario