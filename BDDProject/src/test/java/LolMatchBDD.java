import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by joao on 7/5/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", snippets = SnippetType.CAMELCASE)
public class LolMatchBDD {
}
