package co.com.sofka.setup;

import co.com.sofka.utils.OsUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class DriverConfiguration {
    @Managed()
    protected WebDriver browser;

    protected void actorSetupTheBrowser(String actorName){
        setupDriver();
        setupBrowser(browser);
        setupUser(actorName, browser);
    }

    private void setupDriver(){
        String os;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
         os = OsUtils.getOperatingSystemType();
        switch (os) {
            case "linux" -> WebDriverManager.chromedriver().linux().setup();
            case "windows" -> WebDriverManager.chromedriver().win().setup();
            default -> throw new RuntimeException("Sistema operativo no soportado para ejecutar la automatización");
        }
        browser = new ChromeDriver(options);
    }

    private void setupBrowser(WebDriver browser){
        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();
    }

    private void setupUser(String name, WebDriver driver){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(driver));
    }
}

