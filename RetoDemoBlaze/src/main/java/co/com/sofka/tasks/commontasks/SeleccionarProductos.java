package co.com.sofka.tasks.commontasks;

import co.com.sofka.actions.commonactions.ScrollToEndOfPage;
import co.com.sofka.actions.commonactions.ScrollToTopOfPage;
import co.com.sofka.utils.Config;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
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
import java.util.Random;
import static co.com.sofka.tasks.commontasks.ProductosTarget.*;
import static co.com.sofka.utils.Diccionario.*;
import static co.com.sofka.utils.Seconds.TEN_SECONDS;
import static net.serenitybdd.core.Serenity.getDriver;

public class SeleccionarProductos implements Task {

    private int totalProductos;
    private final Random random = new Random();
    private static final Logger LOGGER = LoggerFactory.getLogger(SeleccionarProductos.class);

    public static SeleccionarProductos seleccionarProductos() {
        return new SeleccionarProductos();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        do {
            actor.attemptsTo(
                    BorrarContenidoJson.deLaRuta(Config.getProperty("ruta.json")),
                    WaitUntil.the(CONTENEDOR_PRODUCTOS, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(TEN_SECONDS.getValue())
                            .seconds(),
                    ScrollToEndOfPage.now()
            );
            totalProductos = totalProductos + CONTENEDOR_PRODUCTOS.resolveAllFor(actor).size();
        } while (Boolean.TRUE.equals(validarBotonSiguiente(actor)));

        iterarProductos(actor);

    }
    public <T extends Actor> void iterarProductos(T actor) {

        for (int i=CERO; i<random.nextInt(CANTIDAD_PRODUCTOS_ALEATORIOS) + UNO; i++){
            actor.attemptsTo(
                    ScrollToTopOfPage.now(),
                    Scroll.to(BOTON_INICIO),
                    Click.on(BOTON_INICIO),
                    WaitUntil.the(CONTENEDOR_PRODUCTOS, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(TEN_SECONDS.getValue())
                            .seconds()
            );
            seleccionAleatoria(actor);
        }
    }
    public <T extends Actor> Boolean validarBotonSiguiente(T actor) {

        if (BOTON_SIGUIENTE.resolveFor(actor).isClickable()) {
            actor.attemptsTo(
                    WaitUntil.the(BOTON_SIGUIENTE, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(TEN_SECONDS.getValue())
                            .seconds(),
                    Scroll.to(BOTON_SIGUIENTE),
                    Click.on(BOTON_SIGUIENTE)
            );
            return true;
        }
        return false;
    }

    public <T extends Actor> void seleccionAleatoria(T actor) {
        // Genera un número aleatorio entre 1 y totalProductos
        int productosRestantes = random.nextInt(totalProductos) + 1;
        int productosEnPaginaActual;

        do {
            // Calcula el número de productos en la página actual
             productosEnPaginaActual = CONTENEDOR_PRODUCTOS.resolveAllFor(actor).size();
            // Si el producto que estamos buscando está en esta página, selecciona y sale
            if (productosRestantes <= productosEnPaginaActual) {
                agregarAlCarrito(actor,productosRestantes);

                aceptarAlerta();

                insertarValoresJson(actor);

                irAlCarritoDeCompras(actor);
                break;
            } else {
                productosRestantes -= productosEnPaginaActual;
                pasarDePagina(actor);
            }
        } while (true);
    }

    public <T extends Actor> void agregarAlCarrito(T actor, int productosRestantes) {
        actor.attemptsTo(
                WaitUntil.the(CONTENEDOR_PRODUCTOS,WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(PRODUCTO.of(String.valueOf(productosRestantes)).resolveFor(actor)),
                Click.on(PRODUCTO.of(String.valueOf(productosRestantes)).resolveFor(actor)),

                WaitUntil.the(NOMBRE_DEL_PRODUCTO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(BOTON_AGREGAR_AL_CARRITO),
                Click.on(BOTON_AGREGAR_AL_CARRITO)
        );
    }
    public <T extends Actor> void pasarDePagina(T actor) {

        actor.attemptsTo(

                ScrollToEndOfPage.now(),

                WaitUntil.the(BOTON_SIGUIENTE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),

                Scroll.to(BOTON_SIGUIENTE),

                Click.on(BOTON_SIGUIENTE),

                WaitUntil.the(CONTENEDOR_PRODUCTOS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(TEN_SECONDS.getValue())
                        .seconds(),
                ScrollToTopOfPage.now()
        );
    }
    public void aceptarAlerta() {
        try {

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // espera hasta 10 segundos
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (NoAlertPresentException e) {
            LOGGER.error("No se pudo aceptar la alerta: {}", e.getMessage());
            e.getStackTrace();
        }
    }

    public <T extends Actor> void irAlCarritoDeCompras(T actor) {
        actor.attemptsTo(
                Scroll.to(CARRITO_DE_COMPRAS),
                Click.on(CARRITO_DE_COMPRAS)
        );
    }

    public <T extends Actor> void insertarValoresJson(T actor) {
        actor.attemptsTo(
                InsertarValoresJson.conLosValores(NOMBRE_DEL_PRODUCTO,Config.getProperty("ruta.json"))
        );
    }
}
