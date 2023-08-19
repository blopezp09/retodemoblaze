package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.tasks.commontasks.ProductosTarget.*;

public class ObtenerPrecioProducto implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String totalText = CONTENEDOR_PRECIO.resolveFor(actor).getText();
        String unwantedText = TEXTO_SMALL.resolveFor(actor).getText();
        return totalText.replace(unwantedText, "").replace("$", "").trim();
    }
    public static Question<String> valor() {
        return new ObtenerPrecioProducto();
    }
}

