package co.com.sofka.utils;

import co.com.sofka.models.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static List<Producto> leerProductosDeJson(String rutaArchivo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(rutaArchivo), new TypeReference<>() {
        });
    }

    private JsonUtils() {
        throw new IllegalStateException("Utility class");
    }
}