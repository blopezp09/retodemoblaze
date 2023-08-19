package co.com.sofka.tasks.registrologueo;

import co.com.sofka.models.RegistroLogueoUsuarioModel;
import net.andreinc.mockneat.MockNeat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static co.com.sofka.tasks.commontasks.ProductosTarget.CONTENEDOR_PRODUCTOS;
import static co.com.sofka.tasks.registrologueo.RegistroLogueoTarget.*;
import static co.com.sofka.utils.Seconds.TEN_SECONDS;
import static net.serenitybdd.core.Serenity.getDriver;

public class RegistrarUsuario implements Task {
    private final MockNeat mock = MockNeat.threadLocal();
    private final RegistroLogueoUsuarioModel registroLogueoUsuarioModel = new RegistroLogueoUsuarioModel();
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrarUsuario.class);
    public static RegistrarUsuario conLosDatos() {
        return new RegistrarUsuario();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(OPCION_REGISTRO, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(OPCION_REGISTRO),
                Click.on(OPCION_REGISTRO)
        );

        registrar(actor);
    }
    public void obtenerDatosUsuario(){
        registroLogueoUsuarioModel.setUsuario(mock.users().val());
        registroLogueoUsuarioModel.setContrasenia(mock.passwords().val());
    }

    public <T extends Actor> void registrarCampos(T actor) {
        actor.attemptsTo(
                WaitUntil.the(NOMBRE_DE_USUARIO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(NOMBRE_DE_USUARIO),
                Clear.field(NOMBRE_DE_USUARIO),
                Enter.theValue(registroLogueoUsuarioModel.getUsuario()).into(NOMBRE_DE_USUARIO),

                WaitUntil.the(CONTRASENIA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(CONTRASENIA),
                Clear.field(CONTRASENIA),
                Enter.theValue(registroLogueoUsuarioModel.getContrasenia()).into(CONTRASENIA),

                WaitUntil.the(BOTON_REGISTRAR, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(BOTON_REGISTRAR),
                Click.on(BOTON_REGISTRAR)

        );
    }

    private <T extends Actor> void registrar(T actor){
        do {
            obtenerDatosUsuario();
            registrarCampos(actor);
        } while (!validarAlerta(actor));

        actor.remember("registroLogueoUsuarioModel",registroLogueoUsuarioModel);

        WaitUntil.the(CONTENEDOR_PRODUCTOS, WebElementStateMatchers.isPresent())
                .forNoMoreThan(TEN_SECONDS.getValue())
                .seconds();

    }

    private <T extends Actor> boolean validarAlerta(T actor ){
        String alertText;
        Alert alert;
        WebDriverWait wait;

        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TEN_SECONDS.getValue()));
            alert = wait.until(ExpectedConditions.alertIsPresent());

            alertText = alert.getText();

            if ("This user already exist.".equals(alertText)) {
                alert.accept();
                return false;
            } else {
                actor.remember("RegistroExitoso", alertText);
                return true;
            }
        } catch (NoAlertPresentException e) {
            LOGGER.error("No se pudo obtener el texto de la alerta {}", e.getMessage());
            return false;
        }
    }
}
