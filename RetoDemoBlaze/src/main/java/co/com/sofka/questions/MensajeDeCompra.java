package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.tasks.registromodal.CamposModal.MENSAJE_GRACIAS_POR_LA_COMPRA;

public class MensajeDeCompra implements Question<Boolean> {

    private final String mensajeCompra;

    public MensajeDeCompra(String mensajeCompra) {
        this.mensajeCompra = mensajeCompra;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String textoObtenido = MENSAJE_GRACIAS_POR_LA_COMPRA.resolveFor(actor).getText();
        return textoObtenido.equals(mensajeCompra);
    }

    public MensajeDeCompra es(){
        return this;
    }

    public static MensajeDeCompra esElEsperado(String mensajeCompra) {
        return new MensajeDeCompra(mensajeCompra);
    }
}
