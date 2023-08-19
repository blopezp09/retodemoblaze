package co.com.sofka.actions.commonactions;

import co.com.sofka.tasks.commontasks.IngresarALaPaginaWeb;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirNavegador implements Task {

    private IngresarALaPaginaWeb ingresarALaPaginaWeb;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(ingresarALaPaginaWeb)
        );
    }

    public static AbrirNavegador abrir(){
        return new AbrirNavegador();
    }
}
