package co.com.sofka.questions;

import co.com.sofka.utils.Seconds;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.sofka.tasks.eliminarproducto.EliminarProductosTarget.CONTENEDOR_PRODUCTOS_CARRITO;

public class TotalAPagar implements Question<Boolean> {
    private final Target target;

    public TotalAPagar(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String valorTexto;
        double valorTarget;
        double valorCalculado;

        esperarProductos(actor);

         valorTexto = target.resolveFor(actor).getText().trim();
         valorTarget = Double.parseDouble(valorTexto);
         valorCalculado = actor.recall("totalProductos");

        return valorTarget == valorCalculado;
    }

    public static TotalAPagar esIgualA(Target target) {
        return new TotalAPagar(target);
    }

    public <T extends Actor> void esperarProductos(T actor) {

        actor.attemptsTo(
                WaitUntil.the(target, WebElementStateMatchers.isPresent())
                        .forNoMoreThan(Seconds.TEN_SECONDS.getValue())
                        .seconds(),

                WaitUntil.the(CONTENEDOR_PRODUCTOS_CARRITO, WebElementStateMatchers.isPresent())
                        .forNoMoreThan(Seconds.TEN_SECONDS.getValue())
                        .seconds()
        );

    }
}
