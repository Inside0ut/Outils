import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//adding a comment for test  purposes 
@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",plugin={"json:reports/example-report.json"}
)
public class ExampleTest {

}
