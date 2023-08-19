package co.com.sofka.tasks.registromodal;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CamposModal extends PageObject {

    public static final Target BOTON_PAGAR_MODAL = Target
            .the("Place Order Modal")
            .located(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
    public static final Target CAMPO_NOMBRE = Target.the("Name").located(By.id("name"));
    public static final Target CAMPO_PAIS = Target.the("Country").located(By.id("country"));
    public static final Target CAMPO_CIUDAD = Target.the("City").located(By.id("city"));
    public static final Target CAMPO_TARJETA = Target.the("Card").located(By.id("card"));
    public static final Target CAMPO_MES = Target.the("Mes").located(By.id("month"));
    public static final Target CAMPO_ANIO = Target.the("Year").located(By.id("year"));
    public static final Target TOTAL_A_PAGAR = Target.the("Total").located(By.id("totalp"));
    public static final Target BOTON_PAGAR = Target
            .the("Place Order")
            .located(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
    public static final Target MENSAJE_GRACIAS_POR_LA_COMPRA = Target
            .the("Place Order")
            .located(By.xpath("/html/body/div[10]/h2"));
    public static final Target CAMPOS = Target.the("Fields").locatedBy("#orderModal > div > div > div.modal-body");

}
