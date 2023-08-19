package co.com.sofka.actions.commonactions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ScrollToTopOfPage extends PageObject implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        evaluateJavascript("window.scrollTo(0, 0)");
    }

    public static ScrollToTopOfPage now() {
        return new ScrollToTopOfPage();
    }
}