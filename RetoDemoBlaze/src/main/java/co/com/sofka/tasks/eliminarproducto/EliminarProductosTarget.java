package co.com.sofka.tasks.eliminarproducto;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class EliminarProductosTarget extends PageObject {

    public static final Target CONTENEDOR_PRODUCTOS_CARRITO = Target.the("Delete Products").locatedBy("#tbodyid > tr");
    public static final Target NOMBRE_PRODUCTO_A_ELIMINAR = Target.the("Product name")
            .locatedBy("#tbodyid > tr:nth-child({0}) > td:nth-child(2)");
    public static final Target BOTON_ELIMINAR_PRODUCTO = Target.the("Delete btn")
            .locatedBy("#tbodyid > tr:nth-child({0}) > td:nth-child(4) > a");

}
