package step_definitions;

import Configuration.DBconnection;
import _web_mapping.admin_zas;
import _web_mapping.admin_zas_Standa;
import _web_mapping.platebni_brana;
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

    private Map<String, String> testContext = new HashMap<>();

    private final String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "z"};

    @Given("^Open \"([^\"]*)\" page$")
    public void openPage(String page) {
        String url = getUrl(page);
        if (url != null) {
            webDriver.get(getUrl(page));
        } else {
            throw new IllegalArgumentException("The page " + page + " has not been configured yet");
        }
    }

    @Given("Close the browser")
    public void closeBrowser() {
        webDriver = new ChromeDriver();
        webDriver.quit();
    }

    @Then("^Fill into input \"([^\"]*)\" your value \"([^\"]*)\"$")
    public void fillIntoInput(String inputName, String value) {
        WebElement webElement = getElement(inputName);
        if (webElement != null) {
            String pure = getPureStringValue(value);
            webElement.sendKeys(pure);
        } else {
            throw new IllegalArgumentException("WebElement " + inputName + " does not exist");
        }
    }

    @Then("^Click on the \"([^\"]*)\" button$")
    public void clickOnElement(String buttonName) {
        WebElement webElement = getElement(buttonName);
        if (webElement != null) {
            webElement.click();
        } else {
            throw new IllegalArgumentException("WebElement " + buttonName + " does not exist");
        }
    }

    @Then("^Wait on the element \"([^\"]*)\"$")
    public void waitOn(String targetEl) {
        WebElement webElement = getElement(targetEl);
        if (webElement != null) {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } else {
            throw new IllegalArgumentException("WebElement " + targetEl + " does not exist");
        }
    }

    @Then("^Wait on the link \"([^\"]*)\"$")
    public void waitOnLink(String targetEl) {
        WebElement webElement = getElementByLink(targetEl);
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
        System.out.println("MY QUERY: "+myQuery);
        DBconnection dBconnection = new DBconnection(myQuery);
        System.out.println(dBconnection.getQueryResult());

    }

    @Then("^Performation of this query and result save to context \"([^\"]*)\"$")
    public void saveValToContext(String value, DataTable table) throws Exception {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String myQuery = getStringFromList(rows);
        DBconnection dBconnection = new DBconnection(myQuery);
        testContext.put(value, dBconnection.getQueryResult());
        System.out.println("-x-x-x- "+dBconnection.getQueryResult()+" -x-x-x-");
    }

    @Then("Compare two values")
    public void compareValues(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        compareTwoVals(rows);
    }

    @Given("Save a values into context")
    public void saveValues(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        saveValuesIntoContext(rows);
    }

    @Given("^Generate random String with length \"(\\d+)\" and save it to context \"([^\"]*)\"$")
    public void stringGeneration(int length, String contextName) {
        if (length <= 0) throw new IllegalArgumentException("The length must be at least 1 or higher !");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int rndNum = getRandomNumber(0, alphabet.length - 1);
            String letter = alphabet[rndNum];
            builder.append(letter);
        }
        System.out.println("+++++ " + builder.toString());
        testContext.put(contextName, builder.toString());
    }

    @Then("^Write out context value \"([^\"]*)\"$")
    public void writeOut(String string){
       String val = getValueFromContext(string);
        System.out.println("Toto jsem dostal: "+val);
    }

    @Then("Get val")
    public void getVal(){
        System.out.println(getTextFromElement());
    }

    @Then("^Wait for \"(\\d+)\" seconds$")
    public void waitFor(int sec){
        int waitingTime = sec*1000;
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private WebElement getElement(String myElement) {
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
            case "promocode":
                element = webDriver.findElement(By.name(admin_zas_Standa.promoCodeInput));
                return element;
            case "street":
                element = webDriver.findElement(By.name(admin_zas_Standa.streatInput));
                return element;
            case "city":
                element = webDriver.findElement(By.name(admin_zas_Standa.cityInput));
                return element;
            case "zip":
                element = webDriver.findElement(By.name(admin_zas_Standa.zipInput));
                return element;
            case "submit":
                element = webDriver.findElement(By.name(admin_zas_Standa.submitButt));
                return element;
            case "card number":
                element = webDriver.findElement(By.name(platebni_brana.cardNumber));
                return element;
            case "expiration":
                element = webDriver.findElement(By.id(platebni_brana.expiration));
                return element;
            case "cvc":
                element = webDriver.findElement(By.id(platebni_brana.cvc));
                return element;
            case "price":
                element = webDriver.findElement(By.className(platebni_brana.price));
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
            case "C2C v6":
                element = webDriver.findElement(By.linkText(myElement));
                return element;
            case "Create C2C packet":
                element = webDriver.findElement(By.linkText(myElement));
                return element;
            case "Payment link":
                element = webDriver.findElement(By.linkText(myElement));
                return element;

        }
        return element;
    }

    private String getTextFromElement(){
        WebElement element = webDriver.findElement(By.id("dropdown01"));
        return "|"+element.getText()+"|";
    }

    private String getUrl(String myUrl) {
        switch (myUrl) {
            case "admin dev":
                return admin_zas.admin_zas;
            case "admin packet dev":
                return admin_zas_Standa.adminUrl;
        }

        return null;
    }

    private String getStringFromList(List<Map<String, String>> myList) {
        StringBuilder builder = new StringBuilder();

        for (Map<String, String> myMap : myList) {
            for (Map.Entry<String, String> entry : myMap.entrySet()) {
                String row = entry.getValue();
                String [] words = row.split(" ");
                if(words.length>0){
                    for(int i = 0; i<words.length;i++){
                        if(words[i].charAt(0)=='@'){
                            String sub = words[i].substring(1);
                            String val = testContext.get(sub);
                         row =  row.replaceAll(words[i],val);
                        }
                        else if(words[i].charAt(0)=='\'' && words[i].charAt(1)=='@'){
                            int lengthOfString = words[i].length();
                            String sub = words[i].substring(2,lengthOfString-1);
                            String val = testContext.get(sub);
                            String corrected = "'"+val+"'";
                            row =  row.replaceAll(words[i],corrected);
                        }
                    }
                }else throw new IllegalArgumentException("Invalid query !!!");
                builder.append(row);
            }
        }
        return builder.toString();
    }

    private void saveValuesIntoContext(List<Map<String, String>> myList) {
        List<String> values = new ArrayList<>();

        for (Map<String, String> myMap : myList) {
            for (Map.Entry<String, String> entry : myMap.entrySet()) {
                values.add(entry.getValue());
            }
        }
        //if(values.size()<4) throw new IllegalArgumentException("Columns cannot be empty !!");
        for(int i = 0; i<values.size(); i++){
            if(i+1 <= values.size()-1){
                testContext.put(values.get(i),values.get(i+1));
            }
        }
    }

    private String getValueFromContext(String key){
        String val = null;
        try {
            String sub = key.substring(1);
            System.out.println("----- "+sub+" -----");
            val = testContext.get(sub);
            System.out.println("Hodnota z contextu: "+val);
        }catch (Exception e){
            System.out.println("This context name does not exist !!!");
        }
        return val;
    }

    private void compareTwoVals(List<Map<String, String>> myList) {
        List<String> values = new ArrayList<>();
        for (Map<String, String> myMap : myList) {

            for (Map.Entry<String, String> entry : myMap.entrySet()) {
                values.add(entry.getValue());
            }
        }
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty !!!");
        } else {

            for (int i = 0; i < values.size(); i++) {
                if (i + 1 <= values.size() - 1) {
                    System.out.println("i ="+i+" value "+values.get(i));
                    String val_1 = values.get(i);
                    String val_2 = values.get(i + 1);

                    System.out.println("=== "+val_1+" | "+val_2+" ===");

                    if (val_1.charAt(0) == '@') {
                        String sub = val_1.substring(1);
                        val_1 = testContext.get(sub);
                    }
                    if (val_2.charAt(0) == '@') {
                        String sub = val_2.substring(1);
                        val_2 = testContext.get(sub);
                    }
                    if( (i+1)%2 !=0) {
                        if (!val_1.equals(val_2)) {
                            throw new IllegalArgumentException("value " + val_1 + " is not equaled to " + val_2);
                        }
                    }
                }
            }
        }
    }

    private String getPureStringValue(String myText){
        String value = myText;
        for (Map.Entry<String, String> entry : testContext.entrySet()) {
            String key = entry.getKey();
            String mySub =value.substring(1);
            if(mySub.equals(key)){
                if(value.charAt(0)=='@'){
                        String val = testContext.get(mySub);
                        value =  myText.replaceAll(myText,val);
                    }
                }
        }
        return value;
    }


}
