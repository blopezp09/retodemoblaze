package co.com.sofka.tasks.commontasks;

import co.com.sofka.questions.ObtenerPrecioProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InsertarValoresJson implements Task {
    private final Target nombreDelProducto;
    private final String jsonFilePath;
    private static final Logger LOGGER = LoggerFactory.getLogger(InsertarValoresJson.class);

    public InsertarValoresJson(Target nombreDelProducto, String jsonFilePath) {
        this.nombreDelProducto = nombreDelProducto;
        this.jsonFilePath = jsonFilePath;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            String nombre = nombreDelProducto.resolveFor(actor).getText();
            String precio = actor.asksFor(ObtenerPrecioProducto.valor());
            Path path = Paths.get(jsonFilePath);

            JSONObject productDetails = new JSONObject();
            productDetails.put("nombre", nombre);
            productDetails.put("precio", precio);

            // Leer el contenido actual del archivo
            String currentContent = new String(Files.readAllBytes(path));
            JSONArray jsonArray = new JSONArray(currentContent);

            // Agregar el nuevo producto
            jsonArray.put(productDetails);

            // Escribir de nuevo el JSONArray actualizado al archivo
            Files.write(path, jsonArray.toString().getBytes());

        } catch (Exception e) {
            LOGGER.error("No se pudo insertar datos en el JSON {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static InsertarValoresJson conLosValores(Target nombreDelProducto, String jsonFilePath) {
        return new InsertarValoresJson(nombreDelProducto, jsonFilePath);
    }
}
