# language: es
Característica: Realizar compras de productos en la página web

  Escenario: Validar que se pueda realizar una compra de productos exitosamente
    Dado que el usuario se encuentra en la página web
    Cuando el usuario selecciona los productos a comprar
    Y registra sus datos de compra exitosamente
    Entonces el sistema retornará el mensaje "Thank you for your purchase!"

  Escenario: Validar que se pueda eliminar algún producto seleccionado
    Dado que el usuario haya seleccionado los productos a comprar
    Cuando el usuario elimina un producto
    Entonces en el resumen de compra se mostrarán los productos seleccionados exceptuando el eliminado

  Escenario: Verificar que el total a pagar corresponda a los precios de los productos seleccionados
    Dado que el usuario haya seleccionado los productos a comprar en la página
    Cuando el usuario navega por la vista del resumen de compra y obtiene el total a pagar
    Entonces el total a pagar corresponderá al total de los precios de los productos seleccionados