package co.com.sofka.questions;

import co.com.sofka.models.Producto;
import co.com.sofka.utils.Config;
import co.com.sofka.utils.JsonUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.tasks.eliminarproducto.EliminarProductosTarget.CONTENEDOR_PRODUCTOS_CARRITO;
import static co.com.sofka.tasks.eliminarproducto.EliminarProductosTarget.NOMBRE_PRODUCTO_A_ELIMINAR;
import static co.com.sofka.utils.Diccionario.UNO;
import static co.com.sofka.utils.Seconds.TEN_SECONDS;

public class ElProductoFueEliminado implements Question<Boolean> {

    private final String nombreProductoEliminado;
    private static final Logger LOGGER = LoggerFactory.getLogger(ElProductoFueEliminado.class);

    public ElProductoFueEliminado(String nombreProductoEliminado) {
        this.nombreProductoEliminado = nombreProductoEliminado;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> nombresProductosActuales = obtenerNombresProductos(actor);
        List<String> nombresProductosJson;

        List<Producto> productosJson = null;
        try {
            productosJson = JsonUtils.leerProductosDeJson(Config.getProperty("ruta.json"));
        } catch (IOException e) {
            LOGGER.error("No se pudo leer el contenido del archivo JSON {}", e.getMessage());
            e.printStackTrace();
        }
        assert productosJson != null;
        nombresProductosJson = productosJson.stream()
                .map(Producto::getNombre)
                .toList();

        long cantidadEnListaActual = nombresProductosActuales.stream()
                .filter(nombre -> nombre.equals(nombreProductoEliminado))
                .count();

        long cantidadEnJson = nombresProductosJson.stream()
                .filter(nombre -> nombre.equals(nombreProductoEliminado))
                .count();

        return cantidadEnListaActual == (cantidadEnJson - UNO);
    }

    public static ElProductoFueEliminado delCarrito(String nombreProductoEliminado) {
        return new ElProductoFueEliminado(nombreProductoEliminado);
    }
    private List<String> obtenerNombresProductos(Actor actor) {
        int numeroProductos = CONTENEDOR_PRODUCTOS_CARRITO.resolveAllFor(actor).size();
        List<String> nombresProductos = new ArrayList<>();

        for (int i = UNO; i <= numeroProductos; i++) {
            Target targetProductoActual = NOMBRE_PRODUCTO_A_ELIMINAR.of(String.valueOf(i));

            actor.attemptsTo(
                    WaitUntil.the(targetProductoActual, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(TEN_SECONDS.getValue())
                            .seconds());

            nombresProductos.add(targetProductoActual.resolveFor(actor).getText());
        }

        return nombresProductos;
    }

}
