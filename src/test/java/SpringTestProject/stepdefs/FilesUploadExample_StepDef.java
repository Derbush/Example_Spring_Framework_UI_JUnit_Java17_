package SpringTestProject.stepdefs;

import SpringTestProject.pages.LoginPage;
import SpringTestProject.stepdefs.config.ProfilesSetUp;
import SpringTestProject.utilities.ConfigurationReader;
import SpringTestProject.utilities.DataUtils;
import io.cucumber.java.en.And;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class FilesUploadExample_StepDef {


    @Autowired
    private WebDriver driver;

    @Autowired
    ConfigurationReader reader;

    @Autowired
    private WebDriverWait wait;

    @Autowired
    private ProfilesSetUp profilesSetUp;

    @Autowired
    private DataUtils dataUtils;

    @Autowired
    LoginPage loginPage;

    @And("User selects the Advertising Campaign {string}")
    public void userSelectsTheAdvertisingCampaign(String CampaignName) {

        /*
        boolean RKIsFound = false;

        while (true) {

            log.info("Название РК: " + RK_name);

            for (WebElement each : фотоотчеты_page.Campaign_list) {
                if (each.getText().equals(CampaignName)) {
                    log.info("Пользователь нажимает на " + each.getText());
                    // wait.until(ExpectedConditions.elementToBeClickable(each));
                    each.click();
                    RKIsFound = true;
                    break;
                }
            }
            if (RKIsFound) {
                break;
            }

            if (!фотоотчеты_page.следующая_страница.isEnabled()) {
                assertThat(true).isFalse();
            }

            фотоотчеты_page.следующая_страница.click();

        }

        фотоотчеты_page.waitForASpinningBarToDisapear();

         */

    }

    @And("User clicks {string} button")
    public void userClicksButton(String btn_name) {
    }

    @And("User clicks the Submit button")
    public void userClicksTheSubmitButton() {

    }

    @And("User selects the file {string}")
    public void userSelectsTheFile(String fileName) {

        if ("local".equals(profilesSetUp.getActiveProfile())) {
            //pageName.загрузитьФайл.sendKeys("C:\\Users\\user002107\\IdeaProjects\\mi-ooh-test\\src\\test\\resources\\" + reader.initializeProperties().getProperty("uploadsLocation") + "\\"+ fileName);
        } else if ("remote".equals(profilesSetUp.getActiveProfile())) {
            log.info("Workspace is " + System.getenv("WORKSPACE"));
           // pageName.загрузитьФайл.sendKeys(System.getenv("WORKSPACE")+"/src/test/resources/"+ reader.initializeProperties().getProperty("uploadsLocation") + "/"+ fileName);
        }

    }
}
