package co.com.sofka.tasks.registrologueo;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class RegistroLogueoTarget extends PageObject {

    public static final Target NOMBRE_DE_USUARIO = Target.the("User name").located(By.id("sign-username"));
    public static final Target CONTRASENIA = Target.the("Password").located(By.id("sign-password"));
    public static final Target OPCION_REGISTRO = Target.the("Sign Up Option").located(By.id("signin2"));
    public static final Target BOTON_REGISTRAR = Target
            .the("Sign Up")
            .located(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
    public static final Target USUARIO_LOGUEO = Target.the("Login User Name").located(By.id("loginusername"));
    public static final Target CONTRASENIA_LOGUEO = Target.the("Login Password").located(By.id("loginpassword"));
    public static final Target BOTON_INGRESAR = Target
            .the("Login")
            .located(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
    public static final Target USUARIO_LOGUEADO = Target.the("Log user").located(By.id("nameofuser"));
    public static final Target OPCION_LOGIN = Target.the("Log in").located(By.id("login2"));


}
