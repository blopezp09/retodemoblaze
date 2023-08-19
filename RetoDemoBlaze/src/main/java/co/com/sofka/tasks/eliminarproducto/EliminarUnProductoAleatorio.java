package co.com.sofka.tasks.eliminarproducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.Random;
import static co.com.sofka.tasks.eliminarproducto.EliminarProductosTarget.*;
import static co.com.sofka.utils.Diccionario.UNO;
import static co.com.sofka.utils.Seconds.TEN_SECONDS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarUnProductoAleatorio implements Task {

    private static final String PRODUCTO_ELIMINADO = "productoEliminado";
    private final Random random = new Random();

    @Override
    public <T extends Actor> void performAs(T actor) {
        int numeroDeProductos;
        int indiceAleatorio;
        String nombreProductoEliminado;

        actor.attemptsTo(
                WaitUntil.the(CONTENEDOR_PRODUCTOS_CARRITO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds()
        );

        numeroDeProductos = CONTENEDOR_PRODUCTOS_CARRITO.resolveAllFor(actor).size();
        indiceAleatorio = random.nextInt(numeroDeProductos) + UNO;

        nombreProductoEliminado = NOMBRE_PRODUCTO_A_ELIMINAR.of(String.valueOf(indiceAleatorio)).resolveFor(actor).getText();
        actor.remember(PRODUCTO_ELIMINADO, nombreProductoEliminado);

        BOTON_ELIMINAR_PRODUCTO.of(String.valueOf(indiceAleatorio)).resolveFor(actor).click();

        esperarProductos(actor, indiceAleatorio);

    }

    public void esperarProductos(Actor actor, int indiceAleatorio) {

        actor.attemptsTo(
                WaitUntil.the(CONTENEDOR_PRODUCTOS_CARRITO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                WaitUntil.the(NOMBRE_PRODUCTO_A_ELIMINAR.of(String.valueOf(indiceAleatorio)), WebElementStateMatchers.isNotVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds()

        );

    }
    public static EliminarUnProductoAleatorio delCarrito() {
        return instrumented(EliminarUnProductoAleatorio.class);
    }
}

