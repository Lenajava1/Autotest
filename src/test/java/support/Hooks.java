package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;
import static support.TestContext.getPositionFromFile;

public class Hooks {

    RestClient restClient = new RestClient();

    @Before(order = 0)
    public void scenarioStart() {
        TestContext.initialize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMinutes(8));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(800));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofMillis(300));



    }
    @Before(value = "@post_position")
    public void createPosition(){
        Map<String, String> positionToCreate = getPositionFromFile("automation");
       restClient.postPosition(positionToCreate);
    }

    @After(value = "@clean_position")
    public void deletePosition(){

        restClient.deletePosition(TestContext.getPositionId());

    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        TestContext.teardown();
    }
}
