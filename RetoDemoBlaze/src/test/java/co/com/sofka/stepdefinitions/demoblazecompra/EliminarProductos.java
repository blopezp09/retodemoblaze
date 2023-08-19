package co.com.sofka.stepdefinitions.demoblazecompra;

import co.com.sofka.actions.commonactions.AbrirNavegador;
import co.com.sofka.questions.ElProductoFueEliminado;
import co.com.sofka.setup.DriverConfiguration;
import co.com.sofka.tasks.eliminarproducto.EliminarUnProductoAleatorio;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.andreinc.mockneat.MockNeat;

import static co.com.sofka.tasks.commontasks.SeleccionarProductos.seleccionarProductos;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class EliminarProductos extends DriverConfiguration{
    private final MockNeat mock = MockNeat.threadLocal();
    @Dado("que el usuario haya seleccionado los productos a comprar")
    public void queElUsuarioHayaSeleccionadoLosProductosAComprar() {
        actorSetupTheBrowser(mock.names().val());
        theActorInTheSpotlight().wasAbleTo(
                AbrirNavegador.abrir(),
                seleccionarProductos()
        );
    }
    @Cuando("el usuario elimina un producto")
    public void elUsuarioEliminaUnProducto() {
        theActorInTheSpotlight().wasAbleTo(
                EliminarUnProductoAleatorio.delCarrito()
        );
    }
    @Entonces("en el resumen de compra se mostrarán los productos seleccionados exceptuando el eliminado")
    public void enElResumenDeCompraSeMostraranLosProductosSeleccionadosExceptuandoElEliminado() {
        theActorInTheSpotlight().should(
                seeThat(ElProductoFueEliminado.delCarrito(theActorInTheSpotlight().recall("productoEliminado")), equalTo(true))
        );
    }

}
