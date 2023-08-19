package co.com.sofka.questions;

import co.com.sofka.models.RegistroLogueoUsuarioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.tasks.commontasks.ProductosTarget.CONTENEDOR_PRODUCTOS;
import static co.com.sofka.tasks.registrologueo.RegistroLogueoTarget.USUARIO_LOGUEADO;
import static co.com.sofka.utils.Seconds.TEN_SECONDS;

public class UsuarioLogueadoEs implements Question<Boolean> {

    private final String nombreEsperado;

    public UsuarioLogueadoEs(String nombreEsperado) {
        this.nombreEsperado = nombreEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String nombreObtenido;
        RegistroLogueoUsuarioModel modeloRecuperado;

        modeloRecuperado = actor.recall("registroLogueoUsuarioModel");

        esperarUsuarioVisisble(actor);

        nombreObtenido = USUARIO_LOGUEADO.resolveFor(actor).getText();
        return (nombreEsperado+modeloRecuperado.getUsuario()).equals(nombreObtenido);
    }

    public static UsuarioLogueadoEs igualA(String nombreEsperado) {
        return new UsuarioLogueadoEs(nombreEsperado);
    }

    public <T extends Actor> void esperarUsuarioVisisble(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USUARIO_LOGUEADO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                WaitUntil.the(CONTENEDOR_PRODUCTOS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds()
        );

    }
}
