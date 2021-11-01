package com.anna.trybus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressFormTest {
    private WebDriver driver;

    @Given("użytkownik {string} zalogowany haslem {string}")
    public void użytkownikZalogowany(String nazwaUżytkownika, String hasło) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(nazwaUżytkownika);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(hasło);

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        signInButton.click();

        WebElement addFirstAddress = driver.findElement(By.xpath("//*[@id=\"address-link\"]"));
        addFirstAddress.click();
    }

    @And("uzytkownik wpisuje {string}, {string}, {string}, {string}, {string}, {string}")
    public void dodawanieAdresu(String alias, String adres, String kodpocztowy, String miasto, String państwo, String phone) {


        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);

        WebElement AddressInput = driver.findElement(By.name("address1"));
        AddressInput.sendKeys(adres);

        WebElement zipcodeInput = driver.findElement(By.name("postcode"));
        zipcodeInput.sendKeys(kodpocztowy);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(miasto);

        Select countrySelect = new Select(driver.findElement(By.name("id_country")));
        countrySelect.selectByVisibleText(państwo);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys(phone);

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click();
    }


    @When("formularz wypelniony")
    public void formularzwypelniony() {

    }

    @Then("adres dodany")
    public void adresDodany() {
        WebElement resultMessage = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        String resultMessageText = resultMessage.getText();
        Assert.assertEquals("Address successfully added!", resultMessageText);
        //driver.close();

    }
}
