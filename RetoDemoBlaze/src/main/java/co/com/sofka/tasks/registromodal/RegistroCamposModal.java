package co.com.sofka.tasks.registromodal;

import co.com.sofka.models.ClienteModel;
import net.andreinc.mockneat.MockNeat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.sofka.tasks.registromodal.CamposModal.*;
import static co.com.sofka.utils.Seconds.TEN_SECONDS;

public class RegistroCamposModal implements Task {

    private final ClienteModel clienteModel = new ClienteModel();

    public static RegistroCamposModal registrar() {
        return new RegistroCamposModal();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        generarDatosCliente();

        actor.attemptsTo(
        WaitUntil.the(BOTON_PAGAR_MODAL, WebElementStateMatchers.isClickable())
                .forNoMoreThan(TEN_SECONDS.getValue())
                .seconds(),

                Scroll.to(BOTON_PAGAR_MODAL),
                Click.on(BOTON_PAGAR_MODAL),

                WaitUntil.the(CAMPOS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(CAMPO_NOMBRE),
                Clear.field(CAMPO_NOMBRE),
                Enter.theValue(clienteModel.getNombre()).into(CAMPO_NOMBRE),

                Scroll.to(CAMPO_PAIS),
                Clear.field(CAMPO_PAIS),
                Enter.theValue(clienteModel.getPais()).into(CAMPO_PAIS),

                Scroll.to(CAMPO_CIUDAD),
                Clear.field(CAMPO_CIUDAD),
                Enter.theValue(clienteModel.getCiudad()).into(CAMPO_CIUDAD),

                Scroll.to(CAMPO_TARJETA),
                Clear.field(CAMPO_TARJETA),
                Enter.theValue(clienteModel.getTarjeta()).into(CAMPO_TARJETA),

                Scroll.to(CAMPO_MES),
                Clear.field(CAMPO_MES),
                Enter.theValue(clienteModel.getMes()).into(CAMPO_MES),

                Scroll.to(CAMPO_ANIO),
                Clear.field(CAMPO_ANIO),
                Enter.theValue(clienteModel.getAnio()).into(CAMPO_ANIO),

                Scroll.to(BOTON_PAGAR),
                Click.on(BOTON_PAGAR)

        );
    }

    public void generarDatosCliente() {
        MockNeat mock = MockNeat.threadLocal();

        clienteModel.setNombre(mock.names().val());
        clienteModel.setPais(mock.countries().val());
        clienteModel.setCiudad(mock.cities().us().val());
        clienteModel.setTarjeta(mock.creditCards().val());
        clienteModel.setMes(String.valueOf(mock.months().val()));
        clienteModel.setAnio(String.valueOf(mock.doubles()));
    }
}
