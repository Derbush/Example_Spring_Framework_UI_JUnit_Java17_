package SpringTestProject.pages;

import SpringTestProject.utilities.annotations.LazyComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@LazyComponent
public class LoginPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "//input[@class='gNO89b']")
    public WebElement user_login;

    @FindBy(how = How.XPATH, using = "//div[@id='SIvCob']")
    public WebElement password;


    @FindBy(how = How.XPATH, using = "//a[@class='pHiOh']")
    public WebElement login_btn;


}
