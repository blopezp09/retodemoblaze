package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RegistroExitoso implements Question<Boolean> {

    private final String textoAComparar;

    public RegistroExitoso(String textoAComparar) {
        this.textoAComparar = textoAComparar;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String textoGuardado = actor.recall("RegistroExitoso");
        return textoAComparar.equals(textoGuardado);
    }

    public static RegistroExitoso conValor(String textoAComparar) {
        return new RegistroExitoso(textoAComparar);
    }
}

