package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tek.bdd.utility.SeleniumUtility;


public class HooksSteps extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(HooksSteps.class);
    @Before
    public void beforeEachScenario(){
        LOGGER.info("Open browser and navigate to retail app");
        openBrowser();
    }

    @After
    public void afterEachScenario(Scenario scenario){
        LOGGER.info("Close the browser after executing the program");
        if (scenario.isFailed()){
            LOGGER.info("Take screenshot after scenario failed");
            byte[] screenShot = takeScreenShot();
            scenario.attach(screenShot, "image/png", "failed_scenario");
        }
        quitBrowser();
    }
}
