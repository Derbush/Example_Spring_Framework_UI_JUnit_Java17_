package SpringTestProject.stepdefs.config;

import SpringTestProject.utilities.annotations.LazyConfiguration;
import SpringTestProject.utilities.annotations.WebDriverScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Profile;

import java.time.Duration;

@LazyConfiguration
public class RemoteWebDriverConfig {

    @Profile("remote")
    @WebDriverScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--no-sandbox");  // Disable sandboxing for Chrome
        options.addArguments("--disable-dev-shm-usage");  // Use /tmp instead of /dev/shm

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

}