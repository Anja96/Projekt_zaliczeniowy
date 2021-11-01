package zadanie2.anna.trybus;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class BuyingItem {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        //logowanie
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("anna.echelon6277@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("536294637");

        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        signIn.click();

        WebElement searchOurCatalog = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
        searchOurCatalog.sendKeys("Hummingbird Printed Sweater");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/button"));
        searchButton.click();

        WebElement productItem = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a"));
        productItem.click();

        Select chooseSize = new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
        chooseSize.selectByVisibleText("M");

        Thread.sleep(100);
        WebElement quantityWanted = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]"));
        Thread.sleep(100);
        quantityWanted.click();
        Thread.sleep(100);
        quantityWanted.click();
        Thread.sleep(100);
        quantityWanted.click();
        Thread.sleep(100);
        quantityWanted.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement proceedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")));
        proceedToCheckout.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        checkoutButton.click();

        WebElement continueButton = driver.findElement(By.name("confirm-addresses"));
        continueButton.click();

       WebElement prestaShopButton = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div/div[1]/div/div/span"));
       prestaShopButton.click();

       WebElement continueButton2 = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
       continueButton2.click();

       WebElement payByCheckRadio = driver.findElement(By.id("payment-option-1"));
       payByCheckRadio.click();

       WebElement agreeCheckBox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
       agreeCheckBox.click();

       WebElement order = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
       order.click();


        TakesScreenshot scrShot =((TakesScreenshot)driver);
        byte[] srcFile = scrShot.getScreenshotAs(OutputType.BYTES);
        OutputStream out = new FileOutputStream(new File("/Users/anna/Downloads/seleniumScreenshots/screenshot.png"));
        out.write(srcFile);
        out.close();

        driver.quit();

    }
}
