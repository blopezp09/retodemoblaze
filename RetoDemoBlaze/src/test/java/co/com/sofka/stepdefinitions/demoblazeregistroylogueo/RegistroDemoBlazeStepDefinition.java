package co.com.sofka.stepdefinitions.demoblazeregistroylogueo;

import co.com.sofka.actions.commonactions.AbrirNavegador;
import co.com.sofka.questions.RegistroExitoso;
import co.com.sofka.setup.DriverConfiguration;
import co.com.sofka.tasks.registrologueo.RegistrarUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.andreinc.mockneat.MockNeat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegistroDemoBlazeStepDefinition extends DriverConfiguration {
    private final MockNeat mock = MockNeat.threadLocal();
    @Dado("que el usuario haya ingresado a la página")
    public void queElUsuarioHayaIngresadoALaPagina() {
        actorSetupTheBrowser(mock.names().val());
        theActorInTheSpotlight().wasAbleTo(
                AbrirNavegador.abrir()
        );
    }
    @Cuando("el usuario se registra en la página exitosamente")
    public void elUsuarioSeRegistraEnLaPaginaExitosamente() {
        theActorInTheSpotlight().wasAbleTo(
                RegistrarUsuario.conLosDatos()
        );
    }
    @Entonces("la página mostrará una alerta {string}")
    public void laPaginaMostraraUnaAlerta(String mensajeAlerta) {
        theActorInTheSpotlight().should(
                seeThat(RegistroExitoso.conValor(mensajeAlerta), equalTo(true))
        );
    }
}
