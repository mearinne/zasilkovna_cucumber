package step_definitions;

import Configuration.DBconnection;
import _web_mapping.admin_zas;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Da;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class universalSteps {

    WebDriver webDriver = new ChromeDriver();

    private Map<String,String> testContext = new HashMap<>();

    private String [] alphabet = {"a","b","c","d","e","f","g","h","i","j",
                                  "k","l","m","n","o","p","q","r","s","t",
                                  "u","v","w","x","z"};

    @Given("^Open \"([^\"]*)\" page$")
    public void openPage(String page) {
        String url = getUrl(page);
        if (url != null) {
            webDriver.get(admin_zas.admin_zas);
        } else {
            throw new IllegalArgumentException("The page " + page + " has not been configured yet");
        }
    }

    @Given("Close the browser")
    public void closeBrowser() {
        webDriver.quit();
    }

    @Then("^Fill into input \"([^\"]*)\" your value \"([^\"]*)\"$")
    public void fillIntoInput(String inputName, String value) {
        WebElement webElement = getElementByName(inputName);
        if (webElement != null) {
            webElement.sendKeys(value);
        } else {
            throw new IllegalArgumentException("WebElement " + inputName + " does not exist");
        }
    }

    @Then("^Click on the \"([^\"]*)\" button$")
    public void clickOnElement(String buttonName) {
        WebElement webElement = getElementByName(buttonName);
        if (webElement != null) {
            webElement.click();
        } else {
            throw new IllegalArgumentException("WebElement " + buttonName + " does not exist");
        }
    }

    @Then("^Wait on the element \"([^\"]*)\"$")
    public void waitOn(String targetEl) {
        WebElement webElement = getElementByName(targetEl);
        if (webElement != null) {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } else {
            throw new IllegalArgumentException("WebElement " + targetEl + " does not exist");
        }
    }

    @Then("^Click on the link \"([^\"]*)\"$")
    public void linkClicked(String link) {
        WebElement webElement = getElementByLink(link);
        if (webElement != null) {
            webElement.click();
        } else {
            throw new IllegalArgumentException("Link " + link + " does not exist or it has not been configured yet");
        }
    }

    @Then("Perform this query")
    public void queryExecution(DataTable table) throws Exception {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String myQuery = getStringFromList(rows);
        DBconnection dBconnection = new DBconnection(myQuery);
        System.out.println(dBconnection.getQueryResult());

    }
    @Then("^Performation of this query and result save to context \"([^\"]*)\"$")
    public void saveValToContext( String value,DataTable table) throws Exception {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String myQuery = getStringFromList(rows);
        DBconnection dBconnection = new DBconnection(myQuery);
        testContext.put(value,dBconnection.getQueryResult());
        System.out.println(dBconnection.getQueryResult());
    }

    @Then("Compare two values")
    public void compareValues(DataTable table)
    {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        compareTwoVals(rows);
    }



    @Given("^Generate random String with length \"(\\d+)\" and save it to context \"([^\"]*)\"$")
    public void stringGeneration(int length, String contextName){
        if(length<=0) throw new IllegalArgumentException("The length must be at least 1 or higher !");
        StringBuilder builder = new StringBuilder();
      for(int i = 0; i< length; i++){
          int rndNum = getRandomNumber(0,alphabet.length-1);
          String letter = alphabet[rndNum];
          builder.append(letter);
      }
        System.out.println("+++++ "+builder.toString());
        testContext.put(contextName,builder.toString());
    }


    public int getRandomNumber(int min, int max){
        return (int)((Math.random() * (max - min))+min);
    }

    private WebElement getElementByName(String myElement) {
        WebElement element = null;
        switch (myElement) {
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

    private WebElement getElementByLink(String myElement) {
        WebElement element = null;
        switch (myElement) {
            case "Zásilky":
                element = webDriver.findElement(By.linkText(myElement));
                return element;
            case "C2C Přehled":
                element = webDriver.findElement(By.linkText(myElement));
                return element;
        }
        return element;
    }

    private String getUrl(String myUrl) {
        switch (myUrl) {
            case "admin dev":
                return admin_zas.admin_zas;
        }
        return null;
    }

    private String getStringFromList(List<Map<String, String>> myList) {
        StringBuilder builder = new StringBuilder();

        for (Map<String, String> myMap : myList) {
            for (Map.Entry<String, String> entry : myMap.entrySet()) {
                String row = entry.getValue();
                builder.append(row);
            }
        }
        return builder.toString();
    }



    private void compareTwoVals(List<Map<String, String>> myList){
        List<String>values = new ArrayList<>();
        for (Map<String, String> myMap : myList) {

            for(Map.Entry<String,String> entry : myMap.entrySet() ){
                values.add(entry.getValue());
            }
        }
        if(values.isEmpty()) {throw new IllegalArgumentException("List is empty !!!");}
        else {
            for(int i = 0; i< values.size(); i++){
                if(i+1 <= values.size()-1){
                    String val_1 = values.get(i);
                    String val_2 =values.get(i+1);

                    if(val_1.charAt(0)=='@'){
                        val_1 = testContext.get(val_1);
                    }
                    if(val_2.charAt(0)=='@'){
                        val_2 = testContext.get(val_2);
                    }

                    if(!val_1.equals(val_2)){
                        throw new IllegalArgumentException("value "+val_1 + " is not equaled to "+val_2);
                    }

                }
            }
        }
    }


}
