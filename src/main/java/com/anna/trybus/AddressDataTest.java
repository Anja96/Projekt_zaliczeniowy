package com.anna.trybus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressDataTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");


        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("anna.echelon6277@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("536294637");

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        signInButton.click();

        //kliknięcie w kafelek addresses
        WebElement addFirstAddress = driver.findElement(By.xpath("//*[@id=\"address-link\"]"));
        addFirstAddress.click();

        // formularz adresowy

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys("My new address");

        WebElement AddressInput = driver.findElement(By.name("address1"));
        AddressInput.sendKeys("Koszykowa 1");

        WebElement zipcodeInput = driver.findElement(By.name("postcode"));
        zipcodeInput.sendKeys("32-645");

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys("London");

        Select countrySelect = new Select(driver.findElement(By.name("id_country")));
        countrySelect.selectByVisibleText("United Kingdom");

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys("654234178");

       WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
       saveButton.click();
    }
}