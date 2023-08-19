package co.com.sofka.stepdefinitions.demoblazecompra;

import co.com.sofka.actions.commonactions.AbrirNavegador;
import co.com.sofka.questions.MensajeDeCompra;
import co.com.sofka.setup.DriverConfiguration;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.andreinc.mockneat.MockNeat;

import static co.com.sofka.tasks.commontasks.SeleccionarProductos.seleccionarProductos;
import static co.com.sofka.tasks.registromodal.RegistroCamposModal.registrar;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CompraExitosaStepDefinition extends DriverConfiguration {

    private final MockNeat mock = MockNeat.threadLocal();
    @Dado("que el usuario se encuentra en la página web")
    public void queElUsuarioSeEncuentraEnLaPaginaWeb() {
        actorSetupTheBrowser(mock.names().val());
        theActorInTheSpotlight().wasAbleTo(
                AbrirNavegador.abrir()
        );
    }
    @Cuando("el usuario selecciona los productos a comprar")
    public void elUsuarioSeleccionaLosProductosAComprar() {

        theActorInTheSpotlight().attemptsTo(
            seleccionarProductos()
        );
    }
    @Y("registra sus datos de compra exitosamente")
    public void registraSusDatosDeCompraExitosamente() {

        theActorInTheSpotlight().attemptsTo(
                registrar()
        );
    }
    @Entonces("el sistema retornará el mensaje {string}")
    public void elSistemaRetornaraElMensaje(String mensajeCompra) {
        theActorInTheSpotlight().should(
                seeThat(MensajeDeCompra.esElEsperado(mensajeCompra).es(), equalTo(true))
        );
    }
}
