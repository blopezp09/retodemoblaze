package co.com.sofka.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/DemoBlazeCompra.feature", "src/test/resources/features/DemoBlazeRegistroUsuario.feature"},
        glue = {"co.com.sofka.stepdefinitions.demoblazecompra", "co.com.sofka.stepdefinitions.demoblazeregistroylogueo"}

)

public class retoDemoBlazeRunner {
}
