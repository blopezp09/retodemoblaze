package co.com.sofka.tasks.commontasks;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductosTarget extends PageObject {

    public static final Target CONTENEDOR_PRODUCTOS = Target.the("item container").locatedBy("#tbodyid > div");
    public static final Target PRODUCTO = Target.the("Product").locatedBy("#tbodyid > div:nth-child({0}) > div > div > h4 > a");
    public static final Target BOTON_AGREGAR_AL_CARRITO = Target
            .the("Add to cart")
            .located(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
    public static final Target NOMBRE_DEL_PRODUCTO = Target
            .the("Name")
            .located(By.xpath("//*[@id=\"tbodyid\"]/h2"));
    public static final Target BOTON_SIGUIENTE = Target.the("next button").located(By.id("next2"));
    public static final Target CARRITO_DE_COMPRAS = Target.the("next button").located(By.id("cartur"));
    public static final Target BOTON_INICIO = Target.the("Boton inicio").located(By.id("nava"));
    public static final Target CONTENEDOR_PRECIO = Target.the("price container").locatedBy(".price-container");
    public static final Target TEXTO_SMALL = Target.the("small text").locatedBy(".price-container small");

}
