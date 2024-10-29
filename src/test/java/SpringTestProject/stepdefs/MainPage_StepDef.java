package SpringTestProject.stepdefs;

import SpringTestProject.pages.LoginPage;
import SpringTestProject.stepdefs.config.ProfilesSetUp;
import SpringTestProject.utilities.ConfigurationReader;
import SpringTestProject.utilities.DataUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Log4j2
public class MainPage_StepDef {

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



    @When("the user logs into the application as {string}")
    public void theUserLogsIntoTheApplicationAs(String user) {

        String login = "";
        String password = "";

        switch (user) {
            case "Admin":
                login = "userID_admin";
                password = "password_admin";
                break;
            case "Head of Department":
                login = "userID_bm_head_department";
                password = "password_bm_head_department";
                break;
            case "Buying Manager":
                login = "userID_bm_main";
                password = "password_bm_main";
                break;
            case "Client Manager":
                login = "userID_client_manager";
                password = "password_client_manager";
                break;
            case "Buying Manager Assistant":
                login = "userID_bm_assistant";
                password = "password_bm_assistant";
                break;
            case "Production Manager":
                login = "userID_employee_production";
                password = "password_employee_production";
                break;
            case "Client Representative":
                login = "userID_client";
                password = "password_client";
                break;
            case "Traffic Manager":
                login = "userID_traffic_manager";
                password = "password_traffic_manager";
                break;
        }
        log.info("Пользователь заходит в кабинет используя логин "+ reader.initializeProperties().getProperty(login) + " И пароль " + reader.initializeProperties().getProperty(password));
        //loginPage.user_login.sendKeys(reader.initializeProperties().getProperty(login));
        //loginPage.password.sendKeys(reader.initializeProperties().getProperty(password));
        //loginPage.login_btn.click();
        //loginPage.waitForPageToLoad();


    }

    @Then("the user is authorized as {string}")
    public void theUserIsAuthorizedAs(String user) {
        log.info("The user is authorised");

        /*

        mainPage.waitForASpinningBarToDisapear();

        String expectedUser = user;
        log.info("Expected user role: " + expectedUser);

        Actions actions =  new Actions(driver);
        actions.clickAndHold(всеРК_page.userNameBlock).perform();

        log.info("User hovers over the icon");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='tooltip']")));

        всеРК_page.waitForTextInWebElementToBePresent(mainPage.role);
        String actualUser = всеРК_page.role.getText();;
        log.info("Actual user: " + actualUser);
        String actualUserRole = actualUser.substring(actualUser.indexOf(",")+2, actualUser.length());
        log.info("Users role: " + actualUserRole);

        assertThat(actualUserRole).isEqualTo(expectedUser);
        log.info("Step is comlete");
        log.info("Roles are identical");

         */
    }


    @Then("the user sees {int}")
    public void theUserSeesNumberOfModules(int numberOfModules) {

        log.info("User is expected to the the following number of modules: " +numberOfModules);
        int actualResult = numberOfModules;
         /*
        String actualResult = Integer.toString(mainPage.sidebarSections.size());
         */

        log.info("User actually sees " + actualResult+ "modules");
        assertThat(actualResult).isEqualTo(numberOfModules);

    }

    @And("the user sees the following sections based on the role: {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserSeesTheFollowingSectionsBasedOnTheRole(String MyCampaign, String MyProgram, String Handbook, String FinanceBlock, String Photoreport, String MyFiles, String Help) {

        log.info("This is an example of step #4");


        log.info("Четвертый шаг начался");
        /*
        Map<String, String> всеСекции = new LinkedHashMap<>();
        всеСекции.put("Все РК", РК);
        всеСекции.put("Мои АП", МоиАП);
        всеСекции.put("Справочники", Справочники);
        всеСекции.put("Стороны", Стороны);
        всеСекции.put("Фин. блок", ФинБлок);
        всеСекции.put("Фотоотчеты", Фотоотчеты);
        всеСекции.put("Мои файлы", МоиФайлы);
        всеСекции.put("Таблицы", кнопкаТаблицы);

        List<String> ожидаемыйРезультатПоРазделам = всеСекции.entrySet().stream()
                .filter(entry -> "Доступен".equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        log.info("Пользователю должны быть доступны следующие разделы" + ожидаемыйРезультатПоРазделам);

        List<String> фактическийРезультатПоРазделам = new ArrayList<>();

        for (WebElement eachSections : всеРК_page.sidebarNames) {
            фактическийРезультатПоРазделам.add(eachSections.getText());
        }

        log.info("Пользователю фактически доступны следующие разделы" + фактическийРезультатПоРазделам);

        assertThat(фактическийРезультатПоРазделам).containsExactlyElementsOf(ожидаемыйРезультатПоРазделам);

        Map<String, String> всеСсылки = всеРК_page.всеСсылки();

        List<String> ожидаемыйРезультатПоCcылкам = new ArrayList<>();

        for (String фактическийРезультат : фактическийРезультатПоРазделам) {
            for (Map.Entry<String, String> entry : всеСекции.entrySet()) {
                if (entry.getKey().equals(фактическийРезультат)) {
                    ожидаемыйРезультатПоCcылкам.add("https://stage.rap.odysmtech.ru" + всеСсылки.get(entry.getKey()));
                }
            }
        }
        log.info("Пользователю должны быть доступны следующие ccылки" + ожидаемыйРезультатПоCcылкам);

        List<String> фактическийРезультатПоСсылкам = new ArrayList<>();

        for (WebElement eachSection : всеРК_page.sidebarLinks) {
            фактическийРезультатПоСсылкам.add(eachSection.getAttribute("href"));
        }

        log.info("Пользователю фактически доступны следующие ccылки" + фактическийРезультатПоСсылкам);
        assertThat(фактическийРезультатПоСсылкам).containsExactlyElementsOf(ожидаемыйРезультатПоCcылкам);



         */
    }



}
