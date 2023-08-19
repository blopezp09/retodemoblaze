package co.com.sofka.stepdefinitions.demoblazecompra;

import co.com.sofka.actions.commonactions.AbrirNavegador;
import co.com.sofka.questions.TotalAPagar;
import co.com.sofka.setup.DriverConfiguration;
import co.com.sofka.tasks.compras.CalcularTotalDeProductos;
import co.com.sofka.utils.Config;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.andreinc.mockneat.MockNeat;

import static co.com.sofka.tasks.commontasks.SeleccionarProductos.seleccionarProductos;
import static co.com.sofka.tasks.registromodal.CamposModal.TOTAL_A_PAGAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidarTotalAPagar extends DriverConfiguration {

    private final MockNeat mock = MockNeat.threadLocal();
    @Dado("que el usuario haya seleccionado los productos a comprar en la página")
    public void queElUsuarioHayaSeleccionadoLosProductosAComprarEnLaPagina() {
        actorSetupTheBrowser(mock.names().val());
        theActorInTheSpotlight().wasAbleTo(
                AbrirNavegador.abrir(),
                seleccionarProductos()
        );
    }
    @Cuando("el usuario navega por la vista del resumen de compra y obtiene el total a pagar")
    public void elUsuarioNavegaPorLaVistaDelResumenDeCompraYObtieneElTotalAPagar() {

        theActorInTheSpotlight().attemptsTo(
                CalcularTotalDeProductos.desdeArchivo(Config.getProperty("ruta.json"))
        );
    }
    @Entonces("el total a pagar corresponderá al total de los precios de los productos seleccionados")
    public void elTotalAPagarCorresponderaAlTotalDeLosPreciosDeLosProductosSeleccionados() {
        theActorInTheSpotlight().should(
                seeThat(TotalAPagar.esIgualA(TOTAL_A_PAGAR), equalTo(true))
        );
    }
}
