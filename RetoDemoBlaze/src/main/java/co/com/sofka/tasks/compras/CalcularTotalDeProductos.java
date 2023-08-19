package co.com.sofka.tasks.compras;

import co.com.sofka.models.Producto;
import co.com.sofka.utils.JsonUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class CalcularTotalDeProductos implements Task {

    private final String rutaArchivo;
    private static final Logger LOGGER = LoggerFactory.getLogger(CalcularTotalDeProductos.class);

    public CalcularTotalDeProductos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            List<Producto> productos = JsonUtils.leerProductosDeJson(rutaArchivo);
            double total = productos.stream()
                    .mapToDouble(producto -> Double.parseDouble(producto.getPrecio()))
                    .sum();
            actor.remember("totalProductos", total);
        } catch (IOException e) {
            LOGGER.error("Error al leer el archivo {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static CalcularTotalDeProductos desdeArchivo(String rutaArchivo) {
        return new CalcularTotalDeProductos(rutaArchivo);
    }
}
