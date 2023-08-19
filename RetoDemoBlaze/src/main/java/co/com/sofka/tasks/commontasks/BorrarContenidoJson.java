package co.com.sofka.tasks.commontasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BorrarContenidoJson implements Task {
    private final String jsonFilePath;
    private static final Logger LOGGER = LoggerFactory.getLogger(BorrarContenidoJson.class);

    public BorrarContenidoJson(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Files.write(Paths.get(jsonFilePath), "[]".getBytes());
        } catch (Exception e) {
            LOGGER.error("No se pudo borrar el contenido del archivo {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static BorrarContenidoJson deLaRuta(String jsonFilePath) {
        return new BorrarContenidoJson(jsonFilePath);
    }
}
