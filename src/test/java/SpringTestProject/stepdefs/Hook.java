package SpringTestProject.stepdefs;

import SpringTestProject.pages.GooglePage;
import SpringTestProject.pages.LoginPage;
import SpringTestProject.utilities.ConfigurationReader;
import SpringTestProject.utilities.annotations.LazyAuthowired;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.openqa.selenium.TakesScreenshot;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class Hook {

    @LazyAuthowired
    private ApplicationContext applicationContext;

    @Autowired
    private WebDriver driver;

    @Autowired
    private ConfigurationReader reader;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private GooglePage googlePage;


    @Before
    public void setup() {
        log.info("Hooks set up before each scenario");
        driver.get(reader.initializeProperties().getProperty("url"));
        log.info("Драйвер открыл: " + reader.initializeProperties().getProperty("url"));
        log.info("Заголовок на странице: " + driver.getTitle());
        assertThat(driver.getTitle()).isEqualTo("Google");

    }



    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) this.applicationContext.getBean(WebDriver.class)).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        log.info("Browser is closed");
        this.applicationContext.getBean(WebDriver.class).quit();

    }


}
