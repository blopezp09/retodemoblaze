package co.com.sofka.stepdefinitions.demoblazeregistroylogueo;

import co.com.sofka.actions.commonactions.AbrirNavegador;
import co.com.sofka.questions.UsuarioLogueadoEs;
import co.com.sofka.setup.DriverConfiguration;
import co.com.sofka.tasks.registrologueo.LoguearUsuario;
import co.com.sofka.tasks.registrologueo.RegistrarUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.andreinc.mockneat.MockNeat;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LogueoUsuarioStepDefinition extends DriverConfiguration {
    private final MockNeat mock = MockNeat.threadLocal();
    @Dado("que el usuario se haya registrado en la página web")
    public void queElUsuarioSeHayaRegistradoEnLaPaginaWeb() {
        actorSetupTheBrowser(mock.names().val());
        theActorInTheSpotlight().wasAbleTo(
                AbrirNavegador.abrir(),
                RegistrarUsuario.conLosDatos()
        );

    }
    @Cuando("el usuario suministra los datos para loguearse y valida")
    public void elUsuarioSuministraLosDatosParaLoguearseYValida() {
        theActorInTheSpotlight().wasAbleTo(
                LoguearUsuario.conLosDatos()
        );
    }
    @Entonces("se mostrará su usuario {string} seguido de su usuario")
    public void seMostraraSuUsuarioSeguidoDeSuUsuario(String bienvenida) {
        theActorInTheSpotlight().should(
                seeThat(UsuarioLogueadoEs.igualA(bienvenida), equalTo(true))
        );
    }
}
