package co.com.sofka.actions.commonactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.pages.PageObject;

public class ScrollToEndOfPage extends PageObject implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static ScrollToEndOfPage now() {
        return new ScrollToEndOfPage();
    }
}

