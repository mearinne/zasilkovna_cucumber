package step_definitions;

import _web_mapping.admin_zas;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class universalSteps {

    WebDriver webDriver = new ChromeDriver();

    @Given("^Open \"([^\"]*)\" page$")
    public void openPage(String page){
        String url = getUrl(page);
        if(url !=null){
            webDriver.get(admin_zas.admin_zas);
        }
        else {
            throw new IllegalArgumentException("The page "+page + " has not been configured yet");
        }
    }

    @Given("Close the browser")
    public void closeBrowser(){
        webDriver.quit();
    }

    @Then("^Fill into input \"([^\"]*)\" your value \"([^\"]*)\"$")
    public void fillIntoInput(String inputName,String value){
        WebElement webElement = getElementByName(inputName);
        if(webElement != null){
            webElement.sendKeys(value);
        }
        else {
            throw new IllegalArgumentException("WebElement "+inputName + " does not exist");
        }
    }

    @Then("^Click on the \"([^\"]*)\" button$")
    public void clickOnElement(String buttonName){
        WebElement webElement = getElementByName(buttonName);
        if(webElement != null){
            webElement.click();
        }
        else {
            throw new IllegalArgumentException("WebElement "+buttonName + " does not exist");
        }
    }
    @Then("^Wait on the element \"([^\"]*)\"$")
    public void waitOn(String targetEl){
        WebElement webElement = getElementByName(targetEl);
        if(webElement != null){
            WebDriverWait wait = new WebDriverWait(webDriver,20);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        }
        else {
            throw new IllegalArgumentException("WebElement "+targetEl + " does not exist");
        }
    }

    @Then("^Click on the link \"([^\"]*)\"$")
    public void linkClicked(String link){
        WebElement webElement = getElementByLink(link);
        if(webElement !=null){
            webElement.click();
        }
        else {
            throw new IllegalArgumentException("Link "+link + " does not exist or it has not been configured yet");
        }
    }

    private WebElement getElementByName(String myElement){
        WebElement element = null;
        switch (myElement){
            case "admin login":
                element = webDriver.findElement(By.name(admin_zas.admin_login));
                return element;
            case "admin password":
                element = webDriver.findElement(By.name(admin_zas.admin_password));
                return element;
            case "admin submit":
                element = webDriver.findElement(By.name(admin_zas.admin_submit));
                return element;
        }
        return element;
    }

    private WebElement getElementByLink(String myElement){
        WebElement element = null;
        switch (myElement){
            case "Zásilky":
                element = webDriver.findElement(By.linkText(myElement));
                return element;
            case "C2C Přehled":
                element = webDriver.findElement(By.linkText(myElement));
                return element;
        }
        return element;
    }


    private String getUrl(String myUrl){
        switch (myUrl){
            case "admin dev":
               return admin_zas.admin_zas;
        }
        return null;
    }

}
