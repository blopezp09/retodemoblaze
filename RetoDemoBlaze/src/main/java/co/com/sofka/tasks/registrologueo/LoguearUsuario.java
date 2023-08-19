package co.com.sofka.tasks.registrologueo;

import co.com.sofka.models.RegistroLogueoUsuarioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.tasks.commontasks.ProductosTarget.CONTENEDOR_PRODUCTOS;
import static co.com.sofka.tasks.registrologueo.RegistroLogueoTarget.*;
import static co.com.sofka.utils.Seconds.TEN_SECONDS;

public class LoguearUsuario implements Task {

    public static LoguearUsuario conLosDatos() {
        return new LoguearUsuario();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        RegistroLogueoUsuarioModel modeloRecuperado = actor.recall("registroLogueoUsuarioModel");

        actor.attemptsTo(
                WaitUntil.the(OPCION_LOGIN, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(OPCION_LOGIN),
                Click.on(OPCION_LOGIN),

                WaitUntil.the(USUARIO_LOGUEO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(USUARIO_LOGUEO),
                Clear.field(USUARIO_LOGUEO),
                Enter.theValue(modeloRecuperado.getUsuario()).into(USUARIO_LOGUEO),

                WaitUntil.the(CONTRASENIA_LOGUEO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(CONTRASENIA_LOGUEO),
                Clear.field(CONTRASENIA_LOGUEO),
                Enter.theValue(modeloRecuperado.getContrasenia()).into(CONTRASENIA_LOGUEO),

                WaitUntil.the(CONTENEDOR_PRODUCTOS, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(BOTON_INGRESAR),
                Click.on(BOTON_INGRESAR),

                WaitUntil.the(CONTENEDOR_PRODUCTOS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds()
        );

    }
}
