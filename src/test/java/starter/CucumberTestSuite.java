package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"}
        ,features = "src/test/resources/features/"
        ,glue = "stepDefinitions"
)

public class CucumberTestSuite {
    @BeforeClass
    public static void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

}
