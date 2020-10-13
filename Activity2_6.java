Runner file with pretty:

package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = {"@SmokeTest"},
    strict = true,
    plugin = {"pretty"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}

-----------------------------------------------------------
Runner file for reports:

package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = {"@SmokeTest"},
    strict = true,
    plugin = {"html: test-reports"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}

--------------------------------------------------------------------------------
Runner file for JSON report:

package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = {"@SmokeTest"},
    strict = true,
    plugin = {"json: test-reports/json-report.json"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}
