package SpringTestProject.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.NoSuchElementException;

public abstract class AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);
    @Autowired
    protected WebDriver driver;

    @Autowired
    WebDriverWait wait;

    @Autowired
    protected JavascriptExecutor javascriptExecutor;

    private Actions act;


    @PostConstruct
    public void init() {
        PageFactory.initElements(this.driver, this);
        this.act = new Actions(this.driver);
    }

    public void waitForTextInWebElementToBePresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(driver-> !element.getText().trim().isEmpty());
    }
    public String getTextInWebElement(WebElement element){
        wait.until(driver-> !element.getText().trim().isEmpty());
        return element.getText();
    }

    public void hoverOverElement(WebElement element){
        act.moveToElement(element).perform();
    }


    public void waitElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }


    public void waitElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public boolean isElementExist (String locator){
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver.findElement(By.xpath(locator));
                return true;
            } catch (NoSuchElementException e){
                attempts++;
            }
        }
        return false;
    }

    public boolean isElementNotStale (By by){
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver.findElement(by);
                return true;
            } catch (StaleElementReferenceException e){
                attempts++;
            }
        }
        return false;
    }


    public void clickOnTheWebElement(String locator){
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement element = driver.findElement(By.xpath(locator));
                element.click();
                break;
            } catch (ElementClickInterceptedException e) {
                attempts++;
            } catch (StaleElementReferenceException e1) {
                attempts++;
            }
        }
    }

    public void waitForPageToLoad() {
        wait.until(
                webDriver -> javascriptExecutor.executeScript("return document.readyState").equals("complete"));

    }

    public void waitForModel(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("rs-modal-dialog")));
    }

    public int isLinkActive(String link) throws IOException {
        HttpURLConnection con = null; // interface
        String url = link;
        int respCode = 0;

        if(url!=null&&!url.contains("javascript")){// if url contain javascript it will fail
            con = (HttpURLConnection)(new URL(url)).openConnection(); // create Obj
            try{
                con.connect();
                con.setConnectTimeout(10000);
                respCode = con.getResponseCode();
                System.out.println("Connection Status For URL: "+ url +" is: " +respCode);
            }catch (ConnectException e){
                System.out.println("Connection Status For URL: "+ url +" is: ConnectException" );
            }
        }
        con.disconnect();
        return respCode;

    }

    public void waitForASpinningBarToDisapear(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class ='rs-loader']"))));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class ='rs-loader']")));
    }

}