package SpringTestProject.stepdefs;

import SpringTestProject.pages.LoginPage;
import SpringTestProject.stepdefs.config.ProfilesSetUp;
import SpringTestProject.utilities.ConfigurationReader;
import SpringTestProject.utilities.DataUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;


@Log4j2
public class FilesDownloadExample_StepDef {

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

    @Given("User logs into the RAP using the role of {string}")
    public void userLogsIntoTheRAPUsingTheRoleOf(String role) {
    }

    @When("User clicks on {string}")
    public void userClicksOn(String arg0) {
    }

    @And("User clicks the {string} button")
    public void userClicksTheButton(String arg0) {
    }

    @Then("Modal window appears on the {string} with the message {string} and {string}")
    public void modalWindowAppearsOnTheWithTheMessageAnd(String page, String header, String body) {

        /*
        if (page.equals("Все РК")|| page.equals("Фотоотчеты")){
        switch (page) {
            case "Все РК":
                if (header.equals("Скачивание файла")) {
                    log.info("Заголовок на странице: " + моиАП_page.getModalContainerHeaders());
                    assertThat(моиАП_page.getModalContainerHeaders()).isEqualTo(header);
                    String actualBody = моиАП_page.getModalContainerTextBody();
                    log.info("Текст в модально окне: " + actualBody.substring(0, 40));
                    assertThat(actualBody.substring(0, 40)).isEqualTo(body);
                } else if (header.contains("Загрузить Primary")) {
                    wait.until(ExpectedConditions.textToBePresentInElement(моиАП_page.modalContentHeaders, "TestManual"));
                    log.info("Заголовок на странице: " + моиАП_page.modalContentHeaders.getText());
                    assertThat(моиАП_page.modalContentHeaders.getText()).isEqualTo(header.replace("Primary АП", "Primary\nАП"));
                    всеРК_page.waitForTextInWebElementToBePresent(моиАП_page.modalContentBodyText);
                    String actualBody = моиАП_page.modalContentBodyText.getText();
                    log.info("Текст в модально окне: " + actualBody);
                    assertThat(actualBody).isEqualTo(body.replace("Мб П", "Мб\nП"));

                } else {
                    assertThat(false).isTrue();
                }
                break;
            case "Фотоотчеты":
                if (header.equals("Скачивание файла")) {
                    log.info("Заголовок на странице: " + моиАП_page.getModalContainerHeaders());
                    assertThat(моиАП_page.getModalContainerHeaders()).isEqualTo(header);
                    String actualBody = моиАП_page.getModalContainerTextBody();
                    log.info("Текст в модально окне: " + actualBody.substring(0, 40));
                    assertThat(actualBody.substring(0, 40)).isEqualTo(body);
                } else if (header.contains("Загрузить шаблон с акцией")) {
                    wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(".//h4[@class='rs-modal-title']/div[2]")), "TestManual"));
                    log.info("Заголовок на странице: " + фотоотчеты_page.getModalTitleList());
                    assertThat(фотоотчеты_page.getModalTitleList()).contains(header);
                    assertThat(фотоотчеты_page.getModalTitleList()).contains(body);
                } else if (header.contains("Вы уверены?")) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h4[.='Вы уверены?']")));
                    log.info("Заголовок на странице: " + фотоотчеты_page.getModalTitleList());
                    assertThat(фотоотчеты_page.getModalTitleList()).contains(header);
                    фотоотчеты_page.waitForTextInWebElementToBePresent(фотоотчеты_page.modalContainerBody);
                    log.info("Текст в модально окне: " + фотоотчеты_page.modalContainerBody.getText());
                    assertThat(фотоотчеты_page.modalContainerBody.getText()).contains(body);
                } else {
                    assertThat(false).isTrue();
                }
                break;
        }

        }else {
            assertThat(true).isFalse();
        }

         */
    }

    @And("Progress bar is displayed")
    public void progressBarIsDisplayed() {

        /*
        моиАП_page.waitForProgressiveBar();
        log.info("Отразилась полоса загрузки со стартовой точкой 0");
        assertThat(моиАП_page.progressiveBar.isDisplayed()).isTrue();
        wait.until(ExpectedConditions.attributeToBe(моиАП_page.progressiveBar, "aria-valuenow", "100"));
        assertThat(моиАП_page.progressiveBar.getAttribute("aria-valuenow").equals("100"));

         */

    }

    @And("Validation notification appears: {string}")
    public void validationNotificationAppears(String message) {

        /*
               wait.until(ExpectedConditions.visibilityOf(всеРК_page.уведомление));
        assertThat(всеРК_page.уведомление.getText()).isEqualTo(message);
        wait.until(ExpectedConditions.invisibilityOf(всеРК_page.уведомление));

         */
    }

    @And("File with the name {string} is downloaded to the designated space on the local computer.")
    public void fileWithTheNameIsDownloadedToTheDesignatedSpaceOnTheLocalComputer(String fileName) {

        /*
        String expectedNameOfDownloadFile = "";

        if (fileType.equals("Primary")) {
            expectedNameOfDownloadFile = fileName + dataUtils.getTodayDate();
        } else {
            expectedNameOfDownloadFile = fileName;
        }

        System.out.println("Ожидаемое имя "+ expectedNameOfDownloadFile);

        if ("local".equals(profilesSetUp.getActiveProfile())) {
            File dir = new File("C:\\Users\\user002107\\Downloads");
            File[] dirContents = dir.listFiles();

            log.info("Список файлов в директории: " + Arrays.toString(dirContents));

            for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().contains(expectedNameOfDownloadFile)) {
                    log.info("Файл " + dirContents[i].getName() + " присуствует в директории " + Arrays.toString(dirContents));
                    assertThat(true).isTrue();
                    dirContents[i].delete();
                    break;
                }
                if (i == dirContents.length - 1 && dirContents[i].getName().contains(expectedNameOfDownloadFile) == false) {
                    log.info("Файла нет в директории: " + Arrays.toString(dirContents));
                    assertThat(false).isTrue();
                }

            }


        } else if ("remote".equals(profilesSetUp.getActiveProfile())) {
            File dir = new File("/root/Downloads");
            File[] dirContents = dir.listFiles();

            log.info("Список файлов в директории: " + Arrays.toString(dirContents));

            for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().contains(expectedNameOfDownloadFile)) {
                    log.info("Файл " + dirContents[i].getName() + " присуствует в директории " + Arrays.toString(dirContents));
                    assertThat(true).isTrue();
                    dirContents[i].delete();
                    break;
                }
                if (i == dirContents.length - 1 && dirContents[i].getName().contains(expectedNameOfDownloadFile) == false) {
                    log.info("Файла нет в директории: " + Arrays.toString(dirContents));
                    assertThat(false).isTrue();
                }
            }

        } else {
            assertThat(false).isTrue();
        }


         */
    }

}
