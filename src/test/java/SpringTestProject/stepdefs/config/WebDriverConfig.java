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
import java.util.HashMap;

@LazyConfiguration
public class WebDriverConfig {

    @Profile("local")
    @WebDriverScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--headless");  // Run in headless mode
        //  options.addArguments("--no-sandbox");  // Disable sandboxing for Chrome
        //  options.addArguments("--disable-dev-shm-usage");  // Use /tmp instead of /dev/shm
        //options.addArguments("--remote-debugging-port=9222");  // Enable remote debuggin

        // Disable password saving
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Disable notifications
        prefs.put("profile.default_content_setting_values.notifications", 2);

        options.setExperimentalOption("prefs", prefs);

        // Add additional experimental options
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

}